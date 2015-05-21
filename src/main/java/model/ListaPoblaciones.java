package model;

import java.util.SortedSet;
import java.util.TreeSet;
import paa.provincias.IPoblacion;

public class ListaPoblaciones {
    private SortedSet<IPoblacion> poblaciones = null;
    private String provincia = "";

    public ListaPoblaciones() {
        poblaciones = new TreeSet<IPoblacion>();
        provincia = "";
    }

    public ListaPoblaciones(SortedSet<IPoblacion> poblaciones, String provincia) {
        this.poblaciones = poblaciones;
        this.provincia = provincia;
    }

    public SortedSet<IPoblacion> getPoblaciones() {
        return poblaciones;
    }

    public void setPoblaciones(SortedSet<IPoblacion> poblaciones) {
        this.poblaciones = poblaciones;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
