import GUI.Pong;

public class ClasePrimaria {

	public static void main(String[] args) {
		mostrarPong();
	}
	
	public static void mostrarPong() {
		Pong p = new Pong();
		p.setVisible(true);
	}

}
