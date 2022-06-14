package dijkstra;

import bellman_ford.BellmanFord;
import graphe.Graphe;
import graphe.GrapheListe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDijkstra {
    @Test
    public void test_Dijkstra_OK(){
        try {
            //preparation des donnés
            Graphe g = null;
            g = new GrapheListe("src/graphe/Graphe1.txt");

            //methode testé
            Dijkstra b = new Dijkstra();
            String testé = b.resoudre(g,"1").toString();

            //teste
            Assertions.assertEquals(
                    "1 ->  V:0.0 p:null\n" +
                            "10 ->  V:21.0 p:5\n" +
                            "2 ->  V:4.0 p:1\n" +
                            "3 ->  V:13.0 p:2\n" +
                            "4 ->  V:15.0 p:1\n" +
                            "5 ->  V:12.0 p:2\n" +
                            "6 ->  V:24.0 p:9\n" +
                            "7 ->  V:20.0 p:4\n" +
                            "8 ->  V:18.0 p:9\n" +
                            "9 ->  V:16.0 p:3\n"
                    , testé
                    , "le Tostring devrai etre testé");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
