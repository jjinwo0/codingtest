package ssafy.movie;

public class TitleNotFoundException extends RuntimeException{

    private String title;

    public TitleNotFoundException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
