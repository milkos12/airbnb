package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="houses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long house_id;

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
    @Column(name = "photos")
    private List<String> photos;

    @Column(name = "full_address", nullable = false, length = 100)
    private String fullAddress;

}