package br.com.gabera.artistmusic.principal;

import br.com.gabera.artistmusic.model.Artista;
import br.com.gabera.artistmusic.model.Genero;
import br.com.gabera.artistmusic.model.Music;
import br.com.gabera.artistmusic.model.Tipo;
import br.com.gabera.artistmusic.repository.ArtistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private List<Artista> dadosArtistas = new ArrayList<>();
    private Optional<Artista> artistaBusca;
    private Genero genero;
    private Tipo tipo;

    private ArtistaRepository repositorio;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){
        var opcao = 0;
        do{
            var menu = """
                    
                    1 - Cadastrar artista
                    2 - Cadastrar música
                    3 - Listar músicas
                    4 - Buscar música por artistas
                    5 - Buscar por gênero
                                    
                    0 - Sair                                 
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastraArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    listarMusicasPorArtista();
                    break;
                case 5:
                    buscarMusicaPorGenero();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 0);

    }

    private void cadastraArtista() {
        System.out.println("Digite o nome do artista");
        var nomeArtista = leitura.nextLine();
        artistaBusca = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

        if(!artistaBusca.isPresent()) {
            String digitaGenero = "";
            boolean validador = false;
            do{
                System.out.println("Artista\\Banda pertence a qual gênero? \n" + Genero.printAll());
                digitaGenero = leitura.nextLine();
                if(Genero.fromString(digitaGenero)) {
                    System.out.println("Genêro não encontrado!");
                } else {
                    validador = true;
                    genero = Genero.getGenero(digitaGenero);
                }
            }while(!validador);

            validador = false;

            do{
                System.out.println("É uma banda, dupla ou solo? ");
                digitaGenero = leitura.nextLine();
                if(digitaGenero.equalsIgnoreCase("solo")){
                    digitaGenero = "artista";
                }
                if(!Tipo.fromString(digitaGenero)) {
                    System.out.println("Não encontrado!");
                } else {
                    validador = true;
                    tipo = Tipo.getTipo(digitaGenero);
                }
            }while(!validador);

            Artista artista = new Artista(nomeArtista, genero, tipo);

            repositorio.save(artista);
        } else {
            System.out.println("Artista já cadastrado");
        }
    }

    private void cadastrarMusica() {
        boolean validador = false;
        listarArtistas();
        do{
            System.out.println("\nDe qual artista listado é a música?\nDigite 0 se quiser voltar ao menu principal");
            var nomeArtista = leitura.nextLine();
            if(nomeArtista.equals("0")){
                break;
            }
            artistaBusca = repositorio.findByNomeContainingIgnoreCase(nomeArtista);
            if(artistaBusca.isPresent()){
                var artista = artistaBusca.get();
                List<Music> musicas = new ArrayList<>();
                var nomeMusica = "";
                while(!nomeMusica.equals("0")){
                    System.out.println("Digite a música do " + nomeArtista + "\nou digite 0 para sair");
                    nomeMusica = leitura.nextLine();
                    if(!nomeMusica.equals("0")){
                        System.out.println("Digite o nome do álbum");
                        var nomeAlbum = leitura.nextLine();
                        Music music = new Music(nomeMusica, nomeAlbum);
                        musicas.add(music);
                    }
                }
                if(!musicas.isEmpty()) {
                    artista.setMusicas(musicas);
                    repositorio.save(artista);
                }
                validador = true;
            } else {
                System.out.println("Artista não encontrado");
            }
        }while(!validador);
    }

    private void listarArtistas(){
        dadosArtistas = repositorio.findAll();

        dadosArtistas.stream()
                .forEach(a -> System.out.println(a.getNome()));
    }

    private void listarMusicas(){
        var musicas = repositorio.allMusic();
        musicas.stream()
                .forEach(System.out::println);
    }

    private void listarMusicasPorArtista(){
        System.out.println("Digite o nome do artista ou banda");
        var busca = leitura.nextLine();
        var musicas = repositorio.allMusic(busca);
        musicas.stream()
                .forEach(System.out::println);
    }

    private void buscarMusicaPorGenero(){
        String digitaGenero = "";
        System.out.println("Digite o gênero \n" + Genero.printAll());
        digitaGenero = leitura.nextLine();
        if(Genero.fromString(digitaGenero)) {
            System.out.println("Genêro não encontrado!");
        } else {
            var lista = repositorio.procuraPorGenero(Genero.getGenero(digitaGenero));
            lista.stream()
                    .forEach(System.out::println);
        }
    }
}
