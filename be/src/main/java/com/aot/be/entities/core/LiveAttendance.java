package com.aot.be.entities.core;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "live_attendances",
        uniqueConstraints = @UniqueConstraint(columnNames = {"live_session_id", "user_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LiveAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "live_session_id", nullable = false)
    private LiveSession liveSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "joined_at", nullable = false)
    private Instant joinedAt;

    @Column(name = "left_at")
    private Instant leftAt;

    @Column(name = "duration_min")
    private Integer durationMin;

    @Column(name = "watched_replay", nullable = false)
    private Boolean watchedReplay = false;

    @PrePersist
    protected void onCreate() {
        joinedAt = Instant.now();
    }
}
