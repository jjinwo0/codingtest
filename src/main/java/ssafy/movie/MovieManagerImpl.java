package ssafy.movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager{

    private List<Movie> movieList;

    private static IMovieManager instance = new MovieManagerImpl();

    private MovieManagerImpl() {

        movieList = new ArrayList<>();
        loadData();
    }

    public static IMovieManager getInstance() {

        return instance;
    }

    @Override
    public void add(Movie movie) {

        if (movie == null)
            throw new TitleNotFoundException("null값 add 불가");

        movieList.add(movie);
    }

    @Override
    public Movie[] getList() {

        return movieList.stream().toArray(Movie[]::new);
    }

    @Override
    public Movie[] searchByTitle(String title) {

        return movieList.stream()
                .filter(m -> m.getTitle().equals(title))
                .toArray(Movie[]::new);
    }

    @Override
    public Movie[] getMovies() {

        return movieList.stream()
                .filter(m -> !m.getClass().equals(SeriesMovie.class))
                .toArray(Movie[]::new);
    }

    @Override
    public SeriesMovie[] getSeriesMovies() {

        return movieList.stream()
                .filter(m -> m.getClass().equals(SeriesMovie.class))
                .toArray(SeriesMovie[]::new);
    }

    @Override
    public double getRunningTimeAvg() {

        int sum = 0;

        for (Movie m : movieList){
            sum += m.getRunningTime();
        }

        return sum / movieList.size();
    }

    private void loadData() {

        File file = new File("src/data/movie.dat");

        if (file.exists() && file.isFile() && file.canRead()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                movieList = (List<Movie>) input.readObject();  // 파일에서 movieList를 불러옴.
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("[ERROR] 파일 로드 중 오류 발생");
            }
        } else {
            movieList = new ArrayList<>();  // 파일이 없을 경우, 새로운 리스트를 생성.
        }
    }

    @Override
    public void saveData() {

        File fileName = new File("src/data");

        if (!fileName.exists())
            fileName.mkdir();

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/movie.dat"))){
            output.writeObject(movieList);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("[ERROR] 파일 저장 중 문제 발생");
        }
    }
}
