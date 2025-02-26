package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "comments", nullable = false, length = 1000)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id_house", nullable = false)
    private House house;

    @OneToOne(mappedBy = "review", orphanRemoval = true, cascade = CascadeType.ALL)
    private Rating rating;
}