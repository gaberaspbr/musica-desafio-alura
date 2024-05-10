package br.com.gabera.artistmusic.model;

public enum Tipo {
    BANDA("Banda"),
    DUPLA("Dupla"),
    ARTISTA("Artista");

    private String tipoArtista;

    Tipo(String tipoArtista){
        this.tipoArtista = tipoArtista;
    }

    public static boolean fromString(String text) {
        for(Tipo tipo : Tipo.values()) {
            if (tipo.tipoArtista.equalsIgnoreCase(text)) {
                return true;
            }
        }
        return false;
    }

    public static Tipo getTipo(String text){
        for (Tipo tipo : Tipo.values()) {
            if (tipo.tipoArtista.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo não encontrado " + text);
    }

    public String getTipoArtista() {
        return tipoArtista;
    }
}
