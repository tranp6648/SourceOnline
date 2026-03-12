package com.aot.be.entities.core;

import com.aot.be.entities.enums.SessionStatus;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "live_sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LiveSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_session_id")
    private ReviewSession reviewSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "session_number", nullable = false)
    private Integer sessionNumber = 1;

    @Column(name = "scheduled_at", nullable = false)
    private Instant scheduledAt;

    @Column(name = "duration_min", nullable = false)
    private Integer durationMin = 90;

    @Column(name = "ended_at")
    private Instant endedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "session_status")
    private SessionStatus status = SessionStatus.scheduled;

    @Column(name = "stream_url", columnDefinition = "TEXT")
    private String streamUrl;

    @Column(name = "stream_key", length = 255)
    private String streamKey;

    @Column(name = "replay_url", columnDefinition = "TEXT")
    private String replayUrl;

    @Column(name = "replay_available", nullable = false)
    private Boolean replayAvailable = false;

    @Column(name = "slide_url", columnDefinition = "TEXT")
    private String slideUrl;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> materials;

    @Column(name = "max_attendees")
    private Integer maxAttendees;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }
}
