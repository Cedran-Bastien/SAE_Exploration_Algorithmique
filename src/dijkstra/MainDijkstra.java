package dijkstra;

import bellman_ford.BellmanFord;
import bellman_ford.Valeur;
import graphe.GrapheListe;

import java.io.File;

public class MainDijkstra {
    public static void main(String[] args) {
        //recuperation des liens des fichier graphe du repertoire
        File dir  = new File("GrapheFile/");
        File[] liste = dir.listFiles();
        GrapheListe grapheListe = null;
        //pour chaque lien (fichier)
        for (int i = 0;i<liste.length;i++){
            String lien = liste[i].toString();
            System.out.println("\nFICHIER : "+lien);
            try {
                //creation du graphe
                grapheListe = new GrapheListe(lien);
                //resolution avec Bellman
                double temps_debut = System.nanoTime();
                BellmanFord bellmanFord = new BellmanFord();
                Valeur valBellman = bellmanFord.resoudre(grapheListe,grapheListe.listeNoeuds().get(0));
                double temps_fin = System.nanoTime();
                double temps_resolution =temps_fin-temps_debut;
                System.out.println("temps resolution Bellman : "+temps_resolution+ " ms");
                //resolution avec dijkstra

                Dijkstra dijkstra =new Dijkstra();
                temps_debut = System.nanoTime();
                Valeur valDijkstra = dijkstra.resoudre(grapheListe, grapheListe.listeNoeuds().get(0));
                temps_fin = System.nanoTime();
                temps_resolution =temps_fin-temps_debut;
                System.out.println("temps resolution Dijkstra : "+temps_resolution+ " ms");
                //pour 10 noeuds aleatoire
                for (int j = 0; j < 10; j++){
                    int index = (int)(Math.random()*grapheListe.listeNoeuds().size());
                    System.out.println("\n\tNoeuds departs : "+grapheListe.listeNoeuds().get(0)+ "  Noeuds destination : "+grapheListe.listeNoeuds().get(index));

                    //calcule du chemin le plus court(Bellman)
                    System.out.println("\tchemin le plus court par bellman : ");
                    temps_debut = System.nanoTime();
                    System.out.println("\t"+valBellman.calculerChemin(grapheListe.listeNoeuds().get(index)));
                    temps_fin = System.nanoTime();
                    temps_resolution =temps_fin-temps_debut;
                    System.out.println("\ttemps : "+temps_resolution+ " ms");

                    //calcule du chemin le plus court(Bellman)
                    System.out.println("\n\tchemin le plus court par dijkstra : ");
                    temps_debut = System.nanoTime();
                    System.out.println("\t"+valDijkstra.calculerChemin(grapheListe.listeNoeuds().get(index)));
                    temps_fin = System.nanoTime();
                    temps_resolution =temps_fin-temps_debut;
                    System.out.println("\ttemps : "+temps_resolution+ " ms");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
