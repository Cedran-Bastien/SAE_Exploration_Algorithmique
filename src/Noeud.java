import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

/**
 * classe representant le noeud d'un graphe
 */
public class Noeud {

    /**
     * Attribut representant le nom du noeud
     */
    public String nom;

    /**
     * Attribut representant la listes des arcs du noeud
     */
    private List<Arc> adj;


    /**
     * constructeur noeud de depart
     */
    public Noeud(String n) {
        this.nom = n;
        this.adj = new ArrayList<>();
    }

    /**
     * methode permetant de montrer si 2 noeud sont egaux
     */
    public boolean equals(Object o) {
        return this.nom.equals(((Noeud)o).nom);
    }

    /**
     * ajout d'un arc au noeud
     * @param destination le nom du noeud de destination
     * @param cout cout pour passer au noead destination
     */
    public void ajouterArc(String destination, double cout) throws Exception {
        this.adj.add(new Arc(destination,cout));
    }


}
