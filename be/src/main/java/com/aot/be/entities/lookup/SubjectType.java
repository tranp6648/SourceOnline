package com.aot.be.entities.lookup;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject_types")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SubjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String label;

    @Column(length = 10)
    private String icon;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}

