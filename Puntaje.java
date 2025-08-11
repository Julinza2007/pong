package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Puntaje {
    private int puntaje1;
    private int puntaje2;

    public Puntaje() {
        puntaje1 = 0;
        puntaje2 = 0;
    }

    public void addScore(int player) {
        if (player == 1) {
            puntaje1++;
        } else if (player == 2) {
            puntaje2++;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 36));
        g.drawString(String.valueOf(puntaje1), 100, 50); // puntaje jugador 1
        g.drawString(String.valueOf(puntaje2), 500, 50); // puntaje jugador 2
    }

    public int getScore1() {
        return puntaje1;
    }

    public int getScore2() {
        return puntaje2;
    }
}

