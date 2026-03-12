package com.aot.be.entities.lookup;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lesson_types")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LessonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String label;

    @Column(length = 10)
    private String icon;

    @Column(name = "has_video", nullable = false)
    private Boolean hasVideo = false;

    @Column(name = "has_code_editor", nullable = false)
    private Boolean hasCodeEditor = false;

    @Column(name = "has_quiz", nullable = false)
    private Boolean hasQuiz = false;

    @Column(name = "has_essay", nullable = false)
    private Boolean hasEssay = false;

    @Column(name = "has_file_upload", nullable = false)
    private Boolean hasFileUpload = false;

    @Column(name = "is_live", nullable = false)
    private Boolean isLive = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
