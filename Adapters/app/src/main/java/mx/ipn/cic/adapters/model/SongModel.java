package mx.ipn.cic.adapters.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SongModel implements Serializable {

    //Propiedades Privadas
    private String name;
    private String artist;
    private int duration;
    private int year;

    //Constructores
    public SongModel() {
    }

    public SongModel(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public SongModel(String name, String artist, int duration, int year) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.year = year;
    }

    //Métodos de acceso
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Método toString
    @Override
    public String toString() {
        return "SongModel{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                '}';
    }

    public static List<SongModel> defaultItems(int count) {
        List<SongModel> aux = new ArrayList<>();
        for(int x = 1; x <= count; x++) {
            SongModel song = new SongModel("Nombre " + x, "Artista " + x, 10 * x, 2000 + x);
            aux.add(song);
        }
        return aux;
    }
}
