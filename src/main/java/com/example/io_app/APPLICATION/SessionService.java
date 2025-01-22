package com.example.io_app.APPLICATION;

import com.example.io_app.DOMAIN.Film;
import com.example.io_app.DOMAIN.FilmManager;
import com.example.io_app.DOMAIN.Session;
import com.example.io_app.DOMAIN.SessionManager;
import com.example.io_app.DTO.SessionDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SessionService {

    // Tworzy nową sesję (seans filmowy)
    public SessionDTO createSession(SessionDTO sessionDTO) {
        // Sprawdzenie, czy istnieje film o podanym tytule
        Film film = FilmManager.readFilmByName(sessionDTO.getFilmName());
        if (film == null) {
            throw new IllegalArgumentException("Film o nazwie '" + sessionDTO.getFilmName() + "' nie istnieje.");
        }

        // Tworzenie sesji za pomocą SessionManager
        Session session = SessionManager.createSession(
                sessionDTO.getId(),
                film,
                sessionDTO.getRoomNumber(),
                sessionDTO.getStartTime(),
                sessionDTO.getPrice(),
                sessionDTO.getTotalSeats()
        );

        // Zwracanie sesji jako DTO
        return convertToDTO(session);
    }

    // Pobiera szczegóły sesji po ID
    public SessionDTO getSessionById(int id) {
        Session session = SessionManager.readSessionById(id);
        if (session == null) {
            throw new IllegalArgumentException("Sesja o ID " + id + " nie istnieje.");
        }
        return convertToDTO(session);
    }

    // Pobiera listę wszystkich sesji
    public List<SessionDTO> getAllSessions() {
        return SessionManager.readAllSessions().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Pobiera sesje według tytułu filmu
    public List<SessionDTO> getSessionsByFilmTitle(String title) {
        return SessionManager.findSessionsByFilmTitle(title).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Pobiera sesje w określonym przedziale czasowym
    public List<SessionDTO> getSessionsInTimeRange(LocalDateTime from, LocalDateTime to) {
        return SessionManager.findSessionsInTimeRange(from, to).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Aktualizuje istniejącą sesję
    public boolean updateSession(SessionDTO sessionDTO) {
        Film film = FilmManager.readFilmByName(sessionDTO.getFilmName());
        if (film == null) {
            throw new IllegalArgumentException("Film o nazwie '" + sessionDTO.getFilmName() + "' nie istnieje.");
        }

        return SessionManager.updateSession(
                sessionDTO.getId(),
                film,
                sessionDTO.getRoomNumber(),
                sessionDTO.getStartTime(),
                sessionDTO.getPrice(),
                sessionDTO.getTotalSeats()
        );
    }

    // Usuwa sesję po ID
    public boolean deleteSession(int id) {
        return SessionManager.deleteSession(id);
    }

    // Sprawdza, czy sesja ma dostępne miejsca
    public boolean hasAvailableSeats(int sessionId) {
        return SessionManager.hasAvailableSeats(sessionId);
    }

    // Zwraca liczbę dostępnych miejsc dla sesji
    public int getAvailableSeats(int sessionId) {
        return SessionManager.getAvailableSeats(sessionId);
    }

    // Konwertuje obiekt Session na SessionDTO
    private SessionDTO convertToDTO(Session session) {
        return new SessionDTO(
                session.getId(),
                session.getFilm().getName(),
                session.getRoomNumber(),
                session.getStartTime(),
                session.getEndTime(),
                session.getPrice(),
                session.getAvailableSeats(),
                session.getTotalSeats()
        );
    }
}
