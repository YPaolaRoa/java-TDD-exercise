import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import model.Movie;
import org.junit.Before;
import org.junit.Test;

public class MovieStoreTest {

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
        final MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertEquals(results.size(), 0L);
    }

    @Test
    public void addsAMovieToMovieStore() {
        Movie harryPotter = HARRY_POTTER;
        movieStore.add(harryPotter);
        List<Movie> allMovies = movieStore.getMovies();
        assertTrue(allMovies.contains(harryPotter));
        assertEquals(allMovies.size(), 1L);
    }

    @Test
    public void findsAMovieWhenTitleIsPartiallyMatch() {
        movieStore.add(HARRY_POTTER);
        movieStore.add(STAR_WARS);
        List<Movie> results = movieStore.findByPartialTitle("arry");
        assertEquals(results.size(), 1L);
        assertTrue(results.contains(HARRY_POTTER));
    }


    @Test
    public void findsMoviesWhenTitleIsPartiallyMatch() {
        Movie harryPotter = HARRY_POTTER;
        movieStore.add(harryPotter);
        movieStore.add(STAR_WARS);
        movieStore.add(STAR_TREK);
        List<Movie> results = movieStore.findByPartialTitle("tar");
        assertEquals(results.size(), 2L);
        assertTrue(results.contains(STAR_TREK));
        assertTrue(results.contains(STAR_WARS));
    }

    @Test
    public void findMovieByDirectorWhenPartiallyMatched() {
        movieStore.add(STAR_WARS);
        movieStore.add(STAR_TREK);
        final List<Movie> result = movieStore.findByDirector("George Lucas");
        assertEquals(result.size(), 1);
        assertTrue(result.contains(STAR_WARS));
    }
}
