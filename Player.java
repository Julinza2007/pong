package GUI;

import javax.swing.JPanel;

public class Player extends JPanel {

	private static final long serialVersionUID = 1L;

	public Player(int posX, int posY, int ancho, int altura) {
		setBounds(posX, posY, ancho, altura);					// Este sería el constructor.
	}
	
	public void moverArriba() {
		int posY = getY();
		int posX = getX();
		
		if(posY > 0) {
			setLocation(posX, posY - 15);
		}
	}
	
	public void moverAbajo(int alturaPanel) {
		int posY = getY();
		int posX = getX();
		int alturaPaleta = getHeight();
		
		
		if(alturaPanel > (posY + alturaPaleta)) {
			setLocation(posX, posY + 15);
		}
	}
}