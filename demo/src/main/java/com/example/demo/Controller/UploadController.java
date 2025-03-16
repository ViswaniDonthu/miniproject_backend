package com.example.demo.Controller;

import com.example.demo.Entity.*;

import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private UserServiceImpl userservice;
    @Autowired
    private AuthController authcontroller;
    @Autowired
    private AcademicServiceImpl academicyearservice;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam("academicYear") String academicYear,
                                        @RequestParam("branch") String branch,
                                        @RequestParam("subject") String subject,
                                        @RequestParam("type") String examType,
                                        @RequestParam("batch") String batch,
                                        @RequestParam("sem") int sem,
                                        @RequestParam("token") String token) throws IOException {

        ResponseEntity<?> response = authcontroller.verifyToken(Map.of("token", token));
        Map<?, ?> responseBody = (Map<?, ?>) response.getBody();

        if (responseBody.containsKey("ok") && Boolean.FALSE.equals(responseBody.get("ok"))) {
            return ResponseEntity.ok(Map.of("message", "please login"));
        }
         int semester=sem;
        String email = (String) responseBody.get("email");
        if (Objects.equals(batch, "E2")) {
            sem += 2;
        } else if (Objects.equals(batch, "E3")) {
            sem += 4;
        } else if (Objects.equals(batch, "E4")) {
            sem += 6;
        }

        Branch branchno = branchservice.findBranchId(branch, sem);
        Subject subjectid = subjectservice.findBySubjectId(subject, branchno);
        User userid = userservice.getUserId(email);

        Academicyear academicyearid = academicyearservice.findYearId(academicYear);
        String filename=subject+"_"+branch+"_"+batch+"_"+"sem"+semester+"_"+examType+"_"+academicYear;
        QuestionPaper savedPaper = questionPaperService.saveQuestionPaper(file, academicyearid, subjectid, examType, userid,filename);

        return ResponseEntity.ok(savedPaper);
    }
}