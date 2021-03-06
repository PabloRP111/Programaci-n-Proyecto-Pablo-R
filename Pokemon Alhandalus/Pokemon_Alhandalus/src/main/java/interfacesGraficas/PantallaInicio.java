package interfacesGraficas;

import javax.swing.JPanel;

import java.applet.AudioClip;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import musica.MusicaFondo;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicio extends JPanel{

	private Ventana ventana;
	
	public PantallaInicio(Ventana v){
		ventana=v;
		
		MusicaFondo musica= new MusicaFondo(new File("./sonidos/centroPokemon.wav"));
        musica.start();
		setLayout(null);
		
		JButton nuevaPartida = new BotonPrincipal("Comenzar");
		nuevaPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("PantallaPersonaje");
			}
			
		});
		add(nuevaPartida);
		
		JLabel cabecera = new JLabel("");
		cabecera.setVerticalAlignment(SwingConstants.TOP);
		cabecera.setIcon(new ImageIcon(PantallaInicio.class.getResource("/imgs/pokemon-logo.gif")));
		cabecera.setHorizontalAlignment(SwingConstants.CENTER);
		cabecera.setBounds(0, 0, 809, 202);
		add(cabecera);
		
		
		
		JLabel fotoFondo = new JLabel("");
		fotoFondo.setIcon(new ImageIcon(PantallaInicio.class.getResource("/imgs/Pokemon-Silver-pokemon-37499954-500-450.gif")));
		fotoFondo.setHorizontalAlignment(SwingConstants.CENTER);
		fotoFondo.setBounds(0, 0, 810, 729);
		add(fotoFondo);
		
		
		
	}
	
	
	
	
}
