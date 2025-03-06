package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "unavailable_days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnavailableDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unavailable_day_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    @ElementCollection
    @CollectionTable(name = "unavailable_dates", joinColumns = @JoinColumn(name = "house_id"))
    @Column(name = "unavailable_date", nullable = false)
    private List<String> unavailableDates;
}
