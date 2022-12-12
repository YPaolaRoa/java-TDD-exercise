import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Movie;
import org.apache.commons.lang3.StringUtils;

public class MovieStore {
    private List<Movie> movies = new ArrayList();

    public MovieStore() {
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        return this.movies.stream().filter((movie) ->
           StringUtils.containsIgnoreCase(movie.getMoviename(), partialTitle)
        ).collect(Collectors.toList());
    }

    public void add(Movie movie) {
        this.movies.add(movie);
    }

    public List<Movie> getMovies() {
        return this.movies;
    }
}