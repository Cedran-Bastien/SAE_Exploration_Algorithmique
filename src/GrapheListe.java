import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    /**
     * list des nom des noeuds du graphe
     */
    private List<String> ensNom;

    /**
     * list des Noeuds du graphe
     */
    private List<Noeud> ensNoeuds;

    /**
     * cree un graphe vide en initialisant les attributs
     */
    public GrapheListe(){
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

    /**
     * Ajoute un arc au graphe en creant les noeuds si besoin
     * @param depart
     *      noeud de departs
     * @param destination
     *      noeud de destination
     * @param cout
     *      cout de l'arc
     * @throws Exception
     */
    void ajouterArc(String depart, String destination, double cout) throws Exception {
        if (!this.ensNom.contains(depart) ){
            Noeud nedepart = new Noeud(depart);
            this.ensNoeuds.add(nedepart);
            this.ensNom.add(depart);
        }
        else if (!this.ensNom.contains(destination)){
            Noeud nedest = new Noeud(destination);
            this.ensNoeuds.add(nedest);
            this.ensNom.add(destination);
        }
        this.ensNoeuds.get(this.ensNoeuds.indexOf(new Noeud(depart))).ajouterArc(destination,cout);
    }

    @Override
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    @Override
    public List<Arc> suivant(String n) {
        Noeud no = this.ensNoeuds.get(this.ensNoeuds.indexOf(new Noeud(n)));
        return no.getArcs();
    }
}
