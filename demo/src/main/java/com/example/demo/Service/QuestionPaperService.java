
package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Model.UserDTO;
import com.example.demo.Repo.NonRguktQuestionPaperRepo;
import com.example.demo.Repo.QuestionPaperRepo;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.example.demo.Entity.NonRguktPaper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class QuestionPaperService {

    private static final String UPLOAD_DIR = "C:/Users/donth/Desktop/miniproject_backend/demo/src/main/resources/uploads/";

    @Autowired
    private QuestionPaperRepo questionPaperRepository;
  @Autowired
  private NonRguktQuestionPaperRepo repo;

    //    @Transactional
//    public QuestionPaper saveQuestionPaper(MultipartFile file, Academicyear academicyearid, Subject subjectid,
//                                           String examType, User userid, String filename) throws IOException {
//        // Ensure upload directory exists
//        Files.createDirectories(Paths.get(UPLOAD_DIR));
//
//        // Construct the full file path using the provided filename
//        String filePath = UPLOAD_DIR + filename;
//
//        // Save the file with the provided filename
//        file.transferTo(new File(filePath));
//
//        // Create QuestionPaper entity
//        QuestionPaper questionPaper = new QuestionPaper();
//        questionPaper.setFileUrl(filePath);
//        questionPaper.setExamType(examType);
//        questionPaper.setAcademicyear(academicyearid);
//        questionPaper.setSubject(subjectid);
//        questionPaper.setUploadedBy(userid);
//
//        // Save metadata to DB
//        return questionPaperRepository.save(questionPaper);
//    }
    @Transactional
    public QuestionPaper saveQuestionPaper(MultipartFile file, Academicyear academicyearid, Subject subjectid,
                                           String examType, UserDTO userid, String filename, String campus) throws IOException {

        // Ensure upload directory exists
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // Construct file path
        String filePath = UPLOAD_DIR + filename;

        // Save the uploaded file
        file.transferTo(new File(filePath));

        // Apply watermark and overwrite the original file
        addWatermark(filePath);

        // Create and save QuestionPaper entity
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setFileUrl(filePath);  // Overwritten file with watermark
        questionPaper.setExamType(examType);
        questionPaper.setAcademicyear(academicyearid);
        questionPaper.setSubject(subjectid);
        questionPaper.setUploadedByUser(userid);
        questionPaper.setUploadedByUserId(questionPaper.getUploadedByUser().getId());
        questionPaper.setCampus(campus);
        return questionPaperRepository.save(questionPaper);
    }


    private void addWatermark(String filePath) throws IOException {
        // Temporary file to store the modified PDF
        String tempFilePath = filePath + "_temp.pdf";

        PdfDocument pdfDoc = new PdfDocument(new PdfReader(filePath), new PdfWriter(tempFilePath));
        PdfFont font = PdfFontFactory.createFont();

        for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
            PdfPage page = pdfDoc.getPage(i);
            PdfCanvas canvas = new PdfCanvas(page);

            canvas.saveState();
            canvas.setExtGState(new PdfExtGState().setFillOpacity(0.3f));
            canvas.setFontAndSize(font, 50);
            canvas.setFillColor(ColorConstants.LIGHT_GRAY);
            canvas.concatMatrix(0.8f, 0.8f, -0.8f, 0.8f, page.getPageSize().getWidth() / 4, page.getPageSize().getHeight() / 3);

            canvas.beginText();
            canvas.setTextMatrix(30, 30);
            canvas.showText("MAKE DIGITIZE");
            canvas.endText();

            canvas.restoreState();
        }
        pdfDoc.close();  // Close the document

// Replace original file with the watermarked one
        Files.delete(Paths.get(filePath));  // Delete original
        Files.move(Paths.get(tempFilePath), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
    }

    public QuestionPaper updateStatus(Long id, boolean accept) {
        Optional<QuestionPaper> optionalPaper = questionPaperRepository.findById(id);

        if (optionalPaper.isPresent()) {
            QuestionPaper paper = optionalPaper.get();
            boolean exists = questionPaperRepository.existsByAcademicyearAndExamTypeAndSubjectAndIsaccepted(
                    paper.getAcademicyear(), paper.getExamType(), paper.getSubject(), true
            );

            if (exists) {
                System.out.println("yes exists..!");
                return null;
            }

            paper.setIsaccepted(accept); // Update isAccepted field
            return questionPaperRepository.save(paper); // Save updated entity
        } else {
            throw new EntityNotFoundException("Question Paper not found with id: " + id);
        }
    }

    public NonRguktPaper saveNonRguktQuestionPaper(MultipartFile file, String academicYear, String subject, String examType, UserDTO userDTO, String filename, String campus)throws IOException {
        // Ensure upload directory exists
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // Construct file path
        String filePath = UPLOAD_DIR + filename;

        // Save the uploaded file
        file.transferTo(new File(filePath));

        // Apply watermark and overwrite the original file
        addWatermark(filePath);

        // Create and save QuestionPaper entity
NonRguktPaper paper=new NonRguktPaper();
       paper.setFileUrl(filePath);  // Overwritten file with watermark
        paper.setExamType(examType);
       paper.setAcademicYear(academicYear);
        paper.setSubjectName(subject);
        paper.setUser(userDTO);
        paper.setUploadedBy(paper.getUser().getId());
        paper.setCollageName(campus);
        return repo.save(paper);
    }
}


