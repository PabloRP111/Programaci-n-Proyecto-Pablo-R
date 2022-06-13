package interfacesGraficas;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;

import conexionBD.ConexionBD;
import excepciones.casillaDesmarcada;
import excepciones.nombreVacio;
import musica.MusicaFondo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.SwingConstants;

import clases.Jugador;
import clases.Pokemon;

import javax.swing.JTextField;
import java.awt.Font;

public class PantallaPokemon extends JPanel{

	private Ventana ventana;
	protected static String razaPokemon;
	private JTextField dimeNOMBRE;
	private JLabel txttipoPokemon;
	private JLabel txtTipo;
	private JLabel txtNombre;
	private JLabel txtRaza;
	private JLabel texRazaPokemon;

	


	public PantallaPokemon(Ventana v,final String razaPokemon) {
		setBackground(new Color(175, 238, 238));
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, -19, 0, 0, 0, 0, 0, 454, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		 String tipo="";
		
		JLabel fotoPokemon = new JLabel("");
		fotoPokemon.setBackground(new Color(0, 0, 128));
		
		if(razaPokemon=="Bulbasur") {
		fotoPokemon.setIcon(new ImageIcon(PantallaPokemon.class.getResource("/imgs/inicial1.png")));
		tipo="Planta";
		};
		
		if(razaPokemon=="Metapod") {
		fotoPokemon.setIcon(new ImageIcon(PantallaPokemon.class.getResource("/imgs/inicial2.png")));
		tipo="Bicho";
			};

		if(razaPokemon=="Magikcarp") {
		fotoPokemon.setIcon(new ImageIcon(PantallaPokemon.class.getResource("/imgs/inicial3.png")));
		tipo="Agua";
		};
		
		final String tipoPokemon=tipo;
		
		txtTipo = new JLabel("TIPO");
		txtTipo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtTipo.setForeground(new Color(255, 255, 0));
		txtTipo.setBackground(new Color(127, 255, 212));
		GridBagConstraints gbc_txtTipo = new GridBagConstraints();
		gbc_txtTipo.gridwidth = 3;
		gbc_txtTipo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipo.gridx = 1;
		gbc_txtTipo.gridy = 1;
		add(txtTipo, gbc_txtTipo);
		
		txttipoPokemon = new JLabel(tipo);
		txttipoPokemon.setFont(new Font("Tahoma", Font.BOLD, 11));
		txttipoPokemon.setForeground(new Color(255, 255, 0));
		GridBagConstraints gbc_txttipoPokemon = new GridBagConstraints();
		gbc_txttipoPokemon.gridwidth = 3;
		gbc_txttipoPokemon.insets = new Insets(0, 0, 5, 5);
		gbc_txttipoPokemon.gridx = 4;
		gbc_txttipoPokemon.gridy = 1;
		add(txttipoPokemon, gbc_txttipoPokemon);
		
			
		GridBagConstraints gbc_fotoPokemon = new GridBagConstraints();
		gbc_fotoPokemon.gridheight = 3;
		gbc_fotoPokemon.insets = new Insets(0, 0, 5, 5);
		gbc_fotoPokemon.gridx = 7;
		gbc_fotoPokemon.gridy = 2;
		add(fotoPokemon, gbc_fotoPokemon);
		
		JButton Combatir = new BotonPrincipal("COMBATIR");
		Combatir.setHorizontalAlignment(SwingConstants.LEFT);
		Combatir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MusicaFondo musica= new MusicaFondo(new File("./sonidos/LiderGymnasio.wav"));
		        musica.start();
		        
		        String raza=razaPokemon;
		        String nombre=dimeNOMBRE.getText();;
		        int nivel=1;
		        int vida=100;
		        int puntosEXP=0;
		        
		        try {
					new Pokemon(nombre, puntosEXP, nivel, raza, tipoPokemon,vida);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
			}
		});
		
		txtNombre = new JLabel("NOMBRE");
		txtNombre.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtNombre.setForeground(new Color(255, 255, 0));
		txtNombre.setBackground(new Color(127, 255, 212));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		
		dimeNOMBRE = new JTextField();
		GridBagConstraints gbc_dimeNOMBRE = new GridBagConstraints();
		gbc_dimeNOMBRE.gridwidth = 3;
		gbc_dimeNOMBRE.insets = new Insets(0, 0, 5, 5);
		gbc_dimeNOMBRE.fill = GridBagConstraints.HORIZONTAL;
		gbc_dimeNOMBRE.gridx = 4;
		gbc_dimeNOMBRE.gridy = 3;
		add(dimeNOMBRE, gbc_dimeNOMBRE);
		dimeNOMBRE.setColumns(10);
		
		txtRaza = new JLabel("RAZA:");
		txtRaza.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtRaza.setForeground(new Color(255, 255, 0));
		txtRaza.setBackground(new Color(127, 255, 212));
		GridBagConstraints gbc_txtRaza = new GridBagConstraints();
		gbc_txtRaza.gridwidth = 3;
		gbc_txtRaza.insets = new Insets(0, 0, 5, 5);
		gbc_txtRaza.gridx = 1;
		gbc_txtRaza.gridy = 4;
		add(txtRaza, gbc_txtRaza);
		
		texRazaPokemon = new JLabel(razaPokemon);
		texRazaPokemon.setFont(new Font("Tahoma", Font.BOLD, 11));
		texRazaPokemon.setForeground(new Color(255, 255, 0));
		texRazaPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_texRazaPokemon = new GridBagConstraints();
		gbc_texRazaPokemon.gridwidth = 3;
		gbc_texRazaPokemon.insets = new Insets(0, 0, 5, 5);
		gbc_texRazaPokemon.gridx = 4;
		gbc_texRazaPokemon.gridy = 4;
		add(texRazaPokemon, gbc_texRazaPokemon);
		GridBagConstraints gbc_Combatir = new GridBagConstraints();
		gbc_Combatir.insets = new Insets(0, 0, 5, 5);
		gbc_Combatir.gridx = 8;
		gbc_Combatir.gridy = 4;
		add(Combatir, gbc_Combatir);
		
		JTextPane txtpnHabilidades = new JTextPane();
		txtpnHabilidades.setText("- Habilidades:");
		GridBagConstraints gbc_txtpnHabilidades = new GridBagConstraints();
		gbc_txtpnHabilidades.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnHabilidades.fill = GridBagConstraints.BOTH;
		gbc_txtpnHabilidades.gridx = 7;
		gbc_txtpnHabilidades.gridy = 5;
		add(txtpnHabilidades, gbc_txtpnHabilidades);
		
		ventana=v;
		
	}


	public String getRazaPokemon() {
		return razaPokemon;
	}


	public void setRazaPokemon(String razaPokemon) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Pokemon set razaPokemon="+razaPokemon+" where tipo="+this.razaPokemon+"")>0) {
			this.razaPokemon=razaPokemon;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar la razaPokemon o ya estaba asiganado ");
		
	}
	
}
	/*
	public void crearHabilidades(String razaPokemon) {
		try {

		
			new Habilidad(nombre, ptsAtaque, tipoHabilidad, usos);
			
		} catch (SQLException   e1) {
			
			System.err.println("Fallo inserts");

		}
	}

	public void crearPokemon(String razaPokemon) {
		try {

		
			new Pokemon(id,nombre, monedero, aspecto, genero);
			
		} catch (SQLException   e1) {
			
			System.err.println("Fallo inserts");

		}
	}
	*/
	
}
