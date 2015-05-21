package model;

public class Provincia {
    private String nombre = null;
    private int poblaciones = 0;

    public Provincia() {
        nombre = "";
        poblaciones = 0;
    }

    public Provincia(String nombre, int poblaciones) {
        this.nombre = nombre;
        this.poblaciones = poblaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblaciones() {
        return poblaciones;
    }

    public void setPoblaciones(int poblaciones) {
        this.poblaciones = poblaciones;
    }
}
