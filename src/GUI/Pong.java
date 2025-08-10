package GUI;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Pong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Pong() {
		
		contentPane = new JPanel(null);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(400, 400, 650, 349);
		setFocusable(true);
		requestFocusInWindow();	
		
		Player player1 = new Player(25, 120, 10, 60);
		Player player2 = new Player(599, 120, 10, 60);
		
		player1.setBackground(Color.BLACK);
		player2.setBackground(Color.BLACK);
		
		contentPane.add(player1);
		contentPane.add(player2);
		
//		JPanel barrita1 = new JPanel();
//		barrita1.setBackground(Color.BLACK);
//		barrita1.setBounds(30, 97, 10, 66);
//		contentPane.add(barrita1);
		
//		JPanel barrita2 = new JPanel();
//		barrita2.setBackground(Color.BLACK);
//		barrita2.setBounds(386, 73, 10, 66);
//		contentPane.add(barrita2);			
		
		
		addKeyListener(new KeyAdapter() { 
		    public void keyPressed(KeyEvent e) {
//		    	int posXbarrita1 = barrita1.getX();
//		    	int posYbarrita1 = barrita1.getY();
//		    	int alturaBarrita1 = barrita1.getHeight();
		    	
//		    	int posYbarrita2 = barrita2.getY();
//		    	int posXbarrita2 = barrita2.getX();
//		    	int alturaBarrita2 = barrita1.getHeight();
		    	
		    	int alturaPanel = contentPane.getHeight();
		    	int anchuraPanel = contentPane.getWidth();
		    	System.out.println(alturaPanel);

		    	if(e.getKeyCode() == KeyEvent.VK_W) {
		    		player1.moverArriba();
//		    		if(posYbarrita1 > 0) {
//		    			barrita1.setLocation(posXbarrita1, posYbarrita1 - 10);
//		    		}
		    	}
		    	else if(e.getKeyCode() == KeyEvent.VK_S){
		    		player1.moverAbajo(alturaPanel);
//		    		if(alturaPanel > (alturaBarrita1 + posYbarrita1)) {
//		    			barrita1.setLocation(posXbarrita1, posYbarrita1 + 10);
//		    		}
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
