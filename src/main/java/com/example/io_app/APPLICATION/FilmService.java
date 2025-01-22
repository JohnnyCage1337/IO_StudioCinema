package com.example.io_app.APPLICATION;

import com.example.io_app.DOMAIN.Film;
import com.example.io_app.DOMAIN.FilmManager;
import com.example.io_app.DTO.FilmDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FilmService {

    public FilmDTO createFilm(FilmDTO filmDTO) {
        Film film = new Film(
                filmDTO.getName(),
                filmDTO.getDuration(),
                filmDTO.getDescription(),
                filmDTO.getGenre(),
                filmDTO.getRate(),
                filmDTO.getDirector(),
                filmDTO.getLanguage()
        );
        FilmManager.createFilm(
                film.getName(), film.getDuration(), film.getDescription(),
                film.getGenre(), film.getRate(), film.getDirector(), film.getLanguage()
        );
        return convertToDTO(film);
    }

    // Pobiera szczegóły filmu po nazwie
    public FilmDTO getFilmByName(String name) {
        Film film = FilmManager.readFilmByName(name);
        if (film == null) {
            throw new IllegalArgumentException("Film not found");
        }
        return convertToDTO(film);
    }

    // Pobiera listę wszystkich filmów
    public List<FilmDTO> getAllFilms() {
        return FilmManager.readAllFilms().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Aktualizuje dane filmu
    public boolean updateFilm(FilmDTO filmDTO) {
        return FilmManager.updateFilm(
                filmDTO.getName(), filmDTO.getDuration(), filmDTO.getDescription(),
                filmDTO.getGenre(), filmDTO.getRate(), filmDTO.getDirector(), filmDTO.getLanguage()
        );
    }

    // Usuwa film po nazwie
    public boolean deleteFilm(String name) {
        return FilmManager.deleteFilm(name);
    }

    // Konwersja obiektu Film -> FilmDTO
    private FilmDTO convertToDTO(Film film) {
        return new FilmDTO(
                film.getName(),
                film.getDuration(),
                film.getDescription(),
                film.getGenre(),
                film.getRate(),
                film.getDirector(),
                film.getLanguage()
        );
    }
}
