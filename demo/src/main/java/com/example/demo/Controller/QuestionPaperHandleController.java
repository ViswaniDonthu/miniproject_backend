package com.example.demo.Controller;

import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Entity.RejectedPapers;

import com.example.demo.Entity.User;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Repo.RejectedPaperRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.QuestionPaperService;
import com.example.demo.Service.QuestionPaperSpecification;
import com.example.demo.Service.RejectedPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private RejectedPaperService rejectedPaperService;
    @Autowired
    private AuthController controller;
    @Autowired
    private QuestionPaperRepo questionPaperRepository;
    @Autowired
    private RejectedPaperRepo rejectedPaperRepo;
    @Autowired
    private UserRepo repo;
  @Autowired
  private QuestionPaperService questionPaperService;
    @GetMapping("/pendingpapers")
    public ResponseEntity<?> pendingpapers(@RequestHeader("Authorization") String token
                                           ,@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size) {
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
       return handlepaperfilter(false,page,size);
    }


    @GetMapping("/approvedpapers")
    public ResponseEntity<?> approvedpapers(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {

        return handlepaperfilter(true, page, size);
    }

    public ResponseEntity<?> handlepaperfilter(boolean isaccept, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<QuestionPaper> paperPage = questionPaperRepository.findAll(
                QuestionPaperSpecification.filterByCriteria(null, null, null, null, null, isaccept,null),
                pageable);

        List<Map<String, Object>> fileDataList = new ArrayList<>();

        for (QuestionPaper paper : paperPage.getContent()) {
            Map<String, Object> fileMap = new HashMap<>();
            fileMap.put("id", paper.getId());
            fileMap.put("subject", paper.getSubject().getSubjectName());
            fileMap.put("academicYear", paper.getAcademicyear().getAcademicYear());
            fileMap.put("branch", paper.getSubject().getBranch().getBranch());
            fileMap.put("semester", paper.getSubject().getBranch().getSemester());
            fileMap.put("examType", paper.getExamType());
            fileMap.put("status", "pending");

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

        Map<String, Object> response = new HashMap<>();
        response.put("papers", fileDataList);
        response.put("currentPage", paperPage.getNumber());
        response.put("totalItems", paperPage.getTotalElements());
        response.put("totalPages", paperPage.getTotalPages());

        return ResponseEntity.ok().body(response);
    }

   @GetMapping("/getrejectedpapers")
   public ResponseEntity<?> getrejectedpapers(@RequestHeader("Authorization") String token
           ,@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size){
       boolean isOk = false;

       // Assuming verifyAdminToken expects a Map, wrap token in a Map
       Map<String, String> payload = new HashMap<>();
       payload.put("token", token.replace("Bearer ", ""));
       ResponseEntity<?> response1= controller.verifyAdminToken(payload);
       if (response1.getStatusCode() == HttpStatus.OK) {
           Map<String, Object> responseBody = (Map<String, Object>) response1.getBody();
           isOk = (boolean) responseBody.get("ok");
       }
       if (!isOk) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                   .body(Map.of("message", "Invalid or expired token", "ok", false));
       }
       Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
       Page<RejectedPapers> paperPage = rejectedPaperRepo.findAll(pageable);

       List<Map<String, Object>> fileDataList = new ArrayList<>();
       System.out.println(paperPage);
       for (RejectedPapers paper : paperPage.getContent()) {
           Map<String, Object> fileMap = new HashMap<>();
           fileMap.put("id", paper.getId());
           fileMap.put("subject", paper.getSubject().getSubjectName());
           fileMap.put("academicYear", paper.getAcademicyear().getAcademicYear());
           fileMap.put("branch", paper.getSubject().getBranch().getBranch());
           fileMap.put("semester", paper.getSubject().getBranch().getSemester());
           fileMap.put("examType", paper.getExamType());
           fileMap.put("status", "pending");

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

       Map<String, Object> response = new HashMap<>();
       response.put("papers", fileDataList);
       response.put("currentPage", paperPage.getNumber());
       response.put("totalItems", paperPage.getTotalElements());
       response.put("totalPages", paperPage.getTotalPages());

       return ResponseEntity.ok().body(response);
   }

    @PostMapping("/rejectpapers")
    public ResponseEntity<?> rejectpapers(@RequestBody Map<String,String> payload){
        System.out.println("in reject papers");
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
        RejectedPapers q=rejectedPaperService.updatePaper(id);
        return ResponseEntity.ok().body(q);
    }
   @PostMapping("/handleapprove")
    public ResponseEntity<?> approvepaper(@RequestBody Map<String,String>payload){
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
       if(q==null){
           return ResponseEntity.ok(Map.of("message","question paper already exists"));
       }
       System.out.println(q.getUploadedBy());
       User u=q.getUploadedBy();

       u.setContributions(u.getContributions()+1);
       repo.save(u);
       return ResponseEntity.ok().body(q);
   }
//    @DeleteMapping("/deletepaper/{id}")
//    public ResponseEntity<?> deleteQuestionPaper(@PathVariable Long id) {
//        try {
//            Optional<RejectedPapers> paper = rejectedPaperRepo.findById(id);
//            if (paper.isPresent()) {
//                rejectedPaperRepo.deleteById(id);
//                return ResponseEntity.ok(Map.of("message", "Paper deleted successfully."));
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Paper not found."));
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Map.of("message", "Error deleting paper."));
//        }
//    }
}

