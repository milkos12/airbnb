package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hauses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hause_id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "guests", nullable = false)
    private int guests;

    @Column(name = "rooms", nullable = false)
    private int rooms;

    @Column(name = "bets", nullable = false)
    private int bets;

    @Column(name = "bathrooms", nullable = false)
    private int bathrooms;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "coordinates", nullable = false, length = 100)
    private String coordinates;

    @ElementCollection
    @Column(name = "phothos")
    private List<String> phothos;

    @Column(name = "full_address", nullable = false, length = 100)
    private String fullAddress;

}