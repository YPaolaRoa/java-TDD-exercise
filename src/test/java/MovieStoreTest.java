import java.util.List;
import model.Movie;
import org.assertj.core.api.WithAssertions;
import org.junit.Before;
import org.junit.Test;

public class MovieStoreTest implements WithAssertions {

    public static final Movie STAR_WARS = new Movie("Star wars", "George Lucas", 1999);
    public static final Movie STAR_TREK = new Movie("STAR trek", "J.J Adams", 2000);
    public static final Movie HARRY_POTTER = new Movie("Harry Potter", "ALfonso Cuarón", 2001);
    private  MovieStore movieStore;

    @Before
    public void setUp() {
       movieStore = new MovieStore();

    }
    @Test
    public void returnsNoResultWhenNoTitlesPartiallyMatch() {
        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results).hasSize(0);
    }

    @Test
    public void addsAMovieToMovieStore() {
        movieStore.add(HARRY_POTTER);
        List<Movie> allMovies = movieStore.getMovies();

        assertThat(allMovies).contains(HARRY_POTTER);
        assertThat(allMovies).hasSize(1);
    }

    @Test
    public void findsAMovieWhenTitleIsPartiallyMatch() {
        movieStore.add(HARRY_POTTER);
        movieStore.add(STAR_WARS);
        List<Movie> results = movieStore.findByPartialTitle("arry");
        assertThat(results).hasSize(1);
        assertThat(results).contains(HARRY_POTTER);
    }


    @Test
    public void findsMoviesWhenTitleIsPartiallyMatch() {
        movieStore.add(HARRY_POTTER);
        movieStore.add(STAR_WARS);
        movieStore.add(STAR_TREK);
        List<Movie> results = movieStore.findByPartialTitle("tar");
        assertThat(results).hasSize(2);
        assertThat(results).contains(STAR_WARS);
        assertThat(results).contains(STAR_TREK);
    }

    @Test
    public void findMovieByDirectorWhenPartiallyMatched() {
        movieStore.add(STAR_WARS);
        movieStore.add(STAR_TREK);
        final List<Movie> results = movieStore.findByDirector("George Lucas");
        assertThat(results).hasSize(1);
        assertThat(results).contains(STAR_WARS);
    }
}
