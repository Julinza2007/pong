package GUI;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;
	int dx = 2; 
	int dy = 2;
	private Puntaje puntaje;

	/**
	 * Create the panel.
	 */
	public Ball(int posX, int posY, int ancho, int altura, Puntaje puntaje) {
        this.puntaje = puntaje;
        setBounds(posX, posY, ancho, altura);
    }
	public void mover() {
		/*
		int dx = 2; //delta x, o sea la cantidad de pixeles que se va a mover la pelota, por lo tanto es la velocidad
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
		
// Si pasa por el lado izquierdo, es punto del 2
		if (posX <= 0) {
            puntaje.addScore(2);
            resetBall(300, 150, 1); 
            return;
        }
		
// Si pasa por el lado derecho, es punto del 1
        if (posX >= 600 - getWidth()) {
            puntaje.addScore(1);
            resetBall(300, 150, -1); 
            return;
        }

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
		if (posX <= player1.getX() + player1.getWidth() &&			// se compara la posición X de la pelota con la posición X del jugador 1 mas el ancho que tiene la paleta
			posX + getWidth() >= player1.getX() && 					// se compara la posición X de la pelota, mas su ancho, con la posición X de la paleta 1
			posY <= player1.getY() + player1.getHeight() &&			// se compara la posición Y de la pelota con la posición Y del jugador 1 mas la altura que tiene la paleta
			posY + getHeight() >= player1.getY()) {					// se compara la posición Y de la pelota, mas su altura, con la posición Y de la paleta 1 
			dx = -dx;					//se invierte la dirección de la pelota
		}
		
		if (posX <= player2.getX() + player2.getWidth() &&			// se compara la posición X de la pelota con la posición X del jugador 2 mas el ancho que tiene la paleta
			posX + getWidth() >= player2.getX() && 					// se compara la posición X de la pelota, mas su ancho, con la posición X de la paleta 2
			posY <= player2.getY() + player2.getHeight() &&			// se compara la posición Y de la pelota con la posición Y del jugador 2 mas la altura que tiene la paleta
			posY + getHeight() >= player2.getY()) {					// se compara la posición Y de la pelota, mas su altura, con la posición Y de la paleta 2
				dx = -dx;				//se invierte la dirección de la pelota
			}
		
		posX += dx;
		posY += dy;
	}
	private void resetBall(int x, int y, int dirX) {
        setLocation(x, y);
        dx = 2 * dirX; // direccion hacia quien perdio
        dy = 2;
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
