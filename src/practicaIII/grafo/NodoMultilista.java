package practicaIII.grafo;

import practicaIII.dominio.Estacion;

public class NodoMultilista {

    private Estacion valorVerticeI;
    private Estacion valorVerticeJ;
    private NodoMultilista ligaVerticeI;
    private NodoMultilista ligaVerticeJ;
    private int sw;

    public NodoMultilista(Estacion valorVerticeI, Estacion valorVerticeJ) {
        this.valorVerticeI = valorVerticeI;
        this.valorVerticeJ = valorVerticeJ;
    }

    public Estacion getValorVerticeI() {
        return this.valorVerticeI;
    }

    public void setValorVerticeI(Estacion valorVerticeI) {
        this.valorVerticeI = valorVerticeI;
    }

    public Estacion getValorVerticeJ() {
        return this.valorVerticeJ;
    }

    public void setValorVerticeJ(Estacion valorVerticeJ) {
        this.valorVerticeJ = valorVerticeJ;
    }

    public NodoMultilista getLigaVerticeI() {
        return this.ligaVerticeI;
    }

    public void setLigaVerticeI(NodoMultilista ligaVerticeI) {
        this.ligaVerticeI = ligaVerticeI;
    }

    public NodoMultilista getLigaVerticeJ() {
        return this.ligaVerticeJ;
    }

    public void setLigaVerticeJ(NodoMultilista ligaVerticeJ) {
        this.ligaVerticeJ = ligaVerticeJ;
    }

    public int getSw() {
        return this.sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    @Override
    public String toString() {
        return "NodoMultilista{" +
                "valorVerticeI: " + this.valorVerticeI +
                ", valorVerticeJ: " + this.valorVerticeJ +
                ", sw=" + this.sw +
                '}';
    }
}
