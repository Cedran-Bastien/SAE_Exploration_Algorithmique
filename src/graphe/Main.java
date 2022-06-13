package graphe;

import bellman_ford.Valeur;

public class Main {
    public static void main(String[] args) {
        GrapheListe fig1 = new GrapheListe();
        Valeur v = new Valeur();
        v.setParent("A","E");
        v.setParent("A","D");
        System.out.println(v.toString());


//        try {
//            fig1.ajouterArc("A","B",12);
//            fig1.ajouterArc("A","D",87);
//            fig1.ajouterArc("C","A",19);
//            fig1.ajouterArc("D","C",10);
//            fig1.ajouterArc("D","B",23);
//            fig1.ajouterArc("B","E",11);
//            fig1.ajouterArc("E","D",43);
//            System.out.println(fig1);
//            System.out.println(fig1.toGraphviz());
//
//            GrapheListe dsfq = new GrapheListe("src/Graphe1.txt");
//            System.out.println(dsfq);
//            System.out.println(dsfq.toGraphviz());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }



    }
}
