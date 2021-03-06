package interfacesGraficas;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Jugador;

public class Ventana extends JFrame{

	private HashMap <String,JPanel>pantallas;
	protected String nombre;
	protected Jugador jugador;
	
	public Ventana() {
	this.pantallas=new HashMap<String,JPanel>();
	this.pantallas.put("PantallaInicio", new PantallaInicio(this));
	this.pantallas.put("PantallaPersonaje", new PantallaPersonaje(this));	
	this.pantallas.put("PantallaIniciales", new PantallaIniciales(this));
	
	this.setContentPane(this.pantallas.get("PantallaInicio"));
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle("Pokemon");
	this.setIconImage(new ImageIcon("./imagenes/logo.png").getImage());
	this.setSize(810,680);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	
	}
	
	public void cambiarPantalla(String nombrePantalla) {
		Iterator it =this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual=(JPanel)it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
		
	}
	
	public void cambiarPantalla(String nombrePantalla, String raza) {
       
        Iterator it = pantallas.keySet().iterator();
        while (it.hasNext()) {
            String ventana = (String) it.next();
            pantallas.get(ventana).setVisible(false);
        }
        
        if (nombrePantalla.equals("PantallaPokemon")) {
        	pantallas.clear();
            pantallas.put(nombrePantalla, new PantallaPokemon(this, raza));
        }

        if (pantallas.get(nombrePantalla) == null) {
            switch (nombrePantalla) {
            case "PantallaPokemon":
            	pantallas.put(nombrePantalla, new PantallaPokemon(this, null));
                break;

            }
        }
        JPanel panelActual = pantallas.get(nombrePantalla);
        this.setContentPane(panelActual);
        panelActual.setVisible(true);

    }
}
