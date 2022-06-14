package bellman_ford;

import graphe.GrapheListe;

public class MainBellmanFord {
    public static void main(String[] args) {
        GrapheListe dsfq = null;
        try {
            dsfq = new GrapheListe("src/graphe/Graphe1.txt");
            System.out.println(dsfq);
            System.out.println(dsfq.toGraphviz());

            BellmanFord bf = new BellmanFord();
            System.out.println(bf.resoudre(dsfq,"1"));
            System.out.println(bf.resoudre(dsfq,"1").calculerChemin("10"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
