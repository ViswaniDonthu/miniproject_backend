package com.example.demo.Service;


import com.example.demo.Entity.Academicyear;
import com.example.demo.Entity.Branch;
import com.example.demo.Entity.QuestionPaper;
import com.example.demo.Entity.Subject;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public class QuestionPaperSpecification {

    public static Specification<QuestionPaper> filterByCriteria(
            List<String> academicYears,
            List<String> branches,
            List<Integer> semesters,
            List<String> subjectNames,
            List<String> examTypes
    ) {
        return (Root<QuestionPaper> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();

            // Filter by Academic Year
            if (academicYears != null && !academicYears.isEmpty()) {
                Join<QuestionPaper, Academicyear> academicYearJoin = root.join("academicyear");
                predicate = cb.and(predicate, academicYearJoin.get("academicYear").in(academicYears));
            }

            // Filter by Branch
            if (branches != null && !branches.isEmpty()) {
                Join<QuestionPaper, Subject> subjectJoin = root.join("subject");
                Join<Subject, Branch> branchJoin = subjectJoin.join("branch");
                predicate = cb.and(predicate, branchJoin.get("branch").in(branches));
            }

            // Filter by Semester
            if (semesters != null && !semesters.isEmpty()) {
                Join<QuestionPaper, Subject> subjectJoin = root.join("subject");
                Join<Subject, Branch> branchJoin = subjectJoin.join("branch");
                predicate = cb.and(predicate, branchJoin.get("semester").in(semesters));
            }

            // Filter by Subject Name
            if (subjectNames != null && !subjectNames.isEmpty()) {
                Join<QuestionPaper, Subject> subjectJoin = root.join("subject");
                predicate = cb.and(predicate, subjectJoin.get("subjectName").in(subjectNames));
            }

            // Filter by Exam Type
            if (examTypes != null && !examTypes.isEmpty()) {
                predicate = cb.and(predicate, root.get("examType").in(examTypes));
            }

            return predicate;
        };
    }
}
