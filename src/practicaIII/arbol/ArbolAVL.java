package practicaIII.arbol;

import practicaIII.dominio.Tramo;

import java.io.IOException;
import java.io.Writer;

public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
    }

    public NodoAVL insertarDato(Tramo tramo) {

        NodoAVL nodoAInsertar = new NodoAVL(tramo);

        if (raiz == null) {
            raiz = nodoAInsertar;
            return raiz;
        }

        NodoAVL nodoRecorrido = raiz; // Registro que uso para buscar
        NodoAVL padreNodoRecorridoX = null;
        NodoAVL pivote = raiz; // Nodo que se puede desvalancear, la duda (P)
        NodoAVL padrePivote = null;
        NodoAVL nodoRecorridoParaFB; // desde donde rebalancear
        NodoAVL q;

        while (nodoRecorrido != null) {
            // Validar si el nodo x esta en riesgo de desbalanceo
            if (nodoRecorrido.getFactorBalance() != 0) {
                pivote = nodoRecorrido;
                padrePivote = padreNodoRecorridoX;
            }
            // Comparo para moverme por Izq o Der y localizar donde insertar
            int comparacion = nodoAInsertar.getEstacion().compareTo(nodoRecorrido.getEstacion());
            if (comparacion == 0) {
                //es un dato existente, retorno el nodo
                return nodoRecorrido;
            } else if (comparacion < 0) {
                // n es menor
                padreNodoRecorridoX = nodoRecorrido;
                // movimiento por la IZQ
                nodoRecorrido = (NodoAVL) nodoRecorrido.getLigaIzquierda();

            } else {
                //n es mayor
                padreNodoRecorridoX = nodoRecorrido;
                // movimiento por la DER
                nodoRecorrido = (NodoAVL) nodoRecorrido.getLigaDerecha();
            }
        }

        int comparacion = nodoAInsertar.getEstacion().compareTo(padreNodoRecorridoX.getEstacion());
        if (comparacion > 0) {
            padreNodoRecorridoX.setLigaDerecha(nodoAInsertar);
        } else if (nodoAInsertar.getEstacion().compareTo(padreNodoRecorridoX.getEstacion()) < 0) {
            padreNodoRecorridoX.setLigaIzquierda(nodoAInsertar);
        }

        if (nodoAInsertar.getEstacion().compareTo(pivote.getEstacion()) > 0) {
            pivote.setFactorBalance(pivote.getFactorBalance() - 1);
            nodoRecorridoParaFB = (NodoAVL) pivote.getLigaDerecha();
        } else {
            pivote.setFactorBalance(pivote.getFactorBalance() + 1);
            nodoRecorridoParaFB = (NodoAVL) pivote.getLigaIzquierda();
        }
        q = nodoRecorridoParaFB;

        while (nodoRecorridoParaFB != nodoAInsertar) {
            if (nodoAInsertar.getEstacion().compareTo(nodoRecorridoParaFB.getEstacion()) > 0) {
                nodoRecorridoParaFB.setFactorBalance(nodoRecorridoParaFB.getFactorBalance() - 1);
                nodoRecorridoParaFB = (NodoAVL) nodoRecorridoParaFB.getLigaDerecha();
            } else {
                nodoRecorridoParaFB.setFactorBalance(nodoRecorridoParaFB.getFactorBalance() + 1);
                nodoRecorridoParaFB = (NodoAVL) nodoRecorridoParaFB.getLigaIzquierda();
            }
        }

        if (!((pivote.getFactorBalance() == -2) || (pivote.getFactorBalance() == 2))) {
            return nodoAInsertar;
        }

        NodoAVL nuevaRaizSubArbol = null; // Estamos tentados a cambiar de raiz
        if (pivote.getFactorBalance() == +2) {
            if (q.getFactorBalance() == +1) {
                nuevaRaizSubArbol = rotacionDerecha(pivote, q);
            } else {
                nuevaRaizSubArbol = dobleRotacionDerecha(pivote, q);
            }
        } else if (pivote.getFactorBalance() == -2) {
            if (q.getFactorBalance() == -1) {
                nuevaRaizSubArbol = rotacionIzquierda(pivote, q);
            } else {
                nuevaRaizSubArbol = dobleRotacionIzquierda(pivote, q);
            }
        }

        if (padrePivote == null) {
            raiz = nuevaRaizSubArbol;
            return nodoAInsertar;
        }

        if (padrePivote.getLigaIzquierda() == pivote) {
            padrePivote.setLigaIzquierda(nuevaRaizSubArbol);
        } else {
            padrePivote.setLigaDerecha(nuevaRaizSubArbol);
        }
        return nodoAInsertar;
    }

    private NodoAVL rotacionDerecha(NodoAVL p, NodoAVL q) {
        p.setLigaIzquierda(q.getLigaDerecha());
        q.setLigaDerecha(p);
        p.setFactorBalance(0);
        q.setFactorBalance(0);
        return q;
    }

    private NodoAVL dobleRotacionDerecha(NodoAVL p, NodoAVL q) {
        NodoAVL r = (NodoAVL) q.getLigaDerecha();
        q.setLigaDerecha(r.getLigaIzquierda());
        r.setLigaIzquierda(q);
        p.setLigaIzquierda(r.getLigaDerecha());
        r.setLigaDerecha(p);
        switch (r.getFactorBalance()) {
            case 0:
                p.setFactorBalance(0);
                q.setFactorBalance(0);
                break;
            case 1:
                p.setFactorBalance(-1);
                q.setFactorBalance(0);
                break;
            case -1:
                p.setFactorBalance(0);
                q.setFactorBalance(1);
                break;
        }
        r.setFactorBalance(0);
        return r;
    }

    private NodoAVL rotacionIzquierda(NodoAVL p, NodoAVL q) {
        p.setLigaDerecha(q.getLigaIzquierda());
        q.setLigaIzquierda(p);
        p.setFactorBalance(0);
        q.setFactorBalance(0);
        return q;
    }

    private NodoAVL dobleRotacionIzquierda(NodoAVL p, NodoAVL q) {
        NodoAVL r = (NodoAVL) q.getLigaIzquierda();
        q.setLigaIzquierda(r.getLigaDerecha());
        r.setLigaDerecha(q);
        p.setLigaDerecha(r.getLigaIzquierda());
        r.setLigaIzquierda(p);
        switch (r.getFactorBalance()) {
            case 0:
                p.setFactorBalance(0);
                q.setFactorBalance(0);
                break;
            case -1:
                p.setFactorBalance(1);
                q.setFactorBalance(0);
                break;
            case 1:
                p.setFactorBalance(0);
                q.setFactorBalance(-1);
                break;
        }
        r.setFactorBalance(0);
        return r;
    }

    public NodoAVL buscar(Tramo tramo) {
        NodoAVL aux = raiz;
        while (aux != null) {
            if (aux.getEstacion().compareTo(tramo) == 0) {
                return aux;
            } else if (aux.getEstacion().compareTo(tramo) < 0) {
                if (aux.getLigaDerecha() != null) {
                    aux = aux.getLigaDerecha();
                } else {
                    return null;
                }
            } else {
                if (aux.getLigaIzquierda() != null) {
                    aux = aux.getLigaIzquierda();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public NodoAVL getRaiz() {
        return this.raiz;
    }

    public void inorden(Writer salida) throws IOException {
        inordenR(this.raiz, salida);
    }

    private static void inordenR(NodoAVL r, Writer salida) throws IOException {
        if (r != null) {
            inordenR( r.getLigaIzquierda(), salida);
            salida.write(r.getEstacion().toString() + "\n");
            inordenR( r.getLigaDerecha(), salida);
        }
    }

}
