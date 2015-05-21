package model;

import java.util.ArrayList;

public class ListaProvincias {
    private ArrayList<Provincia> provincias = null;

    public ListaProvincias() {
        provincias = new ArrayList<Provincia>();
    }

    public ListaProvincias(ArrayList<Provincia> provincias) {
        this.provincias = provincias;
    }

    public ArrayList<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(ArrayList<Provincia> provincias) {
        this.provincias = provincias;
    }

    public void addProvincia(Provincia provincia) {
        provincias.add(provincia);
    }
}
