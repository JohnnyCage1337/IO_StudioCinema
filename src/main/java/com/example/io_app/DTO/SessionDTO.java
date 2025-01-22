package com.example.io_app.DTO;

import java.time.LocalDateTime;

public class SessionDTO {

    private int id;                  // Identyfikator sesji
    private String filmName;         // Tytuł filmu (zamiast całego obiektu Film)
    private int roomNumber;          // Numer sali, w której odbywa się seans
    private LocalDateTime startTime; // Czas rozpoczęcia seansu
    private LocalDateTime endTime;   // Czas zakończenia seansu
    private double price;            // Cena biletu na seans
    private int availableSeats;      // Liczba dostępnych miejsc
    private int totalSeats;          // Całkowita liczba miejsc w sali

    // Konstruktor do inicjalizacji wszystkich pól
    public SessionDTO(int id, String filmName, int roomNumber, LocalDateTime startTime, LocalDateTime endTime, double price, int availableSeats, int totalSeats) {
        this.id = id;
        this.filmName = filmName;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
    }

    // Gettery i settery dla wszystkich pól

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    // Opcjonalnie: Metoda toString() dla lepszego debugowania
    @Override
    public String toString() {
        return "SessionDTO{" +
                "id=" + id +
                ", filmName='" + filmName + '\'' +
                ", roomNumber=" + roomNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", availableSeats=" + availableSeats +
                ", totalSeats=" + totalSeats +
                '}';
    }
}
