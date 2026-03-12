package com.aot.be.entities.core;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "course_instructors")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(CourseInstructor.CourseInstructorId.class)
public class CourseInstructor {

    @Id
    @Column(name = "course_id")
    private UUID courseId;

    @Id
    @Column(name = "instructor_id")
    private UUID instructorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", insertable = false, updatable = false)
    private User instructor;

    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary = false;

    @Column(name = "joined_at", nullable = false, updatable = false)
    private Instant joinedAt;

    @PrePersist
    protected void onCreate() {
        joinedAt = Instant.now();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CourseInstructorId implements Serializable {
        private UUID courseId;
        private UUID instructorId;
    }
}
