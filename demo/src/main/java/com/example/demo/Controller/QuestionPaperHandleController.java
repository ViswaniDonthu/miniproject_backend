package com.example.demo.Controller;

import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Service.QuestionPaperService;
import com.example.demo.Service.QuestionPaperSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin(origins="*")
@Controller
public class QuestionPaperHandleController {
    @Autowired
    private AuthController controller;
    @Autowired
    private QuestionPaperRepo questionPaperRepository;
  @Autowired
  private QuestionPaperService questionPaperService;
    @GetMapping("/pendingpapers")
    public ResponseEntity<?> pendingpapers(@RequestHeader("Authorization") String token) {
        boolean isOk = false;

        // Assuming verifyAdminToken expects a Map, wrap token in a Map
        Map<String, String> payload = new HashMap<>();
        payload.put("token", token.replace("Bearer ", ""));
        ResponseEntity<?> response = controller.verifyAdminToken(payload);
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
            isOk = (boolean) responseBody.get("ok");
        }
        if (!isOk) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid or expired token", "ok", false));
        }
       return handlepaperfilter(false);
    }
    @GetMapping("/approvedpapers")
    public ResponseEntity<?> approvedpapers(){
//        boolean isOk = false;
//
//        // Assuming verifyAdminToken expects a Map, wrap token in a Map
//        Map<String, String> payload = new HashMap<>();
//        payload.put("token", token.replace("Bearer ", ""));
//        ResponseEntity<?> response = controller.verifyAdminToken(payload);
//        if (response.getStatusCode() == HttpStatus.OK) {
//            Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
//            isOk = (boolean) responseBody.get("ok");
//        }
//        if (!isOk) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("message", "Invalid or expired token", "ok", false));
//        }
        return handlepaperfilter(true);
    }
    public ResponseEntity<?> handlepaperfilter(boolean isaccept){
        List<QuestionPaper> papers = questionPaperRepository.findAll(
                QuestionPaperSpecification.filterByCriteria(null, null, null, null, null, isaccept));

        List<Map<String, Object>> fileDataList = new ArrayList<>();

        for (QuestionPaper paper : papers) {
            Map<String, Object> fileMap = new HashMap<>();
            fileMap.put("id", paper.getId());
            fileMap.put("subject", paper.getSubject().getSubjectName());
            fileMap.put("academicYear", paper.getAcademicyear().getAcademicYear());
            fileMap.put("branch", paper.getSubject().getBranch().getBranch());
            fileMap.put("semester", paper.getSubject().getBranch().getSemester());
            fileMap.put("examType", paper.getExamType());
            fileMap.put("status","pending");
            try {
                File file = new File(paper.getFileUrl());
                FileInputStream fis = new FileInputStream(file);
                byte[] fileBytes = fis.readAllBytes();
                fis.close();

                String encodedFile = Base64.getEncoder().encodeToString(fileBytes);

                fileMap.put("fileName", file.getName());
                fileMap.put("fileData", encodedFile);
            } catch (IOException e) {
                System.out.println("File not found: " + paper.getFileUrl());
                fileMap.put("fileName", "File not found");
                fileMap.put("fileData", null);
            }

            fileDataList.add(fileMap);
        }

        return ResponseEntity.ok().body(fileDataList);
    }
   @PostMapping("/handleapprove")
    public ResponseEntity<?> approvepapers(@RequestBody Map<String,String>payload){
        boolean isOk=false;
       ResponseEntity<?> response = controller.verifyAdminToken(payload);
       if (response.getStatusCode() == HttpStatus.OK) {
           Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
           isOk = (boolean) responseBody.get("ok");
       }
       if (!isOk) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                   .body(Map.of("message", "Invalid or expired token", "ok", false));
       }
        Long id= Long.valueOf(payload.get("id"));
       QuestionPaper q=questionPaperService.updateStatus(id,true);
       return ResponseEntity.ok().body(q);
   }

}

