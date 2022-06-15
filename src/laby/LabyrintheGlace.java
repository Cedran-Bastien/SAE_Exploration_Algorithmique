package laby;

import java.io.IOException;

public class LabyrintheGlace extends Labyrinthe {
    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public LabyrintheGlace(String nom) throws IOException {
        super(nom);
    }

    public int[] deplacerPerso(int i, int j,String action) {
        int[] pos = {i,j};
        if (!this.murs[i][j]) {
            // calcule case suivante
            int[] suivante = pos;
            while (!this.murs[suivante[0]][suivante[1]]) {
                pos = suivante;
                suivante = getSuivant(suivante[0], suivante[1], action);
            }
        }
        return pos;
    }


}
