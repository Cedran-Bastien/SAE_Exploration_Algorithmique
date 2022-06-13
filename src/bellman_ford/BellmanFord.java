package bellman_ford;

import graphe.Arc;
import graphe.Graphe;
import graphe.GrapheListe;
import graphe.Noeud;

import java.util.List;

public class BellmanFord {
//    fonction Bellman-Ford(G , d)
//    //init.
//    pour n dans G faire
//           L[n] := +∞
//           parent[n] := null
//    L[d] = 0
//    //boucle
//    continuer := vrai
//    tant que continuer faire :
//      continuer := faux
//      pour chaque arc (x,y,poids) de G faire:
//           si L[x] > L[y] + poids alors
//              L[x] := L[y] + poids
//              parent[y]:= x
//              continuer := vrai
//           fsi
//        fpour
//     ftant
//    retourner L



    public Valeur resoudre(Graphe g, String depart){
        Valeur res = new Valeur();
        //initialisation
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            res.setValeur(g.listeNoeuds().get(i),Double.MAX_VALUE);
            res.setParent(g.listeNoeuds().get(i),null);
        }
        res.setValeur(depart,0);
        res.setParent(depart,null);
        //recherche parent
        boolean continuer = true;
        while (continuer){
            continuer = false;
            for (int i = 0; i < g.listeNoeuds().size(); i++) {
                for (int j = 0; j < g.suivant(g.listeNoeuds().get(i)).size(); j++) {
                    if (res.getValeur(g.suivant(g.listeNoeuds().get(i)).get(j).getDest())> res.getValeur(g.listeNoeuds().get(i)) + g.suivant(g.listeNoeuds().get(i)).get(j).getCout()){
                        res.setValeur(g.suivant(g.listeNoeuds().get(i)).get(j).getDest(),res.getValeur(g.listeNoeuds().get(i)) + g.suivant(g.listeNoeuds().get(i)).get(j).getCout());
                        res.setParent(g.suivant(g.listeNoeuds().get(i)).get(j).getDest(),g.listeNoeuds().get(i));
                        continuer = true;
                    }
                }
            }
        }
        return res;
    }
}
