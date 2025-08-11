package GUI;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
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
		
		Player player1 = new Player(25, 120, 10, 60);
		Player player2 = new Player(571, 120, 10, 60);
		
		player1.setBackground(Color.BLACK);
		player2.setBackground(Color.BLACK);
		
		contentPane.add(player1);
		contentPane.add(player2);		
		
		
		addKeyListener(new KeyAdapter() { 
		    public void keyPressed(KeyEvent e) {
		    	
		    	int alturaPanel = contentPane.getHeight();
		    	System.out.println(alturaPanel);

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
		
		Ball pelota = new Ball(300, 150, 20, 20);
		pelota.setBackground(Color.RED);
		contentPane.add(pelota);
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				pelota.mover(); 					// el valor inicial de la velocidad de la pelota es el valor dentro de "mover()" osea es 2 pixeles en "x" y 2 pixeles en "y".
				pelota.rebotar(player1, player2);	// lo mismo que el anterior
			}
		});
	timer.start();
	}

}
