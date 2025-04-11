package com.example.demo.Controller;

import com.example.demo.Entity.*;

import com.example.demo.Model.UserDTO;
import com.example.demo.Repo.QuestionPaperRepo;

import com.example.demo.Service.*;
import com.example.demo.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/uploads")
public class UploadController {
    @Autowired
    private SubjectServiceImpl subjectservice;
    @Autowired
    private QuestionPaperService questionPaperService;
    @Autowired
    private BranchServiceImpl branchservice;
//    @Autowired
//    private UserServiceImpl userservice;
//    @Autowired
//    private AuthController authcontroller;
    @Autowired
    private AcademicServiceImpl academicyearservice;
    @Autowired
    private QuestionPaperRepo questionPaperRepo;
    @Autowired
    private RejectedPaperService rejectedPaperService;
    @Autowired
    private UserClient userClient;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam("academicYear") String academicYear,
                                        @RequestParam("Campus") String campus,
                                        @RequestParam("branch") String branch,
                                        @RequestParam("subject") String subject,
                                        @RequestParam("type") String examType,
                                        @RequestParam("batch") String batch,
                                        @RequestParam("sem") int sem,
                                        @RequestParam("token") String token,
                                        @RequestParam("formtype") String formtype )throws IOException {

        ResponseEntity<?> response = userClient.verifyToken(Map.of("token", token));
        Map<?, ?> responseBody = (Map<?, ?>) response.getBody();

        if (responseBody.containsKey("ok") && Boolean.FALSE.equals(responseBody.get("ok"))) {
            return ResponseEntity.ok(Map.of("message", "please login"));
        }
        int semester = sem;
        String email = (String) responseBody.get("email");
        if (Objects.equals(batch, "E2")) {
            sem += 2;
        } else if (Objects.equals(batch, "E3")) {
            sem += 4;
        } else if (Objects.equals(batch, "E4")) {
            sem += 6;
        }
        UserDTO userDTO = userClient.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (formtype.equalsIgnoreCase("rgukt")) {
            Branch branchno = branchservice.findBranchId(branch, sem);
            Subject subjectid = subjectservice.findBySubjectId(subject, branchno);

            Academicyear academicyearid = academicyearservice.findYearId(academicYear);
            boolean exists = questionPaperRepo.existsByAcademicyearAndExamTypeAndSubjectAndIsaccepted(
                    academicyearid, examType, subjectid, true
            );

            if (exists) {
                return ResponseEntity.ok(Map.of("message", "question paper already existed.."));
            }
            String filename = subject + "_" + branch + "_" + batch + "_" + "sem" + semester + "_" + examType + "_" + academicYear;
            QuestionPaper savedPaper = questionPaperService.saveQuestionPaper(file, academicyearid, subjectid, examType, userDTO, filename, campus);

            return ResponseEntity.ok(Map.of("message", "file uploaded successfully", "data", savedPaper));
        } else if (formtype.equalsIgnoreCase("nonrgukt")) {
            // Save the file and get the URL (same logic as your service)
            String filename = subject + "_" + branch + "_" + batch + "_" + "sem" + semester + "_" + examType + "_" + academicYear;
            NonRguktPaper savedPaper = questionPaperService.saveNonRguktQuestionPaper(file, academicYear, subject, examType, userDTO, filename, campus);

            return ResponseEntity.ok(Map.of("message", "Non-RGUKT paper uploaded", "data", savedPaper));

        }
        return null;
    }
    @PostMapping("/adminupload")
    public ResponseEntity<?> acceptRejectedPaper(@RequestBody String id) {
        System.out.println("in adminupload");
       RejectedPapers r= rejectedPaperService.fetchquestionpaper(Long.parseLong(id));
       QuestionPaper q=new QuestionPaper();
       q.setIsaccepted(true);
       q.setUploadedByUser(r.getUploadedByUser());
       q.setSubject(r.getSubject());
       q.setAcademicyear(r.getAcademicyear());
       q.setExamType(r.getExamType());
       q.setFileUrl(r.getFileUrl());
        boolean exists = questionPaperRepo.existsByAcademicyearAndExamTypeAndSubjectAndIsaccepted(
                q.getAcademicyear(),q.getExamType(),q.getSubject(),true
        );

        if (exists) {
            return ResponseEntity.ok(Map.of("message","paper already existed.."));
        }
       QuestionPaper q1=questionPaperRepo.save(q);
        UserDTO u=q1.getUploadedByUser();
        u.setContributions(u.getContributions()+1);
        userClient.saveUser(u);
       rejectedPaperService.deletequestionPaper(Long.parseLong(id));
        System.out.println("saved");
        return ResponseEntity.ok(Map.of("data",q1,"message","file uploaded successfully"));
}

}