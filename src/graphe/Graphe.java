package graphe;

import java.util.List;

public interface Graphe {
    /**
     * @return les noeuds du graphe
     */
    public List<String> listeNoeuds();

    /**
     * rechercge les arc adjacenta un sommet
     *
     * @param n nom du sommet
     * @return liste des arc adjacent
     */
    public List<Arc> suivant(String n) throws Exception;
}
