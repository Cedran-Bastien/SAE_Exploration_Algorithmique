public class Arc {
    /**
     * nom du noeuds destination de l'arc
     */
    private String dest;

    /**
     * cout de l'arc (valuation)
     */
    private double cout;

    public Arc(String dest, double cout) throws Exception {
        this.dest = dest;
        if (cout < 0) {
            throw new Exception("cout de l'arc negatif");
        }
        else {
            this.cout = cout;
        }
    }
}
