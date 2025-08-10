package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;
	int dx = 2; 
	int dy = 2;

	/**
	 * Create the panel.
	 */
	public Ball(int posX, int posY, int ancho, int altura) {
		setBounds(posX, posY, ancho, altura);
	}
	public void mover() {
		/*
		int dx = 2; //delta x, osea la cantidad de pixeles que se va a mover la pelota, por lo tanto es la velocidad
		int dy = 2; //delta y, velocidad
		*/
		int posY = getY();
		int posX = getX();
		posX += dx;
		posY += dy;
		setLocation(posX, posY);
	}
	public void rebotar(Player player1, Player player2) {
		/*
		int dx = 2; //delta x, osea la cantidad de pixeles que se va a mover la pelota, por lo tanto es la velocidad
		int dy = 2; //delta y, velocidad
		*/
		int posY = getY();
		int posX = getX();
		if (posX <= 0 || posX >= 600 - 20) {						// 600 es el valor absoluto del ancho de la pestaña y 20 el ancho de la pelota
																	// la primer condición es si se toca la pared izquierda, 
																	// y la segunda es si se toca la derecha, que se hace el ancho de la cancha menos el ancho de la pelota
																	// se hace la resta ya que la posicion de "x" se toma desde arriba a la izquierda del objeto "pelota"
			dx = -dx;  												// se invierte el movimiento de la pelota una vez rebota en la pared derecha o izquierda
		}
		
		if (posY <= 0 || posY >= 310 - 20) {						// 310 es el valor absoluto del alto de la pestaña y 20 el alto de la pelota
																	// la primer condición es si se toca la parte de arriba de la pantalla, 
																	// y la segunda es si se toca la parte de abajo de la pantalla menos la altura de la pelota
																	// se hace la resta ya que la posicion de "y" se toma desde arriba a la izquierda del objeto "pelota"
			dy = -dy;  												// se invierte el movimiento de la pelota una vez rebota 	
		}
		if (posX <= player1.getX() + player1.getWidth() &&
			posX + getWidth() >= player1.getX() && 
			posY <= player1.getY() + player1.getHeight() &&
			posY + getHeight() >= player1.getY()) {
			dx = -dx;
		}
		if (posX <= player2.getX() + player2.getWidth() &&
			posX + getWidth() >= player2.getX() && 
			posY <= player2.getY() + player2.getHeight() &&
			posY + getHeight() >= player2.getY()) {
				dx = -dx;
			}
		
		posX += dx;
		posY += dy;
	}
	/*
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.RED);
	    g.fillOval(0, 0, getWidth(), getHeight());
	}
	*/
	
}
