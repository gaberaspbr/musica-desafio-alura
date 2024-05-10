package br.com.gabera.artistmusic.model;

public enum Genero {
    ROCK("Rock"),
    JAZZ("Jazz"),
    SAMBA("Samba"),
    MPB("MPB"),
    RAGGAE("Raggae"),
    SERTANEJO("Sertanejo");

    private String tiposGeneros;

    Genero(String tiposGeneros) {
        this.tiposGeneros = tiposGeneros;
    }

    public static boolean fromString(String text) {
        for(Genero genero : Genero.values()) {
            if(genero.tiposGeneros.equalsIgnoreCase(text)) {
                return false;
            }
        }
        return true;
    }

    public String getTiposGeneros() {
        return tiposGeneros;
    }

    public static Genero getGenero(String text) {
        for (Genero genero : Genero.values()) {
            if (genero.tiposGeneros.equalsIgnoreCase(text)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhuma genêro encontrado para a string fornecida: " + text);
    }

    public static String printAll() {
        String manobra = "";
        for(Genero genero : Genero.values()) {
            manobra += genero + "\n";
        }
        return manobra;
    }
}
