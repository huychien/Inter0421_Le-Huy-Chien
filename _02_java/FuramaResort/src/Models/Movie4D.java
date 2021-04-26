package Models;

import java.io.Serializable;

public class Movie4D implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    private String nameMovie;

    public Movie4D() {
    }

    public Movie4D(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }
}
