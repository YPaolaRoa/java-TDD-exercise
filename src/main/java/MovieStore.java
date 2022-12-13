import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Movie;
import org.apache.commons.lang3.StringUtils;

public class MovieStore {

    private List<Movie> movies = new ArrayList();

    public List<Movie> findByPartialTitle(String partialTitle) {
        return findBy(movie -> StringUtils.containsIgnoreCase(movie.getMoviename(), partialTitle));
    }

    public void add(Movie movie) {
        this.movies.add(movie);
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public List<Movie> findByDirector(String director) {
        return findBy(movie -> movie.getDirector().equalsIgnoreCase(director));
    }

    private List<Movie> findBy(Predicate<Movie> predicate) {
        return this.movies.stream().filter(movie ->
                predicate.test(movie)
        ).collect(Collectors.toList());
    }
}