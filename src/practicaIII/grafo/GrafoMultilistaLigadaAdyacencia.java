package practicaIII.grafo;

import practicaIII.dominio.Estacion;
import practicaIII.dominio.Tramo;
import practicaIII.grafo.costo.MatrizCostos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrafoMultilistaLigadaAdyacencia {

    private NodoMultilista[] vecNodosMultilistas;
    private MatrizCostos matrizCostos;

    public GrafoMultilistaLigadaAdyacencia(List<Tramo> listaTramos) {

        this.vecNodosMultilistas = obtenerListaNodosMultilistas(listaTramos);
        this.matrizCostos = new MatrizCostos(listaTramos);

        for (int i = 1 ; i < this.vecNodosMultilistas.length; i++) {
            NodoMultilista nodoMultilista = new NodoMultilista(tramo.getEstacionA(), tramo.getEstacionB());
            nodoMultilista.setLigaVerticeI(vecNodosMultilistas[i]);
            vecNodosMultilistas[i] = nodoMultilista;
            nodoMultilista.setLigaVerticeJ(vecNodosMultilistas[j]);
            vecNodosMultilistas[j] = nodoMultilista;
        }


        for (int i = 0; i < n; i++) {
            linea = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                int adya = linea.charAt(j);
                if (adya == 1) {
                    NodoMultilista nm = new NodoMultilista(i + 1, j + 1);
                    nm.setLigaVi(gLocal[i]);
                    gLocal[i] = nm;
                    nm.setLigaVj(gLocal[j]);
                    gLocal[j] = nm;
                }
            }
        }


    }

    private NodoMultilista[] obtenerListaNodosMultilistas(List<Tramo> listaTramos) {
        Set<Estacion> estaciones = new HashSet<>();
        for (Tramo tramo: listaTramos) {
            estaciones.add(tramo.getEstacionA());
            estaciones.add(tramo.getEstacionB());
        }
        return null;
    }

    public void dfs() {
        int visitado[] = new int[listaNodosMultilistas.length];
        dfs(1);
    }

    public void dfs(int v) {
        int visitado[] = new int[listaNodosMultilistas.length];
        dfsRecursivo(v, visitado);
    }

    private void dfsRecursivo(int v, int[] visitado) {
        visitado[v] = 1;
        NodoMultilista nr = listaNodosMultilistas[v - 1];
        while (nr != null) {
            int w = nr.getValorVerticeJ();
            if (visitado[w] == 0) {
                dfsRecursivo(w, visitado);
            }
            nr = nr.getLigaVerticeI();
        }
    }



}

