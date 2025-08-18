package GUI;

import javax.swing.JPanel;

public class Player extends JPanel {

	private static final long serialVersionUID = 1L;

	public Player(int posX, int posY, int ancho, int altura) { // Este sería el constructor.
		setBounds(posX, posY, ancho, altura);					
	}
	
	public void moverArriba() { // Método para mover hacia arriba el jugador.
		int posY = getY();
		int posX = getX();
		
		if(posY > 0) { // Si pasa del limite de la parte superior del panel, el jugador no va a poder seguir avanzando. donde 15 es el alto del jugador.
			setLocation(posX, posY - 15);
		}
	}
	
	public void moverAbajo(int alturaPanel) { // Método para mover hacia abajo el jugador.
		int posY = getY();
		int posX = getX();
		int alturaPaleta = getHeight();
		
		
		if(alturaPanel > (posY + alturaPaleta)) { // Si pasa del límite de la parte inferior del panel, el jugador no va a poder seguir avanzando.
			setLocation(posX, posY + 15);
		}
	}
}