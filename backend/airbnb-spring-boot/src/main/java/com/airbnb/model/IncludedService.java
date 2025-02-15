package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "included_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncludedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "included_services_id")
    Long includedServiceId;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
