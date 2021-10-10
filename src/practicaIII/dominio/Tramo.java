package practicaIII.dominio;

import java.util.Objects;

public class Tramo implements Comparable<Tramo> {

    private Estacion estacionA;
    private Integer tiempoEsparcionGas;
    private Estacion estacionB;

    public Tramo() {
    }

    public Tramo(Estacion estacionA, int tiempoEsparcionGas, Estacion estacionB) {
        this.estacionA = estacionA;
        this.tiempoEsparcionGas = tiempoEsparcionGas;
        this.estacionB = estacionB;
    }

    public Estacion getEstacionA() {
        return this.estacionA;
    }

    public void setEstacionA(Estacion estacionA) {
        this.estacionA = estacionA;
    }

    public Integer getTiempoEsparcionGas() {
        return this.tiempoEsparcionGas;
    }

    public void setTiempoEsparcionGas(Integer tiempoEsparcionGas) {
        this.tiempoEsparcionGas = tiempoEsparcionGas;
    }

    public Estacion getEstacionB() {
        return this.estacionB;
    }

    public void setEstacionB(Estacion estacionB) {
        this.estacionB = estacionB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tramo)) return false;
        Tramo tramo = (Tramo) o;
        return getTiempoEsparcionGas() == tramo.getTiempoEsparcionGas() && getEstacionA().equals(tramo.getEstacionA()) && getEstacionB().equals(tramo.getEstacionB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstacionA(), getTiempoEsparcionGas(), getEstacionB());
    }

    @Override
    public int compareTo(Tramo o) {
        if (this.hashCode() > o.hashCode()) {
            return 1;
        }
        else if (o.hashCode() > this.hashCode()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Tramo {" +
                "estacion: " + this.estacionA +
                ", tiempoEsparcionGas: " + this.tiempoEsparcionGas +
                ", estacion: " + this.estacionB +
                '}';
    }
}
