package interfacesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
	this.setContentPane(new PantallaInicio(this));
	this.setVisible(true);
	this.setSize(500,300);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle("Pokemon");
	this.setIconImage(new ImageIcon("./imagenes/logo.png").getImage());
	}
	
}