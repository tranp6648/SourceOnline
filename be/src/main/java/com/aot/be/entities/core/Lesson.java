package com.aot.be.entities.core;

import com.aot.be.entities.lookup.LessonType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "lessons",
        uniqueConstraints = @UniqueConstraint(columnNames = {"section_id", "order_index"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_type_id", nullable = false)
    private LessonType lessonType;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex = 0;

    @Column(name = "duration_min")
    private Integer durationMin;

    @Column(name = "content_md", columnDefinition = "TEXT")
    private String contentMd;

    @Column(name = "video_url", columnDefinition = "TEXT")
    private String videoUrl;

    @Column(name = "video_duration_s")
    private Integer videoDurationS;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> attachments;

    @Column(length = 30)
    private String language;

    @Column(name = "starter_code", columnDefinition = "TEXT")
    private String starterCode;

    @Column(name = "solution_code", columnDefinition = "TEXT")
    private String solutionCode;

    @Column(name = "instructions_md", columnDefinition = "TEXT")
    private String instructionsMd;

    @Type(JsonType.class)
    @Column(name = "quiz_data", columnDefinition = "jsonb")
    private Map<String, Object> quizData;

    @Column(name = "essay_prompt", columnDefinition = "TEXT")
    private String essayPrompt;

    @Column(name = "essay_min_words")
    private Integer essayMinWords;

    @Column(name = "essay_max_words")
    private Integer essayMaxWords;

    @Type(JsonType.class)
    @Column(name = "essay_rubric", columnDefinition = "jsonb")
    private Map<String, Object> essayRubric;

    @Column(name = "upload_instructions", columnDefinition = "TEXT")
    private String uploadInstructions;

    @Column(name = "allowed_formats", columnDefinition = "TEXT[]")
    private String[] allowedFormats;

    @Column(name = "max_file_mb")
    private Integer maxFileMb;

    @Column(name = "xp_reward", nullable = false)
    private Integer xpReward = 10;

    @Column(name = "is_review", nullable = false)
    private Boolean isReview = false;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
