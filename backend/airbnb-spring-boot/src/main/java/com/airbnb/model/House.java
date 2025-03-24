package com.airbnb.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="houses")

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

    @Column(name = "night_price")
    private Float nightPrice;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IncludedService> includedServices;

    public House() {}

    public House(
            Long houseId, String name, User user, int guests, int rooms, int beds, int bathrooms, String city,
            String country, String coordinates, List<String> photos, String fullAddress, Float nightPrice,
            List<IncludedService> includedServices
    ) {
        this.houseId = houseId;
        this.name = name;
        this.user = user;
        this.guests = guests;
        this.rooms = rooms;
        this.beds = beds;
        this.bathrooms = bathrooms;
        this.city = city;
        this.country = country;
        this.coordinates = coordinates;
        this.photos = photos;
        this.fullAddress = fullAddress;
        this.nightPrice = nightPrice;
        this.includedServices = includedServices;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Float getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(Float nightPrice) {
        this.nightPrice = nightPrice;
    }

    public List<IncludedService> getIncludedServices() {
        return includedServices;
    }

    public void setIncludedServices(List<IncludedService> includedServices) {
        this.includedServices = includedServices;
    }
}