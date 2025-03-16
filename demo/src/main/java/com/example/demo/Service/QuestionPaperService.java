//package com.example.demo.Service;
//
//
//
//import com.example.demo.Entity.*;
//import com.example.demo.Repo.QuestionPaperRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//@Service
//public class QuestionPaperService {
//
//    private static final String UPLOAD_DIR = "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploads/";
//
//    @Autowired
//    private QuestionPaperRepo questionPaperRepository;
//@Transactional
//    public QuestionPaper saveQuestionPaper(MultipartFile file, Academicyear academicyearid, Subject subjectid, String examType, User userid, String filename) throws IOException {
//        // Ensure upload directory exists
//        Files.createDirectories(Paths.get(UPLOAD_DIR));
//
//
//        // Save file
//        String filePath = UPLOAD_DIR + file.getOriginalFilename();
//        file.transferTo(new File(filePath));
//        // Create QuestionPaper entity
//        QuestionPaper questionPaper = new QuestionPaper();
//        questionPaper.setFileUrl(filePath);
//        questionPaper.setExamType(examType);
//        questionPaper.setAcademicyear(academicyearid);
//        questionPaper.setSubject(subjectid);
//        questionPaper.setUploadedBy(userid);
//        // Save metadata to DB
//        return questionPaperRepository.save(questionPaper);
//    }
//}
//
package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repo.QuestionPaperRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class QuestionPaperService {

    private static final String UPLOAD_DIR = "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploads/";

    @Autowired
    private QuestionPaperRepo questionPaperRepository;

    @Transactional
    public QuestionPaper saveQuestionPaper(MultipartFile file, Academicyear academicyearid, Subject subjectid,
                                           String examType, User userid, String filename) throws IOException {
        // Ensure upload directory exists
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // Construct the full file path using the provided filename
        String filePath = UPLOAD_DIR + filename;

        // Save the file with the provided filename
        file.transferTo(new File(filePath));

        // Create QuestionPaper entity
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setFileUrl(filePath);
        questionPaper.setExamType(examType);
        questionPaper.setAcademicyear(academicyearid);
        questionPaper.setSubject(subjectid);
        questionPaper.setUploadedBy(userid);

        // Save metadata to DB
        return questionPaperRepository.save(questionPaper);
    }

    public QuestionPaper updateStatus(Long id, boolean accept) {
        Optional<QuestionPaper> optionalPaper = questionPaperRepository.findById(id);

        if (optionalPaper.isPresent()) {
            QuestionPaper paper = optionalPaper.get();
            paper.setIsaccepted(accept); // Update isAccepted field
            return questionPaperRepository.save(paper); // Save updated entity
        } else {
            throw new EntityNotFoundException("Question Paper not found with id: " + id);
        }
    }
}
