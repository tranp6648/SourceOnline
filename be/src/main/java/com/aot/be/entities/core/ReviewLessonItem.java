package com.aot.be.entities.core;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "review_lesson_items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(ReviewLessonItem.ReviewLessonItemId.class)
public class ReviewLessonItem {

    @Id
    @Column(name = "review_session_id")
    private UUID reviewSessionId;

    @Id
    @Column(name = "lesson_id")
    private UUID lessonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_session_id", insertable = false, updatable = false)
    private ReviewSession reviewSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", insertable = false, updatable = false)
    private Lesson lesson;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex = 0;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewLessonItemId implements Serializable {
        private UUID reviewSessionId;
        private UUID lessonId;
    }
}
