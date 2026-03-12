package com.aot.be.entities.core;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "user_stats")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserStats {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "lessons_completed", nullable = false)
    private Integer lessonsCompleted = 0;

    @Column(name = "courses_completed", nullable = false)
    private Integer coursesCompleted = 0;

    @Column(name = "live_sessions_attended", nullable = false)
    private Integer liveSessionsAttended = 0;

    @Column(name = "quizzes_passed", nullable = false)
    private Integer quizzesPassed = 0;

    @Column(name = "essays_submitted", nullable = false)
    private Integer essaysSubmitted = 0;

    @Column(name = "code_passed_total", nullable = false)
    private Integer codePassedTotal = 0;

    @Column(name = "total_study_hours", nullable = false, precision = 8, scale = 2)
    private BigDecimal totalStudyHours = BigDecimal.ZERO;

    @Column(name = "rank_global")
    private Integer rankGlobal;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
