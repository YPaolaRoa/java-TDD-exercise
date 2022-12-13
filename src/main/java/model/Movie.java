package model;

public class Movie {
    private final String moviename;

    private final String director;

    private int releaseYear;

    public Movie(String movieName, String director, int releaseYear) {
        this.moviename = movieName;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getMoviename() {
        return this.moviename;
    }

    public String getDirector() {
        return this.director;
    }
}
