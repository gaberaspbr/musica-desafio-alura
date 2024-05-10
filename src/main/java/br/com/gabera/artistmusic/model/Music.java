package br.com.gabera.artistmusic.model;

import jakarta.persistence.*;

@Entity
@Table(name="musicas")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String album;
    @ManyToOne
    private Artista artista;

    public Music(){}

    public Music(String titulo, String album){
        this.titulo = titulo;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        var genero = artista.getGenero().toString().substring(0,1);
        return "Titulo:'" + titulo + '\'' +
                ", Álbum:'" + album + '\'' +
                ", " + artista.getTipo().getTipoArtista() +  ":" +
                " " + artista.getNome() +  '\'' +
                ", Gênero:" + artista.getGenero().getTiposGeneros();
    }
}
