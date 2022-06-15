package laby;

import bellman_ford.BellmanFord;
import graphe.Graphe;

import java.io.IOException;

public class MainLabyBonus {

    public static void main(String[] args) throws Exception {
        BellmanFord b = new BellmanFord();

        // Main Labyrinthe Glace
        LabyrintheGlace lg = new LabyrintheGlace("labySimple/laby2.txt");
        Graphe g = lg.genererGraphe();
        System.out.println(b.resoudre(g,"(1,1)").calculerChemin("(13,10)"));
        System.out.println();

        // Main Labyrinthe Porte + clef
        Labyrinthe l = new Labyrinthe("labySimple/labyPorte.txt");
        GrapheLabyrinthe g2 = new GrapheLabyrinthe(l);
        System.out.print(b.resoudre(g2,"(1,1)").calculerChemin(l.getClef()));
        System.out.println(b.resoudre(g2,l.getClef()).calculerChemin(l.getPorte()));
        }
}
