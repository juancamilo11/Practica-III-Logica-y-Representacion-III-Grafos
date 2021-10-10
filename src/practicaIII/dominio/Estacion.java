package practicaIII.dominio;

import java.util.Objects;

public class Estacion implements Comparable<Estacion>{

    private String nombre = "Estacion sin nombre";
    private int numEstacion;

    public Estacion() {
    }

    public Estacion(int numEstacion) {
        this.numEstacion = numEstacion;
    }

    public Estacion(String nombre, int numEstacion) {
        this.nombre = nombre;
        this.numEstacion = numEstacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumEstacion() {
        return this.numEstacion;
    }

    public void setNumEstacion(int numEstacion) {
        this.numEstacion = numEstacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estacion)) return false;
        Estacion estacion = (Estacion) o;
        return getNumEstacion() == estacion.getNumEstacion();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumEstacion());
    }

    @Override
    public int compareTo(Estacion o) {
        return this.compareTo(o);
    }

    @Override
    public String toString() {
        return "Estación {" +
                "nombre='" + this.nombre + '\'' +
                ", numEstacion='" + this.numEstacion + '\'' +
                " }";
    }
}
