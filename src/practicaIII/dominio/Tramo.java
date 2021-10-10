package practicaIII.dominio;

import java.util.Objects;

public class Tramo implements Comparable<Tramo> {

    private Estacion estacion1;
    private Integer tiempoEsparcionGas;
    private Estacion estacion2;

    public Tramo() {
    }

    public Tramo(Estacion estacion1, int tiempoEsparcionGas, Estacion estacion2) {
        this.estacion1 = estacion1;
        this.tiempoEsparcionGas = tiempoEsparcionGas;
        this.estacion2 = estacion2;
    }

    public Estacion getEstacion1() {
        return this.estacion1;
    }

    public void setEstacion1(Estacion estacion1) {
        this.estacion1 = estacion1;
    }

    public Integer getTiempoEsparcionGas() {
        return this.tiempoEsparcionGas;
    }

    public void setTiempoEsparcionGas(Integer tiempoEsparcionGas) {
        this.tiempoEsparcionGas = tiempoEsparcionGas;
    }

    public Estacion getEstacion2() {
        return this.estacion2;
    }

    public void setEstacion2(Estacion estacion2) {
        this.estacion2 = estacion2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tramo)) return false;
        Tramo tramo = (Tramo) o;
        return getTiempoEsparcionGas() == tramo.getTiempoEsparcionGas() && getEstacion1().equals(tramo.getEstacion1()) && getEstacion2().equals(tramo.getEstacion2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstacion1(), getTiempoEsparcionGas(), getEstacion2());
    }

    @Override
    public int compareTo(Tramo o) {
        return this.compareTo(o);
    }

    @Override
    public String toString() {
        return "Tramo {" +
                "estacion: " + this.estacion1 +
                ", tiempoEsparcionGas: " + this.tiempoEsparcionGas +
                ", estacion: " + this.estacion2 +
                '}';
    }
}
