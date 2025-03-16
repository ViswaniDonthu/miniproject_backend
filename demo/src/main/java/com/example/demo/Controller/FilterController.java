package com.example.demo.Controller;

import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Service.QuestionPaperSpecification;
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

//    @GetMapping("/filter")
//    public ResponseEntity<List<Map<String, String>>> getFilteredPapers(
//            @RequestParam(required = false) List<String> academicYears,
//            @RequestParam(required = false) List<String> branches,
//            @RequestParam(required = false) List<Integer> semesters,
//            @RequestParam(required = false) List<String> subjectNames,
//            @RequestParam(required = false) List<String> examTypes) {
//
//        List<QuestionPaper> papers = questionPaperRepository.findAll(
//                QuestionPaperSpecification.filterByCriteria(academicYears, branches, semesters, subjectNames, examTypes));
//
//        List<Map<String, String>> fileDataList = new ArrayList<>();
//
//        for (QuestionPaper paper : papers) {
//            try {
//                File file = new File(paper.getFileUrl());
//                FileInputStream fis = new FileInputStream(file);
//                byte[] fileBytes = fis.readAllBytes();
//                fis.close();
//
//                String encodedFile = Base64.getEncoder().encodeToString(fileBytes);
//
//                Map<String, String> fileMap = new HashMap<>();
//                fileMap.put("fileName", file.getName());
//                fileMap.put("fileData", encodedFile);
//
//                fileDataList.add(fileMap);
//
//            } catch (IOException e) {
//                System.out.println("File not found: " + paper.getFileUrl());
//            }
//        }
//
//        return ResponseEntity.ok().body(fileDataList);
//    }
@GetMapping("/filter")
public ResponseEntity<List<Map<String, Object>>> getFilteredPapers(
        @RequestParam(required = false) List<String> academicYears,
        @RequestParam(required = false) List<String> branches,
        @RequestParam(required = false) List<Integer> semesters,
        @RequestParam(required = false) List<String> subjectNames,
        @RequestParam(required = false) List<String> examTypes) {

    List<QuestionPaper> papers = questionPaperRepository.findAll(
            QuestionPaperSpecification.filterByCriteria(academicYears, branches, semesters, subjectNames, examTypes,true));

    List<Map<String, Object>> fileDataList = new ArrayList<>();

    for (QuestionPaper paper : papers) {
        Map<String, Object> fileMap = new HashMap<>();
        fileMap.put("id", paper.getId());
        fileMap.put("subject", paper.getSubject().getSubjectName());
        fileMap.put("academicYear", paper.getAcademicyear().getAcademicYear());
        fileMap.put("branch", paper.getSubject().getBranch().getBranch());
        fileMap.put("semester", paper.getSubject().getBranch().getSemester());
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

}
