package ssafy.movie;

import java.io.Serializable;

public class Movie implements Serializable {

    private int id;

    private String title;

    private String director;

    private String genre;

    private int runningTime;

    public Movie() {}

    public Movie(int id, String title, String director, String genre, int runningTime) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", director='").append(director).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", runningTime=").append(runningTime);
        sb.append('}');
        return sb.toString();
    }
}
