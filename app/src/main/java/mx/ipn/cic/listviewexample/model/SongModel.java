package mx.ipn.cic.listviewexample.model;

import java.io.Serializable;

public class SongModel implements Serializable {

    //Propiedades Privadas

    private String name;
    private String artist;

    //Constructores

    public SongModel() {
    }

    public SongModel(String name, String artist) {
        this.name = name;
        this.artist = artist;
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

    //Método toString

    @Override
    public String toString() {
        return "SongModel{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
