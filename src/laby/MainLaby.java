package laby;

import bellman_ford.BellmanFord;
import dijkstra.Dijkstra;
import graphe.Graphe;

import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) throws Exception {

        BellmanFord b = new BellmanFord();
        Dijkstra d = new Dijkstra();

        System.out.println("laby1:");
        Labyrinthe laby1 = new Labyrinthe("labySimple/laby0.txt");
        Graphe g1 = laby1.genererGraphe();
        System.out.println((b.resoudre(g1,"(1,1)")).calculerChemin("(4,3)"));
        System.out.println((d.resoudre(g1,"(1,1)")).calculerChemin("(4,3)"));


        System.out.println("\nlaby2:");
        Labyrinthe laby2 = new Labyrinthe("labySimple/laby1.txt");
        Graphe g2 = laby2.genererGraphe();
        System.out.println((b.resoudre(g2,"(1,1)")).calculerChemin("(8,5)"));
        System.out.println((d.resoudre(g2,"(1,1)")).calculerChemin("(8,5)"));


        System.out.println("\nlaby3:");
        Labyrinthe laby3 = new Labyrinthe("labySimple/laby2.txt");
        Graphe g3 = laby3.genererGraphe();
        System.out.println((b.resoudre(g3,"(1,1)")).calculerChemin("(17,8)"));
        System.out.println((d.resoudre(g3,"(1,1)")).calculerChemin("(17,8)"));

    }
}
