package com.example.demo.Service;

import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Entity.RejectedPapers;
import com.example.demo.Repo.QuestionPaperRepo;
import com.example.demo.Repo.RejectedPaperRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//public class RejectedPaperService {
//@Autowired
//private QuestionPaperRepo questionPaperRepository;
//    public RejectedPapers updatePaper(Long id) {
//        Optional<QuestionPaper> optionalPaper = questionPaperRepository.findById(id);
//
//        if (optionalPaper.isPresent()) {
//            QuestionPaper paper = optionalPaper.get();
//
//        } else {
//            throw new EntityNotFoundException("Question Paper not found with id: " + id);
//        }
//    }
//}
@Service
public class RejectedPaperService {

    @Autowired
    private QuestionPaperRepo questionPaperRepository;

    @Autowired
    private RejectedPaperRepo rejectedPapersRepository;

    public RejectedPapers fetchquestionpaper(long id) {
        return rejectedPapersRepository.findById(id);
    }

    public RejectedPapers updatePaper(Long id) {
        System.out.println("in upadtePaper of rejectedPapers");
        Optional<QuestionPaper> optionalPaper = questionPaperRepository.findById(id);

        if (optionalPaper.isPresent()) {
            QuestionPaper paper = optionalPaper.get();

            // Create new RejectedPapers entity
            RejectedPapers rejectedPaper = new RejectedPapers();

            rejectedPaper.setAcademicyear(paper.getAcademicyear());
            rejectedPaper.setSubject(paper.getSubject());
            rejectedPaper.setExamType(paper.getExamType());
            rejectedPaper.setFileUrl(paper.getFileUrl());
            rejectedPaper.setUploadedBy(paper.getUploadedBy());

            // Save in RejectedPapers table
            rejectedPapersRepository.save(rejectedPaper);

            // Delete from QuestionPaper table
            questionPaperRepository.deleteById(id);

            return rejectedPaper;
        } else {
            throw new EntityNotFoundException("Question Paper not found with id: " + id);
        }
    }

    public void deletequestionPaper(long l) {
        RejectedPapers r = rejectedPapersRepository.findById(l);
        if (r != null) {
            rejectedPapersRepository.delete(r);
        }
    }
}