	package GUI;
	
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	
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
		private boolean wPressed = false;
	    private boolean sPressed = false;
	    private boolean upPressed = false;
	    private boolean downPressed = false;
		
		public Pong() {
			contentPane = new JPanel(null);
			setContentPane(contentPane);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setBounds(400, 400, 616, 349);
			setFocusable(true); // Es importante agregar esto para hacer focus en la ventana del juego
			requestFocusInWindow(); // El teclado hace focus solamente en la ventana del juego.
			
			ImageIcon cancha = new ImageIcon(getClass().getResource("/GUI/cancha.png")); // Se importa la imagen del fondo.
			
			Player player1 = new Player(21, 120, 10, 60); // Se instancian los jugadores
			Player player2 = new Player(571, 120, 10, 60);
			
			player1.setBackground(Color.BLACK); // Se les agrega color negro a los dos jugadores.
			player2.setBackground(Color.BLACK);
			
			Score score = new Score(); // Se instancia el puntaje.
			
			
			JPanel marcador = new JPanel() { // Panel del marcador del puntaje
				protected void paintComponent(Graphics g) {
			        score.draw(g); // dibuja el score, donde g es el valor que se establece en Score.java para el puntaje.
			    }
			};
			
			marcador.setBounds(265, 11, 70, 40);  
			contentPane.add(marcador); // Se añade el marcador al panel.
			
			Ball pelota = new Ball(300, 150, 20, 20, score); // Se instancia la pelota.
			pelota.setBackground(Color.RED); // Se le agrga color rojo a la pelota
			
			contentPane.add(pelota); // Se añaden los objetos al panel.
			contentPane.add(player1);
			contentPane.add(player2);
			
			JLabel contenedorCancha = new JLabel(cancha); // Se utiliza un contenedor para la imagen de fondo que es la cancha.
			contenedorCancha.setBounds(0, 0, 600, 310); // Se define la posición y tamaño del contenedor.
			contentPane.add(contenedorCancha);	
	
	
			addKeyListener(new KeyListener() {
						
			    public void keyTyped(KeyEvent e) {} // Se abre el listener para poder escuchar input del teclado en el juego.
	
			    public void keyPressed(KeyEvent e) {
			        int teclaPresionada = e.getKeyCode();
			        
			        if (teclaPresionada == KeyEvent.VK_W) { wPressed = true; }      // Actualiza los booleanos de las teclas cuando están presionadas.
			        if (teclaPresionada == KeyEvent.VK_S) { sPressed = true; }
			        if (teclaPresionada == KeyEvent.VK_UP) { upPressed = true; }
			        if (teclaPresionada == KeyEvent.VK_DOWN) { downPressed = true; }
	
			        int alturaPanel = contentPane.getHeight();
	
			        if (wPressed) { player1.moverArriba(); }
			        if (sPressed) { player1.moverAbajo(alturaPanel); }
	
			        if (upPressed) { player2.moverArriba(); }
			        if (downPressed) { player2.moverAbajo(alturaPanel); }
			    }
	
			    @Override
			    public void keyReleased(KeyEvent e) {
			        int teclaPresionada = e.getKeyCode();
	
			        if (teclaPresionada == KeyEvent.VK_W) { wPressed = false; }     // Actualiza las banderas cuando una tecla es soltada.
			        if (teclaPresionada == KeyEvent.VK_S) { sPressed = false; }
			        if (teclaPresionada == KeyEvent.VK_UP) { upPressed = false; }
			        if (teclaPresionada == KeyEvent.VK_DOWN) { downPressed = false; }
			    }
				});
				
			
			Timer timer = new Timer(10, new ActionListener(){ // Se utiliza un timer para que la pelota se pueda mover constantemente.
				public void actionPerformed(ActionEvent e) {
					pelota.mover(); 					// el valor inicial de la velocidad de la pelota es el valor dentro de "mover()" osea es 2 pixeles en "x" y 2 pixeles en "y".
					pelota.rebotar(player1, player2);	// lo mismo que el anterior
	
					marcador.repaint();
					contentPane.repaint();
				}
			});
				timer.start();
			}
	}