package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private Puntaje puntaje;


	public Pong() {
		contentPane = new JPanel(null);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(400, 400, 616, 349);
		setFocusable(true);
		requestFocusInWindow();
		
		ImageIcon cancha = new ImageIcon(getClass().getResource("/GUI/cancha2.png"));
		
		Player player1 = new Player(21, 120, 10, 60);
		Player player2 = new Player(571, 120, 10, 60);
		
		player1.setBackground(Color.BLACK);
		player2.setBackground(Color.BLACK);
		
		puntaje = new Puntaje();
		Ball pelota = new Ball(300, 150, 20, 20, puntaje);
		pelota.setLocation(290, 143);
		pelota.setBackground(Color.RED);
		contentPane.add(pelota);
		
		contentPane.add(player1);
		contentPane.add(player2);
		JLabel contenedorCancha = new JLabel(cancha);
		contenedorCancha.setBounds(0, 0, 600, 310);
						
		// Panel del marcador del puntaje
		JPanel marcador = new JPanel() {
			protected void paintComponent(Graphics g) {
		        puntaje.draw(g);
		    }
		};
		marcador.setBounds(265, 11, 70, 40);
		contentPane.add(marcador);

		contentPane.add(contenedorCancha);	
		
		addKeyListener(new KeyAdapter() { 
		    public void keyPressed(KeyEvent e) {		
		
		    	int alturaPanel = contentPane.getHeight();

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
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				pelota.mover(); 					// el valor inicial de la velocidad de la pelota es el valor dentro de "mover()" osea es 2 pixeles en "x" y 2 pixeles en "y".
				pelota.rebotar(player1, player2);	// lo mismo que el anterior
				marcador.repaint();
			}
		});
	timer.start();
	}
}
