package mx.ipn.cic.examfragment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.examfragment.R;

public class MovieModel implements Serializable{

    private int image;
    private String title;
    private String year;
    private String director;

    public MovieModel() {
    }

    public MovieModel(int image, String title, String year, String director) {
        this.image = image;
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", director='" + director + '\'' +
                '}';
    }

    public static List<MovieModel> defaultItems(int count) {
        List<MovieModel> lista = new ArrayList<>();
        for(int x = 0; x < count; x++) {
            int image;
            switch ( x % 3 ) {
                case 0:
                    image = R.drawable.uno;
                    break;
                case 1:
                    image = R.drawable.dos;
                    break;
                default:
                    image = R.drawable.tres;
            }
            MovieModel movie = new MovieModel(image, "Title " + x, "Year " + x, "Director " + x);
            lista.add(movie);
        }
        return lista;
    }
}
