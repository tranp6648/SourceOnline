package com.aot.be.entities.lookup;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "practice_types")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PracticeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String label;

    @Column(name = "auto_graded", nullable = false)
    private Boolean autoGraded = false;

    @Column(name = "manual_grade", nullable = false)
    private Boolean manualGrade = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

}
