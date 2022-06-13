package graphe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphe {

    @Test
    public void graphe_OK() throws Exception {
        //preparation des donnees
        GrapheListe g = new GrapheListe();

        //methodes a tester
        g.ajouterArc("A", "B", 2);
        g.ajouterArc("B", "A", 3);
        g.ajouterArc("C", "B", 3);


        //test des donnees
        String s = "A -> B(2.0) \nB -> A(3.0) \nC -> B(3.0) \n";
        assertEquals(s, g.toString(), "creation du graphe incorrecte");
        assertEquals(3, g.listeNoeuds().size(), "nombre de noeud incorrecte");

    }

    @Test
    public void graphe_noeud_plusieurs_arcs() throws Exception {
        //preparation des donnees
        GrapheListe g = new GrapheListe();

        //methodes a tester
        g.ajouterArc("A", "B", 2);
        g.ajouterArc("A", "C", 2);
        g.ajouterArc("B", "A", 3);
        g.ajouterArc("C", "B", 3);


        //test des donnees
        String s = "A -> B(2.0) C(2.0) \n" +
                "C -> B(3.0) \n" +
                "B -> A(3.0) \n";
        assertEquals(s, g.toString(), "creation du graphe incorrecte");
        assertEquals(3, g.listeNoeuds().size(), "nombre de noeud incorrecte");

    }

    @Test
    public void graphe_noeud_B_vide() throws Exception {
        //preparation des donnees
        GrapheListe g = new GrapheListe();

        //methodes a tester
        g.ajouterArc("A", "B", 2);
        g.ajouterArc("A", "C", 2);
        g.ajouterArc("C", "B", 3);


        //test des donnees
        String s = "A -> B(2.0) C(2.0) \n" +
                "C -> B(3.0) \n" +
                "\n";
        assertEquals(s, g.toString(), "creation du graphe incorrecte");
        assertEquals(3, g.listeNoeuds().size(), "nombre de noeud incorrecte");

    }
}
