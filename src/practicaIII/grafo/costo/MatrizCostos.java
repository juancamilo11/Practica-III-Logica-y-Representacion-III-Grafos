package practicaIII.grafo.costo;

import practicaIII.dominio.Estacion;
import practicaIII.dominio.Tramo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrizCostos {

    private Tripleta[] tripletas;

    public MatrizCostos(List<Tramo> listaTramos) {

        //obtenemos el numero de vertices para el orden de la matriz de costos (Matriz cuadrada)
        int numVertices = obtenerNumVertices(listaTramos);

        this.tripletas = new Tripleta[listaTramos.size() + 1];
        Tripleta configuracion = new Tripleta(numVertices, numVertices, listaTramos.size());
        tripletas[0] = configuracion;
    }

    public int obtenerNumVertices(List<Tramo> listaTramos) {
        Set<Estacion> estaciones = new HashSet<>();
        for (Tramo tramo: listaTramos) {
            estaciones.add(tramo.getEstacionA());
            estaciones.add(tramo.getEstacionB());
        }
        return estaciones.size();
    }

    public void setCostoEntreEstaciones(int numEstacionA, int numEstacionB, int costo) throws Exception {
        Tripleta configuracion = tripletas[0];

        int ordenMatriz = configuracion.getFila();

        if (ordenMatriz <= numEstacionA || ordenMatriz <= numEstacionB) {
            throw new Exception("Esta fuera de los limites de la matriz");
        }

        for (int i = 1; i < (int) configuracion.getValor(); i++) {
            int numEstacionActualA = this.tripletas[i].getFila();
            int numEstacionActualB = this.tripletas[i].getColumna();
            if(numEstacionActualA == numEstacionA && numEstacionActualB == numEstacionB){
                this.tripletas[i] = new Tripleta(numEstacionActualA, numEstacionActualB, costo);
            }
            if(numEstacionActualA == numEstacionB && numEstacionActualB == numEstacionA){
                this.tripletas[i] = new Tripleta(numEstacionActualA, numEstacionActualB, costo);
            }
        }
    }

    public Object getCostoEntreEstaciones(int numEstacionA, int numEstacionB) throws Exception {
        Tripleta configuracion = tripletas[0];

        int ordenMatriz = configuracion.getFila();

        if (ordenMatriz <= numEstacionA || ordenMatriz <= numEstacionB) {
            throw new Exception("Esta fuera de los limites de la matriz");
        }

        for (int i = 1; i < (int) configuracion.getValor(); i++) {
            int numEstacionActualA = this.tripletas[i].getFila();
            int numEstacionActualB = this.tripletas[i].getColumna();
            if(numEstacionActualA == numEstacionA && numEstacionActualB == numEstacionB){
                return (int) this.tripletas[i].getValor();
            }
            if(numEstacionActualA == numEstacionB && numEstacionActualB == numEstacionA){
                return (int) this.tripletas[i].getValor();
            }
        }
        return null;
    }

    public void setTripleta(int cv, Tripleta t) {
        tripletas[cv] = t;
    }

    public Tripleta[] getTripletas() {
        return this.tripletas;
    }

    //La matriz de costos es cuadrada
    public int getOrdenMatriz(){
        return this.tripletas[0].getFila();
    }

}