package GUI;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Ball(int posX, int posY, int ancho, int altura) {
		setBounds(posX, posY, ancho, altura);
	}

}
