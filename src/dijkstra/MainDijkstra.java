package dijkstra;

import bellman_ford.BellmanFord;
import graphe.GrapheListe;

import java.io.File;

public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe dsfq = null;
        try {
            dsfq = new GrapheListe("src/graphe/Graphe1.txt");
            System.out.println(dsfq);

            Dijkstra dijkstra = new Dijkstra();
            System.out.println(dijkstra.resoudre(dsfq,"1"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
