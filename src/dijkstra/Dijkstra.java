package dijkstra;


import bellman_ford.Valeur;
import graphe.Graphe;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
//   Fonction resoudre (Graphe G, Noeud A)
//    Debut
//    Q <- {} // utilisation d’une liste de noeuds `a traiter
//    Pour chaque sommet v de G faire
//      v.distance <- Infini
//      v.parent <- Ind´efini
//      Q <- Q U {v} // ajouter le sommet v `a la liste Q
//    Fin Pour
//    A.distance <- 0
//    Tant que Q est un ensemble non vide faire
//      u <- un sommet de Q telle que u.distance est minimale
//      Q <- Q \ {u} // enlever le sommet u de la liste Q
//      Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
//          D <- u.distance + poids(u,v)
//          Si D < v.distance
//              Alors v.distance <- D
//              v.parent <- u
//          Fin Si
//      Fin Pour
//    Fin Tant que
//    Fin

    /**
     * opermet de resoudre un graphe
     * @param g
     *      graphe a resoudre
     * @param depart
     *      noeud de depart
     * @return
     *      objet valeur (resultat de la resolution)
     * @throws Exception
     */
    public Valeur resoudre (Graphe g, String depart) throws Exception {
        List<String> listeN = new ArrayList<String>();
        Valeur res = new Valeur();


        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            res.setValeur(g.listeNoeuds().get(i),Double.MAX_VALUE);
            res.setParent(g.listeNoeuds().get(i),null);
            listeN.add(g.listeNoeuds().get(i));
        }
        res.setValeur(depart,0);
        res.setParent(depart,null);
        while (!listeN.isEmpty()) {
            String min = listeN.get(0);
            for (int i = 0; i < listeN.size(); i++) {
                if (res.getValeur(min) > res.getValeur(listeN.get(i))) {
                    min = listeN.get(i);
                }
            }
            listeN.remove(min);
            for (int i = 0; i < g.suivant(min).size(); i++) {
                double D = res.getValeur(min) + g.suivant(min).get(i).getCout();
                if ( D < res.getValeur(g.suivant(min).get(i).getDest())) {
                        res.setValeur(g.suivant(min).get(i).getDest(),D);
                        res.setParent(g.suivant(min).get(i).getDest(),min);
                }
            }
        }
        return res;
    }

}
