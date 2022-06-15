package laby;

import bellman_ford.BellmanFord;
import dijkstra.Dijkstra;
import graphe.Arc;

import java.io.IOException;
import java.util.List;

public class MainGrapheLaby {

    public static void main(String[] args) throws Exception {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        GrapheLabyrinthe g = new GrapheLabyrinthe(l);
        // test methode listeNoeuds
        System.out.println(g.listeNoeuds());
        System.out.println();

        //test methode suivant
        List<Arc> a = g.suivant("(3,2)");
        String s = "";
        for (int i = 0; i < a.size(); i++) {
            s += a.get(i).getDest() + a.get(i).getCout() + "  ";
        }
        System.out.println(s);
        System.out.println();

        BellmanFord b = new BellmanFord();
        Dijkstra d = new Dijkstra();

        //test chemin le plus court BellmanFord
        System.out.println(b.resoudre(g,"(1,1)").calculerChemin("(8,5)"));

        //test chemin le plus court Dijkstra
        System.out.println(d.resoudre(g,"(1,1)").calculerChemin("(8,5)"));

    }
}
