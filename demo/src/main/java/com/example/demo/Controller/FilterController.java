package com.example.demo.Controller;

import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Service.QuestionPaperSpecification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionpapers")
public class FilterController {

    private final QuestionPaperRepo questionPaperRepository;

    public FilterController(QuestionPaperRepo questionPaperRepository) {
        this.questionPaperRepository = questionPaperRepository;
    }

    @GetMapping("/filter")
    public List<QuestionPaper> getFilteredPapers(
            @RequestParam(required = false) List<String> academicYears,
            @RequestParam(required = false) List<String> branches,
            @RequestParam(required = false) List<Integer> semesters,
            @RequestParam(required = false) List<String> subjectNames,
            @RequestParam(required = false) List<String> examTypes
    ) {
        return questionPaperRepository.findAll(QuestionPaperSpecification.filterByCriteria(
                academicYears, branches, semesters, subjectNames, examTypes));
    }
}
