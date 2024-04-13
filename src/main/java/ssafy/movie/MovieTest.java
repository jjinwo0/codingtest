package ssafy.movie;

public class MovieTest {
    public static void main(String[] args) {

        Movie movie1 = new Movie(1, "title", "director", "genre", 100);
        SeriesMovie movie2 = new SeriesMovie(1, "title", "director", "genre", 100, 11, "epi");

        IMovieManager manager = MovieManagerImpl.getInstance();

        manager.add(movie1);
        manager.add(movie2);

        System.out.println("===영화 목록===");
        Movie[] movies = manager.getList();

        for (int i=0; i<movies.length; i++){
            System.out.println(movies[i]);
        }

        System.out.println("===일반 영화 목록===");
        Movie[] originMovies = manager.getMovies();

        for (int i=0; i<originMovies.length; i++){
            System.out.println(originMovies[i]);
        }

        System.out.println("===시리즈 영화 목록===");
        SeriesMovie[] seriesMovies = manager.getSeriesMovies();

        for (int i=0; i<seriesMovies.length; i++){
            System.out.println(seriesMovies[i]);
        }

        System.out.println("===title 검색 목록===");
        Movie[] titles = manager.searchByTitle("title");

        for (int i=0; i<titles.length; i++){
            System.out.println(titles[i]);
        }

        System.out.println("===영화 러닝타임 평균값===");
        System.out.println(manager.getRunningTimeAvg());

        manager.saveData();
    }
}
