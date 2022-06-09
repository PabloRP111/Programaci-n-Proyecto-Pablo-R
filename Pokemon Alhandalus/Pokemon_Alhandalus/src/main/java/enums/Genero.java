package enums;

public enum Genero {
HOMBRE  ("./imagenes/hombre.jpg"),
MUJER ("./imagenes/hombre.jpg"), 
NO_BINARIO  ("./imagenes/hombre.jpg");

public final String label;

private Genero(String label) {
    this.label = label;
}
}
