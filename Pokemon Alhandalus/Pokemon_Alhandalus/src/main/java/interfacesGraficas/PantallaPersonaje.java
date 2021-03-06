package interfacesGraficas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

import musica.MusicaFondo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Genero;
import excepciones.casillaDesmarcada;
import excepciones.nombreVacio;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

import clases.Entrenador;
import clases.Jugador;
import conexionBD.ConexionBD;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPersonaje extends JPanel{
private Ventana ventana;
private JTextField dimeNombre;
private JLabel lblNewLabel;
private JTextPane txtpnHolaSoyEl;
private JLabel textoDimeNombre;
private JLabel textoDimeGenero;
private static JCheckBox noAbogado;
private JButton volver;
private JButton siguiente;

	
	public PantallaPersonaje(Ventana v){
		ventana=v;
		
		setBackground(Color.BLUE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaPersonaje.class.getResource("/imgs/hola.gif")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtpnHolaSoyEl = new JTextPane();
		txtpnHolaSoyEl.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtpnHolaSoyEl.setForeground(new Color(255, 255, 255));
		txtpnHolaSoyEl.setBackground(new Color(0, 0, 255));
		txtpnHolaSoyEl.setText("Hola soy el profesor aok, de apellido fairyUse. \r\nAntes de comenzar nuestra aventura necesito que me respondas a un par de datos:\r\nDime, \u00BFCu\u00E1l es tu nombre?\r\n\u00BFY cu\u00E1l tu g\u00E9nero?\r\n\u00BFY el n\u00FAmero de tel\u00E9fono de tu madre?");
		GridBagConstraints gbc_txtpnHolaSoyEl = new GridBagConstraints();
		gbc_txtpnHolaSoyEl.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnHolaSoyEl.fill = GridBagConstraints.BOTH;
		gbc_txtpnHolaSoyEl.gridx = 2;
		gbc_txtpnHolaSoyEl.gridy = 2;
		add(txtpnHolaSoyEl, gbc_txtpnHolaSoyEl);
		
		textoDimeNombre = new JLabel("Dime tu Nombre");
		textoDimeNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		textoDimeNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textoDimeNombre.setFont(new Font("Sylfaen", Font.BOLD, 17));
		textoDimeNombre.setBackground(new Color(0, 255, 255));
		textoDimeNombre.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_textoDimeNombre = new GridBagConstraints();
		gbc_textoDimeNombre.gridwidth = 2;
		gbc_textoDimeNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textoDimeNombre.gridx = 1;
		gbc_textoDimeNombre.gridy = 4;
		add(textoDimeNombre, gbc_textoDimeNombre);
		
		dimeNombre = new JTextField();
		dimeNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_dimeNombre = new GridBagConstraints();
		gbc_dimeNombre.gridwidth = 2;
		gbc_dimeNombre.insets = new Insets(0, 0, 5, 5);
		gbc_dimeNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_dimeNombre.gridx = 1;
		gbc_dimeNombre.gridy = 5;
		add(dimeNombre, gbc_dimeNombre);
		dimeNombre.setColumns(10);
		
		textoDimeGenero = new JLabel("Dime tu g\u00E9nero");
		textoDimeGenero.setBackground(new Color(0, 255, 255));
		textoDimeGenero.setForeground(new Color(255, 255, 255));
		textoDimeGenero.setFont(new Font("Sylfaen", Font.BOLD, 17));
		GridBagConstraints gbc_textoDimeGenero = new GridBagConstraints();
		gbc_textoDimeGenero.gridwidth = 2;
		gbc_textoDimeGenero.insets = new Insets(0, 0, 5, 5);
		gbc_textoDimeGenero.gridx = 1;
		gbc_textoDimeGenero.gridy = 7;
		add(textoDimeGenero, gbc_textoDimeGenero);
		
		final JComboBox dimeGenero = new JComboBox();
		dimeGenero.setForeground(new Color(128, 0, 0));
		dimeGenero.setFont(new Font("Sylfaen", Font.BOLD, 16));
		dimeGenero.setBackground(new Color(0, 255, 255));
		dimeGenero.setModel(new DefaultComboBoxModel(Genero.values()));
		GridBagConstraints gbc_dimeGenero = new GridBagConstraints();
		gbc_dimeGenero.gridwidth = 2;
		gbc_dimeGenero.insets = new Insets(0, 0, 5, 5);
		gbc_dimeGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_dimeGenero.gridx = 1;
		gbc_dimeGenero.gridy = 8;
		add(dimeGenero, gbc_dimeGenero);
		
		noAbogado = new JCheckBox("No soy abogado de Nintendo");
		noAbogado.setHorizontalAlignment(SwingConstants.TRAILING);
		noAbogado.setVerticalAlignment(SwingConstants.BOTTOM);
		noAbogado.setBackground(new Color(0, 255, 255));
		noAbogado.setForeground(new Color(139, 0, 0));
		noAbogado.setFont(new Font("Sylfaen", Font.BOLD, 14));
		GridBagConstraints gbc_noAbogado = new GridBagConstraints();
		gbc_noAbogado.insets = new Insets(0, 0, 5, 5);
		gbc_noAbogado.gridx = 1;
		gbc_noAbogado.gridy = 10;
		add(noAbogado, gbc_noAbogado);
		
		
		volver = new JButton("Volver");
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("PantallaInicio");
			}
		});
		volver.setFocusable(false);
		volver.setBackground(new Color(127, 255, 212));
		volver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		volver.setForeground(new Color(128, 0, 0));
		volver.setVerticalAlignment(SwingConstants.TOP);
		volver.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_volver = new GridBagConstraints();
		gbc_volver.insets = new Insets(0, 0, 5, 5);
		gbc_volver.gridx = 1;
		gbc_volver.gridy = 12;
		add(volver, gbc_volver);
		
		siguiente = new JButton("Siguiente");
		siguiente.setFocusable(false);
		siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				//Crear base de datos
				Statement query=ConexionBD.conectar();
				
				try {
					query.executeUpdate("Drop table if exists Jugador; ");
					query.executeUpdate("Drop table if exists LiderGymnasio; ");
					query.executeUpdate("Drop table if exists EntrenadorPokemon; ");
					query.executeUpdate("Drop table if exists EntrenadorObjeto; ");
					query.executeUpdate("Drop table if exists habilidadPokemon; ");
					query.executeUpdate("Drop table if exists objetoCuracion; ");
					query.executeUpdate("Drop table if exists objeto; ");
					query.executeUpdate("Drop table if exists Entrenador; ");
					query.executeUpdate("Drop table if exists Habilidad; ");
					query.executeUpdate("Drop table if exists Pokemon; ");
					
					query.executeUpdate("create table Pokemon( id int Primary key auto_increment, nombre Varchar(40), puntosExp int(3), nivel int(3), raza Varchar(40), tipoPokemon Varchar(40), vida int);");
					query.executeUpdate("create table habilidad (id int Primary key auto_increment, nombre Varchar(40), ptsAtaque int, tipoHabilidad Varchar(40), usos int(2));");
					query.executeUpdate("create table habilidadPokemon( idHabilidad int, idPokemon int);");
					query.executeUpdate("create table objetoCuracion( id int Primary key, nombre varchar(40), tipoObjeto varchar(40),vidaCurada int (3));");
					query.executeUpdate("create table entrenador( id int Primary Key auto_increment, nombre Varchar(30),dineroTotal int(4),aspecto varchar(40));");
					query.executeUpdate("create table LiderGymnasio(id_entrenador int primary key, nombre Varchar(30), monedero int(4), aspecto varchar(40),medalla Varchar(20));");
					query.executeUpdate("Create table EntrenadorPokemon( id_Entrenador int, id_Pokemon int);");
					query.executeUpdate("create table objeto( id int Primary key auto_increment, nombre varchar(20),tipoObjeto varchar(40) );");
					query.executeUpdate("CREATE TABLE EntrenadorObjeto(idEntrenador int,idObjeto int);");
					query.executeUpdate("create table Jugador( id_entrenador int primary key, nombre Varchar(30), dineroTotal int(4), aspecto varchar(40), genero Varchar(50));");
					
					query.executeUpdate("alter table habilidadPokemon add constraint fk_habilidad_id foreign key (idHabilidad) references habilidad(id) on delete cascade;");
					query.executeUpdate("alter table habilidadPokemon add constraint fk_pokemon_id  foreign key (idPokemon) references Pokemon(id) on delete cascade;");
					query.executeUpdate("alter table LiderGymnasio add constraint fk_entrenador_lider foreign key (id_entrenador) references entrenador(id) on delete cascade;");
					query.executeUpdate("alter table Jugador add constraint fk_entrenador_jug foreign key (id_entrenador) references entrenador(id) on delete cascade;");
					query.executeUpdate("alter table EntrenadorObjeto add constraint fk_ent_obj foreign key (idEntrenador)references entrenador(id) on delete cascade;");
					query.executeUpdate("alter table EntrenadorObjeto add constraint fk_obj_entrenador foreign key (idObjeto) references objeto(id) on delete cascade;");
					query.executeUpdate("alter table Entrenadorpokemon add constraint fk_pok_entrenador foreign key (id_Pokemon) references Pokemon(id) on delete cascade;");
					query.executeUpdate("alter table Entrenadorpokemon add constraint fk_entrenador_pok foreign key (id_Entrenador) references Entrenador(id) on delete cascade;");
					query.executeUpdate("alter table objetoCuracion add constraint fk_obj_objC foreign key (id) references Objeto(id) on delete cascade;");
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				
				
				
				ConexionBD.desconectar();
				System.out.println("Base de datos creada");
				
				
				//inserts
				String nombre=dimeNombre.getText();
				String genero=dimeGenero.getSelectedItem().toString();
				int monedero =0;
				String aspecto;
				int id=1;
				
				if(genero=="HOMBRE") {
					aspecto="./imagenes/entrenador.png";
				}
				if(genero=="MUJER"){
					aspecto="./imagenes/entrenadora.png";
				}
				else { aspecto="(./imagenes/entrenadore.png";}
				
				try {

					if(casillaMarcada(noAbogado)) {
			            throw new casillaDesmarcada("");
			        }
					new Jugador(id,nombre, monedero, aspecto, genero);
					ventana.cambiarPantalla("PantallaIniciales");
				} catch (SQLException | nombreVacio | casillaDesmarcada  e1) {
					
					JOptionPane.showMessageDialog(ventana,"No puede haber campos vacios","Error",JOptionPane.PLAIN_MESSAGE );

				}
				
			}
		});
		siguiente.setVerticalAlignment(SwingConstants.TOP);
		siguiente.setForeground(new Color(128, 0, 0));
		siguiente.setFont(new Font("Tahoma", Font.ITALIC, 15));
		siguiente.setBackground(new Color(127, 255, 212));
		GridBagConstraints gbc_siguiente = new GridBagConstraints();
		gbc_siguiente.insets = new Insets(0, 0, 5, 5);
		gbc_siguiente.gridx = 2;
		gbc_siguiente.gridy = 12;
		add(siguiente, gbc_siguiente);
		
		
	}
	

	/**
	 * La funci?n que define la causa del throw de la excepci?n, est? ocurrira cuando no se selecione la casilla abogado
	 * @param String nombre
	 * @return
	 */
	protected static boolean casillaMarcada(JCheckBox noAbogado) {
		return !noAbogado.isSelected();
	}
	
	
}
