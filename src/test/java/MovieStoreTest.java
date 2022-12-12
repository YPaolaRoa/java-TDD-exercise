import java.util.List;
import model.Movie;
import org.junit.Assert;
import org.junit.Test;

public class MovieStoreTest {
    public MovieStoreTest() {
    }

    @Test
    public void returnsNoResultWhenNoTitlesPartiallyMatch() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abc");
        Assert.assertEquals(results.size(), 0L);
    }

    @Test
    public void addsAMovieToMovieStore() {
        MovieStore movieStore = new MovieStore();
        Movie harryPotter = new Movie("Harry Potter");
        movieStore.add(harryPotter);
        List<Movie> allMovies = movieStore.getMovies();
        Assert.assertTrue(allMovies.contains(harryPotter));
        Assert.assertEquals((long)allMovies.size(), 1L);
    }

    @Test
    public void findsAMovieWhenTitleIsPartiallyMatch() throws Exception {
        MovieStore movieStore = new MovieStore();
        Movie harryPotter = new Movie("Harry Potter");
        movieStore.add(harryPotter);
        movieStore.add(new Movie("Star wars"));
        List<Movie> results = movieStore.findByPartialTitle("arry");
        Assert.assertEquals(results.size(), 1L);
        Assert.assertTrue(results.contains(harryPotter));
    }

    @Test
    public void findsMoviesWhenTitleIsPartiallyMatch() throws Exception {
        MovieStore movieStore = new MovieStore();
        Movie harryPotter = new Movie("Harry Potter");
        movieStore.add(harryPotter);
        Movie star_wars = new Movie("Star wars");
        movieStore.add(star_wars);
        Movie star_trek = new Movie("STAR trek");
        movieStore.add(star_trek);
        List<Movie> results = movieStore.findByPartialTitle("tar");
        Assert.assertEquals(results.size(), 2L);
        Assert.assertTrue(results.contains(star_trek));
        Assert.assertTrue(results.contains(star_wars));
    }
}
