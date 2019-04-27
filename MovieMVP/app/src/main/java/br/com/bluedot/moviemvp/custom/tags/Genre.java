package br.com.bluedot.moviemvp.custom.tags;

import java.util.ArrayList;
import java.util.List;

public enum Genre {
    ACTION(28, "Ação"),
    ADVENTURE(12, "Aventura"),
    ANIMATION(16, "Animação"),
    COMEDY(35, "Comédia"),
    CRIME(80, "Crime"),
    DOCUMENTARY(99, "Documentario"),
    DRAMA(18, "Drama"),
    FAMILY(10751, "Familia"),
    FANTASY(14, "Fantasia"),
    HISTORY(36, "Historia"),
    HORROR(27, "Terror"),
    MUSIC(10402, "Musica"),
    MYSTERY(9648, "Mistério"),
    ROMANCE(10749, "Romance"),
    SCIENCE_FICTION(878, "Ficção Cientifica"),
    TV_MOVIE(10770, "Filme de TV"),
    THRILLER(53, "Suspense"),
    WAR(10752, "Guerra"),
    WESTERN(37, "Faroeste");

    int id;
    String genre;

    Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public static List<String> getTags(List<Integer> tags) {
        List<String> list = new ArrayList<>();
        for (Genre genre : Genre.values()) {
            for (Integer i : tags) {
                if (i == genre.id) {
                    list.add(genre.genre);
                }
            }
        }
        return list;
    }

}