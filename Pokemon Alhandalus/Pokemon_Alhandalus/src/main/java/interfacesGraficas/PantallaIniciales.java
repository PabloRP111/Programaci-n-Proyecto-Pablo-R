package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JToggleButton.ToggleButtonModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaIniciales extends JPanel {

	private Ventana ventana;
	
	public PantallaIniciales(Ventana v) {
		
		
		setBackground(new Color(0, 0, 128));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel oakIniciales = new JLabel("");
		oakIniciales.setIcon(new ImageIcon(PantallaIniciales.class.getResource("/imgs/iniciales.gif")));
		GridBagConstraints gbc_oakIniciales = new GridBagConstraints();
		gbc_oakIniciales.insets = new Insets(0, 0, 5, 5);
		gbc_oakIniciales.gridx = 2;
		gbc_oakIniciales.gridy = 1;
		add(oakIniciales, gbc_oakIniciales);
		
		JTextPane txtpnBuenoCaraAlmendra = new JTextPane();
		txtpnBuenoCaraAlmendra.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtpnBuenoCaraAlmendra.setBackground(new Color(0, 0, 128));
		txtpnBuenoCaraAlmendra.setForeground(new Color(255, 255, 255));
		txtpnBuenoCaraAlmendra.setText("Bueno cara almendra, ahora te toca elegir un pok\u00E9mon.\r\nTe he conseguido una selecci\u00F3n de pok\u00E9mons incre\u00EDbles en base a unas encuentas de popularidad.\r\nElige sabiamente.");
		GridBagConstraints gbc_txtpnBuenoCaraAlmendra = new GridBagConstraints();
		gbc_txtpnBuenoCaraAlmendra.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnBuenoCaraAlmendra.fill = GridBagConstraints.BOTH;
		gbc_txtpnBuenoCaraAlmendra.gridx = 2;
		gbc_txtpnBuenoCaraAlmendra.gridy = 2;
		add(txtpnBuenoCaraAlmendra, gbc_txtpnBuenoCaraAlmendra);
		
		JButton Siguiente = new BotonPrincipal("Elijo a este pokemon");
		
		GridBagConstraints gbc_Siguiente = new GridBagConstraints();
		gbc_Siguiente.insets = new Insets(0, 0, 5, 5);
		gbc_Siguiente.gridx = 3;
		gbc_Siguiente.gridy = 2;
		add(Siguiente, gbc_Siguiente);
		
		JLabel metapod = new JLabel("");
		metapod.setIcon(new ImageIcon(PantallaIniciales.class.getResource("/imgs/metapod.gif")));
		GridBagConstraints gbc_metapod = new GridBagConstraints();
		gbc_metapod.gridheight = 2;
		gbc_metapod.insets = new Insets(0, 0, 5, 5);
		gbc_metapod.gridx = 1;
		gbc_metapod.gridy = 3;
		add(metapod, gbc_metapod);
		
		
		JLabel BULBASUR = new JLabel("");
		BULBASUR.setIcon(new ImageIcon(PantallaIniciales.class.getResource("/imgs/bulbasur.gif")));
		GridBagConstraints gbc_BULBASUR = new GridBagConstraints();
		gbc_BULBASUR.gridheight = 2;
		gbc_BULBASUR.insets = new Insets(0, 0, 5, 5);
		gbc_BULBASUR.gridx = 3;
		gbc_BULBASUR.gridy = 3;
		add(BULBASUR, gbc_BULBASUR);
		
		JLabel magikcarp = new JLabel("");
		magikcarp.setIcon(new ImageIcon(PantallaIniciales.class.getResource("/imgs/magicarp.gif")));
		GridBagConstraints gbc_magikcarp = new GridBagConstraints();
		gbc_magikcarp.gridheight = 2;
		gbc_magikcarp.insets = new Insets(0, 0, 5, 5);
		gbc_magikcarp.gridx = 2;
		gbc_magikcarp.gridy = 3;
		add(magikcarp, gbc_magikcarp);
		
		
		
		final JRadioButton eligeMetapod = new JRadioButton("Metapod");
		eligeMetapod.setHorizontalAlignment(SwingConstants.CENTER);
		eligeMetapod.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_eligeMetapod = new GridBagConstraints();
		gbc_eligeMetapod.insets = new Insets(0, 0, 5, 5);
		gbc_eligeMetapod.gridx = 1;
		gbc_eligeMetapod.gridy = 5;
		add(eligeMetapod, gbc_eligeMetapod);
		
		final JRadioButton eligeMagikcarp = new JRadioButton("Magikcarp");
		eligeMagikcarp.setHorizontalAlignment(SwingConstants.CENTER);
		eligeMagikcarp.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_eligeMagikcarp = new GridBagConstraints();
		gbc_eligeMagikcarp.insets = new Insets(0, 0, 5, 5);
		gbc_eligeMagikcarp.gridx = 2;
		gbc_eligeMagikcarp.gridy = 5;
		add(eligeMagikcarp, gbc_eligeMagikcarp);
		
		final JRadioButton eligeBulbasur = new JRadioButton("Bulbasur");
		GridBagConstraints gbc_eligeBulbasur = new GridBagConstraints();
		gbc_eligeBulbasur.insets = new Insets(0, 0, 5, 5);
		gbc_eligeBulbasur.gridx = 3;
		gbc_eligeBulbasur.gridy = 5;
		add(eligeBulbasur, gbc_eligeBulbasur);
		
		final ButtonGroup iniciales= new ButtonGroup();
		iniciales.add(eligeMagikcarp);
		iniciales.add(eligeBulbasur);
		iniciales.add(eligeMetapod);
		
		
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(iniciales.getSelection()!=null) {
					String razaPokemon="";
					if(eligeMagikcarp.isSelected()) {
						razaPokemon="Magikcarp";
					}
					if(eligeMetapod.isSelected()) {
						razaPokemon="Metapod";	
					}
					if(eligeBulbasur.isSelected()) {
					razaPokemon="Bulbasur";	
					}
					
					
				ventana.cambiarPantalla("PantallaPokemon",razaPokemon);
				
			}
				
				}
		});

		ventana=v;
		
	}
	
}
