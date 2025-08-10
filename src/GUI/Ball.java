package GUI;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;
	private Pong pong;

	/**
	 * Create the panel.
	 */
	public Ball(int posX, int posY, int ancho, int altura) {
		setBounds(posX, posY, ancho, altura);
	}
	public void mover() {
		int dx = 2; //delta x, osea la cantidad de pixeles que se va a mover la pelota, por lo tanto es la velocidad
		int dy = 2; //delta y, velocidad
		int posY = getY();
		int posX = getX();
		posX += dx;
		posY += dy;
	}
	public void rebotar(int ancho, int altura, int dx, int dy, int posX, int posY) {
		if (posX <= 0 || posX >= 600 - ancho) {						// 600 es el valor absoluto del ancho de la pestaña
																	// la primer condición es si se toca la pared izquierda, 
																	// y la segunda es si se toca la derecha, que se hace el ancho de la cancha menos el ancho de la pelota
																	// se hace la resta ya que la posicion de "x" se toma desde arriba a la izquierda del objeto "pelota"
			dx *= -1;  												// se invierte el movimiento de la pelota una vez rebota en la pared derecha o izquierda
		}
		
		if (posY <= 0 || posY >= 310 - altura) {					// 310 es el valor absoluto del alto de la pestaña
																	// la primer condición es si se toca la parte de arriba de la pantalla, 
																	// y la segunda es si se toca la parte de abajo de la pantalla menos la altura de la pelota
																	// se hace la resta ya que la posicion de "y" se toma desde arriba a la izquierda del objeto "pelota"
			dy *= -1;  												// se invierte el movimiento de la pelota una vez rebota 	
		}
	}

}
