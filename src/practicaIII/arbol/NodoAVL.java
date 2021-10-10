package practicaIII.arbol;

import practicaIII.dominio.Tramo;

public class NodoAVL {
    
    private int factorBalance;
    private Tramo tramo;
    private NodoAVL ligaDerecha;
    private NodoAVL ligaIzquierda;

    public NodoAVL(Tramo tramo) {
        this.tramo = tramo;
        this.factorBalance = 0;
    }
    
    public int getFactorBalance() {
        return this.factorBalance;
    }

    public void setFactorBalance(int factorBalance) {
        this.factorBalance = factorBalance;
    }

    public Tramo getEstacion() {
        return this.tramo;
    }

    public void setEstacion(Tramo tramo) {
        this.tramo = tramo;
    }

    public NodoAVL getLigaDerecha() {
        return this.ligaDerecha;
    }

    public void setLigaDerecha(NodoAVL ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }

    public NodoAVL getLigaIzquierda() {
        return this.ligaIzquierda;
    }

    public void setLigaIzquierda(NodoAVL ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }
}
  