package com.example.demo.Service;


import com.example.demo.Entity.NonRguktPaper;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class NonRguktQuestionPaperSpecification {

    public static Specification<NonRguktPaper> filterByCriteria(
            List<String> academicYears,
            List<String> branches,
            List<Integer> semesters,
            List<String> subjectNames,
            List<String> examTypes,
            boolean isAccepted

    ) {
        return (Root<NonRguktPaper> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();

            // Filter by isAccepted
            predicate = cb.and(predicate, cb.equal(root.get("isAccepted"), isAccepted));

            // Academic Year
            if (academicYears != null && !academicYears.isEmpty()) {
                predicate = cb.and(predicate, root.get("academicYear").in(academicYears));
            }

            // Branch
            if (branches != null && !branches.isEmpty()) {
                predicate = cb.and(predicate, root.get("branch").in(branches));
            }

            // Semester
            if (semesters != null && !semesters.isEmpty()) {
                predicate = cb.and(predicate, root.get("semester").in(semesters));
            }

            // Subject Name
            if (subjectNames != null && !subjectNames.isEmpty()) {
                predicate = cb.and(predicate, root.get("subjectName").in(subjectNames));
            }

            // Exam Type
            if (examTypes != null && !examTypes.isEmpty()) {
                predicate = cb.and(predicate, root.get("examType").in(examTypes));
            }
            return predicate;
        };
    }
}
