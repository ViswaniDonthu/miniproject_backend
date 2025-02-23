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

@CrossOrigin(origins = "http://localhost:5173")
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
    private AcademicServiceImpl academicyearservice;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam("academicYear") String academicYear,
                                        @RequestParam("branch") String branch,
                                        @RequestParam("subject") String subject,
                                        @RequestParam("type") String examType,
                                        @RequestParam("batch")String batch,
                                        @RequestParam("sem")int sem,
                                        @RequestParam("email")String email)
            throws IOException {
        if(Objects.equals(batch, "E2")){
            sem+=2;
        }else if(Objects.equals(batch,"E3")){
            sem+=4;
        }
        else if(Objects.equals(batch,"E4")){
            sem+=6;
        }
            Branch branchno=branchservice.findBranchId(branch,sem);
             Subject subjectid=subjectservice.findBySubjectId(subject,branchno);
             User userid=userservice.getUserId(email);
             if(Objects.equals(userid.getEmail(), " ")){
                 return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                         .body(Map.of("message", "please login to upload files."));
             }
             Academicyear academicyearid=academicyearservice.findYearId(academicYear);
          QuestionPaper savedPaper = questionPaperService.saveQuestionPaper(file, academicyearid, subjectid, examType,userid);
         return ResponseEntity.ok(savedPaper);

    }
}
