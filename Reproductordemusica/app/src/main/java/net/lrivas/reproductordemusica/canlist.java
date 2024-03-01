package net.lrivas.reproductordemusica;

public class canlist {

    String cancion,album,artista;
    int img, musica;

    public canlist(String cancion, String album, String artista, int img, int musica) {
        this.cancion = cancion;
        this.album = album;
        this.artista = artista;
        this.img = img;
        this.musica = musica;
    }

    public String getCancion() {
        return cancion;
    }

    public int getMusica() {
        return musica;
    }

    public void setMusica(int musica) {
        this.musica = musica;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
