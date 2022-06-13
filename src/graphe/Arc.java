package graphe;

public class Arc {
    /**
     * nom du noeuds destination de l'arc
     */
    private String dest;

    /**
     * cout de l'arc (valuation)
     */
    private double cout;

    /**
     * cree un Arc
     * @param dest
     *      destination de l'arc
     * @param cout
     *      cout de l'arc
     * @throws Exception
     *      le cout est toujours positif
     */
    public Arc(String dest, double cout) throws Exception {
        this.dest = dest;
        if (cout < 0) {
            throw new Exception("cout de l'arc negatif");
        }
        else {
            this.cout = cout;
        }
    }

    public String getDest() {
        return this.dest;
    }

    public double getCout() {
        return this.cout;
    }
}
