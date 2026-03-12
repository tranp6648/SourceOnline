package com.aot.be.entities.core;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "sandbox_sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(SandboxSession.SandboxSessionId.class)
public class SandboxSession {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Id
    @Column(name = "lesson_id")
    private UUID lessonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", insertable = false, updatable = false)
    private Lesson lesson;

    @Column(name = "current_code", nullable = false, columnDefinition = "TEXT")
    private String currentCode = "";

    @Column(nullable = false, length = 30)
    private String language;

    @Column(name = "saved_at", nullable = false)
    private Instant savedAt;

    @PrePersist
    @PreUpdate
    protected void onSave() {
        savedAt = Instant.now();
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class SandboxSessionId implements java.io.Serializable {
        private UUID userId;
        private UUID lessonId;
    }
}
