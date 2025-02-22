package com.example.demo.Service;



import com.example.demo.Entity.*;
import com.example.demo.Repo.QuestionPaperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class QuestionPaperService {

    private static final String UPLOAD_DIR = "C:/Users/Raga Akshaya/Desktop/miniproject_backend/demo/src/main/resources/uploads/";

    @Autowired
    private QuestionPaperRepo questionPaperRepository;
@Transactional
    public QuestionPaper saveQuestionPaper(MultipartFile file, Academicyear academicyearid, Subject subjectid, String examType, User userid) throws IOException {
        // Ensure upload directory exists
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // Save file
        String filePath = UPLOAD_DIR + file.getOriginalFilename();
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
}

