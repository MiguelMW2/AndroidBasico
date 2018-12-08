package mx.ipn.cic.adaptersgrid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.adaptersgrid.R;

public class SongModel implements Serializable {

    //Propiedades privadas
    private String title;
    private String artist;
    private int image;

    //Al menos 2 constructores
    public SongModel() {
    }

    public SongModel(String title, String artist, int image) {
        this.title = title;
        this.artist = artist;
        this.image = image;
    }

    //Métodos de acceso
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //Método toString
    @Override
    public String toString() {
        return "SongModel{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", image=" + image +
                '}';
    }

    public static List<SongModel> defaultItems(int count) {
        List<SongModel> lista = new ArrayList<>();
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
            SongModel song = new SongModel("Title " + x, "Artist " + x, image);
            lista.add(song);
        }
        return lista;
    }
}
