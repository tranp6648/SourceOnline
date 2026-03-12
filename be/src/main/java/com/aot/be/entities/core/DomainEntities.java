package com.aot.be.entities.core;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

// ── Tag ──────────────────────────────────────────────────────────
@Entity
@Table(name = "tags")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
class Tag {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50) private String name;
    @Column(nullable = false, unique = true, length = 50) private String slug;
    @Column(nullable = false, length = 7)                private String color = "#64748b";
}

// ── CourseTag ─────────────────────────────────────────────────────
@Entity
@Table(name = "course_tags")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(CourseTag.CourseTagId.class)
class CourseTag {
    @Id @Column(name = "course_id")  private UUID courseId;
    @Id @Column(name = "tag_id")     private UUID tagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", insertable = false, updatable = false)
    private Tag tag;

    @Data @NoArgsConstructor @AllArgsConstructor
    static class CourseTagId implements java.io.Serializable {
        private UUID courseId; private UUID tagId;
    }
}

// ── Badge ──────────────────────────────────────────────────────────
@Entity
@Table(name = "badges")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
class Badge {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true, length = 100) private String name;
    @Column(columnDefinition = "TEXT")                    private String description;
    @Column(name = "icon_url", columnDefinition = "TEXT") private String iconUrl;
    @Column(name = "condition_type", nullable = false, length = 50) private String conditionType;
    @Column(name = "condition_value", nullable = false)   private Integer conditionValue = 1;
    @Column(name = "xp_reward", nullable = false)         private Integer xpReward = 50;
}

// ── UserBadge ──────────────────────────────────────────────────────
@Entity
@Table(name = "user_badges",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","badge_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
class UserBadge {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id", nullable = false) private Badge badge;

    @Column(name = "earned_at", nullable = false) private Instant earnedAt;

    @PrePersist protected void onCreate() { earnedAt = Instant.now(); }
}

// ── Certificate ────────────────────────────────────────────────────
@Entity
@Table(name = "certificates",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","course_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
class Certificate {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false) private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id") private Enrollment enrollment;

    @Column(name = "cert_number", nullable = false, unique = true, length = 100)
    private String certNumber;

    @Column(name = "issued_at", nullable = false) private Instant issuedAt;
    @Column(name = "cert_url", columnDefinition = "TEXT") private String certUrl;

    @PrePersist protected void onCreate() { issuedAt = Instant.now(); }
}

// ── CourseReview ───────────────────────────────────────────────────
@Entity
@Table(name = "course_reviews",
        uniqueConstraints = @UniqueConstraint(columnNames = {"course_id","user_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
class CourseReview {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false) private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) private User user;

    @Column(nullable = false)
    @jakarta.validation.constraints.Min(1)
    @jakarta.validation.constraints.Max(5)
    private Short rating;

    @Column(columnDefinition = "TEXT") private String comment;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist protected void onCreate() { createdAt = Instant.now(); }
}
