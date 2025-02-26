package com.airbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "created_at", nullable = false, updatable = false)
    // Specifies that the field stores a timestamp (date and time)
    @Temporal(TemporalType.TIMESTAMP)
    // Automatically stores the creation timestamp when the entity is first persisted
    @CreationTimestamp
    private Calendar createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    // Automatically updates the timestamp every time the entity is modified
    @UpdateTimestamp
    private Calendar updatedAt;
}
