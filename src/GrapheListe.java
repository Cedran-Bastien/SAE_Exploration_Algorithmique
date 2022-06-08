import java.io.*;
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

    }


    public GrapheListe(String nomfich) throws Exception {
        //initialisation des attributs
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
        //lecture du fichier et ajout des arcs et noeuds
        File modelegraphe = new File(nomfich);
        BufferedReader bf = new BufferedReader(new FileReader(modelegraphe));
        try {
            while (true){
                String ligne = bf.readLine();
                int i = 0;
                String depart = "";
                while (i<ligne.length() && !(""+ligne.charAt(1)).equals(" ")){
                    depart+=ligne.charAt(i);
                    i++;
                }
                i++;
                String dest = "";
                while (i<ligne.length() && (""+ligne.charAt(1)).equals(" ")){
                    dest+=ligne.charAt(i);
                    i++;
                }
                i++;
                String cout = "";
                while (i<ligne.length()){
                    cout+=ligne.charAt(i);
                }

                this.ajouterArc(depart,dest,Integer.parseInt(cout));
            }
        }
        catch (IOException oef){
            oef.printStackTrace();
        }
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
    /**
     *
     * @return
     *      les noeuds du graphe
     */
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    @Override
    /**
     * rechercge les arc adjacenta un sommet
     * @param n
     *      nom du sommet
     * @return
     *      liste des arc adjacent
     */
    public List<Arc> suivant(String n) {
        Noeud no = this.ensNoeuds.get(this.ensNoeuds.indexOf(new Noeud(n)));
        return no.getArcs();
    }

    /**
     * methode toString
     * @return
     *      chaine de caracteres modelisant le graphe
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            s += this.ensNoeuds.get(i).nom + " -> ";
            for (int j = 0; j < this.ensNoeuds.get(i).getArcs().size(); j++) {
                s+= this.ensNoeuds.get(i).getArcs().get(j).getDest() + "(" + this.ensNoeuds.get(i).getArcs().get(j).getCout() + ") ";
            }
            s += "\n";
        }
        return s;
    }


    public String toGraphviz(){
        String s = "digraph G {\n";
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            for (int j = 0; j < this.ensNoeuds.get(i).getArcs().size(); j++) {
                Arc act = this.ensNoeuds.get(i).getArcs().get(j);
                s+= this.ensNoeuds.get(i).nom + " -> " + act.getDest() + " [label = " + act.getCout() + "]\n";
            }
        }
        s+= "}";
        return (s);
    }
}
