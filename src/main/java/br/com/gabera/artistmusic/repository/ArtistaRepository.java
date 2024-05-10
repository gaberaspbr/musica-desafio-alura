package br.com.gabera.artistmusic.repository;

import br.com.gabera.artistmusic.model.Artista;
import br.com.gabera.artistmusic.model.Genero;
import br.com.gabera.artistmusic.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m")
    List<Music> allMusic();

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:artista%")
    List<Music> allMusic(String artista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.genero = :genero")
    List<Music> procuraPorGenero(Genero genero);
}
