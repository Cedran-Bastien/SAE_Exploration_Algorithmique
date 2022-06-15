package laby;

import graphe.Arc;
import graphe.Graphe;

import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe {

    private Labyrinthe laby;

    public GrapheLabyrinthe(Labyrinthe l) {
        this.laby = l;
    }

    @Override
    public List<String> listeNoeuds() {
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < laby.murs.length; j++) {
            for (int i = 0; i < laby.murs[j].length; i++) {
                if (!laby.murs[j][i]) {
                    String s = "(" + j + "," + i + ")";
                    res.add(s);
                }
            }
        }
        return res;
    }

    @Override
    public List<Arc> suivant(String n) throws Exception {
        List<Arc> res = new ArrayList<Arc>();
        if (this.listeNoeuds().contains(n)) {
            String noeud = this.listeNoeuds().get(this.listeNoeuds().indexOf(n));
            int[] depart = {Integer.parseInt(noeud.charAt(1)+""),Integer.parseInt(noeud.charAt(3)+"")};
            String[] deplacements = {Labyrinthe.BAS,Labyrinthe.DROITE,Labyrinthe.GAUCHE,Labyrinthe.HAUT};
            for (int i = 0; i < deplacements.length; i++) {
                int[] arrivee = this.laby.deplacerPerso(depart[0],depart[1],deplacements[i]);
                String ChaineArrivee = "(" + arrivee[0] + "," + arrivee[1] + ")";
                if (depart[0] != arrivee[0] || depart[1] != arrivee[1]) {
                   res.add(new Arc(ChaineArrivee,1));
                }
            }
        }
        return res;
    }
}
