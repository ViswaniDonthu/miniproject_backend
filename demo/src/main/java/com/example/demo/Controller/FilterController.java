package com.example.demo.Controller;

import com.example.demo.Entity.NonRguktPaper;
import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Repo.NonRguktQuestionPaperRepo;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Service.NonRguktQuestionPaperSpecification;
import com.example.demo.Service.QuestionPaperSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/questionpapers")
//public class FilterController {
//
//    private final QuestionPaperRepo questionPaperRepository;
//
//    public FilterController(QuestionPaperRepo questionPaperRepository) {
//        this.questionPaperRepository = questionPaperRepository;
//    }
//
//    @GetMapping("/filter")
//    public List<QuestionPaper> getFilteredPapers(
//            @RequestParam(required = false) List<String> academicYears,
//            @RequestParam(required = false) List<String> branches,
//            @RequestParam(required = false) List<Integer> semesters,
//            @RequestParam(required = false) List<String> subjectNames,
//            @RequestParam(required = false) List<String> examTypes
//    ) {
//        return questionPaperRepository.findAll(QuestionPaperSpecification.filterByCriteria(
//                academicYears, branches, semesters, subjectNames, examTypes));
//    }
//}
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/questionpapers")
public class FilterController {

    private final QuestionPaperRepo questionPaperRepository;

    public FilterController(QuestionPaperRepo questionPaperRepository) {
        this.questionPaperRepository = questionPaperRepository;
    }

    @Autowired
    private NonRguktQuestionPaperRepo repo;

    @GetMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> getFilteredPapers(
            @RequestParam(required = false) List<String> academicYears,
            @RequestParam(required = false) List<String> branches,
            @RequestParam(required = false) List<Integer> semesters,
            @RequestParam(required = false) List<String> subjectNames,
            @RequestParam(required = false) List<String> examTypes,
            @RequestParam(required = false) List<String> batches,
            @RequestParam(required = false) List<String> Campus,
            @RequestParam(required = false) List<String> collegeType) {
        System.out.println(collegeType);

        Map<String, Integer> batchIncrement = new HashMap<>();
        batchIncrement.put("E1", 0);
        batchIncrement.put("E2", 2);
        batchIncrement.put("E3", 4);
        batchIncrement.put("E4", 6);

        List<Integer> newSemesters = new ArrayList<>();
        if (batches != null && !batches.isEmpty() && semesters != null && !semesters.isEmpty()) {
            // Case 1: Both batches and semesters are provided
            for (String batch : batches) {
                int increment = batchIncrement.getOrDefault(batch, 0);
                for (int sem : semesters) {
                    newSemesters.add(sem + increment);
                }
            }
            semesters = newSemesters;
        }
        else if ((semesters != null && !semesters.isEmpty()) && (batches == null || batches.isEmpty())) {
            // Case 2: Semesters provided, but batches are empty
            for (int sem : semesters) {
                newSemesters.add(sem);        // E1 case
                newSemesters.add(sem + 2);    // E2 case
                newSemesters.add(sem + 4);    // E3 case
                newSemesters.add(sem + 6);    // E4 case
            }
            semesters = newSemesters;
        }
        else if ((batches != null && !batches.isEmpty()) && (semesters == null || semesters.isEmpty())) {
            // Case 3: Batches provided, but semesters are empty
            for (String batch : batches) {
                int increment = batchIncrement.getOrDefault(batch, 0);
                newSemesters.add(increment + 1);
                newSemesters.add(increment + 2);
            }
            semesters = newSemesters;
        }

//        // Case 1: Both batches and semesters are provided
//        if (!batches.isEmpty() && !semesters.isEmpty()) {
//            for (String batch : batches) {
//                int increment = batchIncrement.getOrDefault(batch, 0);
//                for (int sem : semesters) {
//                    newSemesters.add(sem + increment);
//                }
//            }
//            semesters = newSemesters;
//        }
//        // Case 2: Semesters provided, but batches are empty
//        else if (!semesters.isEmpty() && batches.isEmpty()) {
//            for (int sem : semesters) {
//                newSemesters.add(sem); // E1 case
//                newSemesters.add(sem + 2); // E2 case
//                newSemesters.add(sem + 4); // E3 case
//                newSemesters.add(sem + 6); // E4 case
//            }
//            semesters = newSemesters;
//        }
//        // Case 3: Batches provided, but semesters are empty
//        else if (!batches.isEmpty() && semesters.isEmpty()) {
//            for (String batch : batches) {
//                int increment = batchIncrement.getOrDefault(batch, 0);
//                newSemesters.add(increment + 1);
//                newSemesters.add(increment + 2);
//            }
//            semesters = newSemesters;
//        }
        Map<String, Object> fileMap = new HashMap<>();

        if (collegeType != null && collegeType.contains("RGUKT")) {
            List<QuestionPaper> papers = questionPaperRepository.findAll(
                    QuestionPaperSpecification.filterByCriteria(academicYears, branches, semesters, subjectNames, examTypes, true, Campus));
            System.out.println(papers.size());
            List<Map<String, Object>> fileDataList = new ArrayList<>();
            for (QuestionPaper paper : papers) {

                fileMap.put("id", paper.getId());
                fileMap.put("subject", paper.getSubject().getSubjectName());
                fileMap.put("academicYear", paper.getAcademicyear().getAcademicYear());
                fileMap.put("branch", paper.getSubject().getBranch().getBranch());
                fileMap.put("semester", paper.getSubject().getBranch().getSemester());
                fileMap.put("examType", paper.getExamType());
                fileMap.put("collegaeName", paper.getCampus());

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
        } else if (collegeType != null && collegeType.contains("Non-RGUKT")) {
            System.out.println("NON-RGUKT");
           // List<NonRguktPaper> papers = repo.findAll(NonRguktQuestionPaperSpecification.filterByCriteria(academicYears, branches, semesters, subjectNames, examTypes, true));
            List<NonRguktPaper> papers=repo.findAll();
            List<Map<String, Object>> fileDataList = new ArrayList<>();
            for (NonRguktPaper paper : papers) {
                fileMap.put("id", paper.getId());
                fileMap.put("subject", paper.getSubjectName());
                fileMap.put("academicYear", paper.getAcademicYear());
                fileMap.put("branch", paper.getBranch());
                fileMap.put("semester", paper.getSemester());
                fileMap.put("examType", paper.getExamType());

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
        return null;
    }
}

