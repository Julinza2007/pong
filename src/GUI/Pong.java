package GUI;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Pong() {
		contentPane = new JPanel(null);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(400, 400, 616, 349);
		setFocusable(true);
		requestFocusInWindow();
		
		ImageIcon cancha = new ImageIcon(getClass().getResource("/GUI/canchaBuen.png"));
		
		Player player1 = new Player(21, 120, 10, 60);
		Player player2 = new Player(571, 120, 10, 60);
		
		player1.setBackground(Color.BLACK);
		player2.setBackground(Color.BLACK);
		
		contentPane.add(player1);
		contentPane.add(player2);
		JLabel contenedorCancha = new JLabel(cancha);
		contenedorCancha.setBounds(0, 0, 600, 310);
		
		contentPane.add(contenedorCancha);					
		
		addKeyListener(new KeyAdapter() { 
		    public void keyPressed(KeyEvent e) {

		    	int alturaPanel = contentPane.getHeight();
		    	int anchoPanel = contentPane.getWidth();

		    	System.out.println(alturaPanel);
		    	System.out.println(anchoPanel);
		    	

		    	if(e.getKeyCode() == KeyEvent.VK_W) {
		    		player1.moverArriba();
		    	}
		    	else if(e.getKeyCode() == KeyEvent.VK_S){
		    		player1.moverAbajo(alturaPanel);
		    	}
		    	
		    	if(e.getKeyCode() == KeyEvent.VK_UP) {
		    		player2.moverArriba();
		    }
		    	else if(e.getKeyCode() == KeyEvent.VK_DOWN){
		    		player2.moverAbajo(alturaPanel);
		    	}
		    }
		});		
		


	}

}
