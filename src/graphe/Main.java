package graphe;

import bellman_ford.BellmanFord;
import bellman_ford.Valeur;
import dijkstra.Dijkstra;

public class Main {
    public static void main(String[] args) {
        GrapheListe fig1 = new GrapheListe();
        try {
            //question 7
            fig1.ajouterArc("A","B",12);
            fig1.ajouterArc("A","D",87);
            fig1.ajouterArc("C","A",19);
            fig1.ajouterArc("D","C",10);
            fig1.ajouterArc("D","B",23);
            fig1.ajouterArc("B","E",11);
            fig1.ajouterArc("E","D",43);
            System.out.println(fig1);
            System.out.println(fig1.toGraphviz());

            //question 12
            GrapheListe dsfq = new GrapheListe("src/graphe/Graphe1.txt");
            System.out.println(dsfq);
            System.out.println(dsfq.toGraphviz());

            //question 21
            GrapheListe boucle = new GrapheListe("src/graphe/boucle.txt");
            BellmanFord bellmanFord = new BellmanFord();
            bellmanFord.resoudre(boucle, "A");
            Dijkstra dijkstra =new Dijkstra();
            dijkstra.resoudre(boucle, "A");

            //question24
            GrapheListe grapheListe = Main.genererGraphe(10);
            System.out.println(grapheListe.toGraphviz());

            //question 26
            int i = 10;
            while (i<=1000){
                try {
                    //creation du graphe
                    grapheListe = Main.genererGraphe(10);
                    System.out.println("POUR "+ i + "Noeuds");
                    //resolution avec Bellman
                    double temps_debut = System.nanoTime();
                    Valeur valBellman = bellmanFord.resoudre(grapheListe,grapheListe.listeNoeuds().get(0));
                    double temps_fin = System.nanoTime();
                    double temps_resolution =temps_fin-temps_debut;
                    System.out.println("temps resolution Bellman : "+temps_resolution+ " ms");
                    //resolution avec dijkstra
                    temps_debut = System.nanoTime();
                    Valeur valDijkstra = dijkstra.resoudre(grapheListe, grapheListe.listeNoeuds().get(0));
                    temps_fin = System.nanoTime();
                    double temps_resolution1 =temps_fin-temps_debut;

                    System.out.println("temps resolution Dijkstra : "+temps_resolution1+ " ms");
                    System.out.println("ratio = "+ temps_resolution/temps_resolution1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i*=2;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GrapheListe genererGraphe(int nbNoeuds) throws Exception {
        GrapheListe graph= new GrapheListe();
        //les nombre voulue de noeuds
        for (int i = 0; i<=nbNoeuds;i++) {
            String nouvNoeud = ""+i;
            if (i!=0){
                graph.ajouterArc(""+(i-1),nouvNoeud,(int)(Math.random()*100));
            }
            for (int j = 0; j< (int)(Math.random()*(i/2));j++){
                String destination = ""+(int)(Math.random()*i);
                graph.ajouterArc(nouvNoeud,destination,(int)(Math.random()*100));
            }
        }
        return graph;
    }
}
