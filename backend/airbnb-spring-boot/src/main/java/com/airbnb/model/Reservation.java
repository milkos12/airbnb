package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Calendar;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "arrival_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar arrivalDate;

    @Column(name = "departure_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar departureDate;

    @Column(name = "number_of_guests", nullable = false)
    @Min(1)
    private Integer numberOfGuests;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;
}