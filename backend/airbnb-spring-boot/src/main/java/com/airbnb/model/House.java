package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="houses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "guests", nullable = false)
    private int guests;

    @Column(name = "rooms", nullable = false)
    private int rooms;

    @Column(name = "beds", nullable = false)
    private int beds;

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

    18-new-column-for-price-per-night-for-each-house
    @Column(name = "night_price")
    private Float nightPrice;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IncludedService> includedServices;

}