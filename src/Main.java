public class Main {
    public static void main(String[] args) {
        GrapheListe fig1 = new GrapheListe();
        try {
            fig1.ajouterArc("A","B",12);
            fig1.ajouterArc("A","D",87);
            fig1.ajouterArc("A","C",19);
            fig1.ajouterArc("D","C",10);
            fig1.ajouterArc("D","B",23);
            fig1.ajouterArc("B","E",11);
            fig1.ajouterArc("E","D",43);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
