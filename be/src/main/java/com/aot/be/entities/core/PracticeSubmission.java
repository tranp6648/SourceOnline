package com.aot.be.entities.core;

import com.aot.be.entities.enums.SubmissionStatus;
import com.aot.be.entities.lookup.PracticeType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "practice_submissions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PracticeSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practice_type_id", nullable = false)
    private PracticeType practiceType;

    @Column(name = "attempt_number", nullable = false)
    private Integer attemptNumber = 1;

    @Column(length = 30)
    private String language;

    @Column(columnDefinition = "TEXT")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "submission_status")
    private SubmissionStatus status = SubmissionStatus.pending;

    @Column(columnDefinition = "TEXT")
    private String stdout;

    @Column(columnDefinition = "TEXT")
    private String stderr;

    @Column(name = "runtime_ms")
    private Integer runtimeMs;

    @Column(name = "memory_kb")
    private Integer memoryKb;

    @Column(name = "tests_total", nullable = false)
    private Integer testsTotal = 0;

    @Column(name = "tests_passed", nullable = false)
    private Integer testsPassed = 0;

    @Column(name = "is_run_only", nullable = false)
    private Boolean isRunOnly = false;

    @Type(JsonType.class)
    @Column(name = "quiz_answers", columnDefinition = "jsonb")
    private Map<String, Object> quizAnswers;

    @Column(name = "quiz_score", precision = 5, scale = 2)
    private BigDecimal quizScore;

    @Column(name = "quiz_passed")
    private Boolean quizPassed;

    @Column(name = "essay_content", columnDefinition = "TEXT")
    private String essayContent;

    @Column(name = "essay_word_count")
    private Integer essayWordCount;

    @Column(name = "essay_score", precision = 5, scale = 2)
    private BigDecimal essayScore;

    @Column(name = "essay_feedback", columnDefinition = "TEXT")
    private String essayFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graded_by")
    private User gradedBy;

    @Column(name = "graded_at")
    private Instant gradedAt;

    @Column(name = "file_url", columnDefinition = "TEXT")
    private String fileUrl;

    @Column(name = "file_name", length = 255)
    private String fileName;

    @Column(name = "file_size_kb")
    private Integer fileSizeKb;

    @Column(name = "file_feedback", columnDefinition = "TEXT")
    private String fileFeedback;

    @Column(name = "file_score", precision = 5, scale = 2)
    private BigDecimal fileScore;

    @Column(name = "submitted_at", nullable = false, updatable = false)
    private Instant submittedAt;

    @PrePersist
    protected void onCreate() {
        submittedAt = Instant.now();
    }
}
