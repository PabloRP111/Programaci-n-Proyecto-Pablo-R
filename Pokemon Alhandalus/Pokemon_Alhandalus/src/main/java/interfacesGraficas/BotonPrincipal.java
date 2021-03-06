package interfacesGraficas;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class BotonPrincipal extends JButton{

	public BotonPrincipal(String msg) {
		super(msg);
		estilosPorDefecto();
		
		 this.addMouseListener(new MouseAdapter() {

	            public void mouseEntered(MouseEvent e) {
	                estilosAlternativos();
	            }

	            public void mouseExited(MouseEvent e) {
	                estilosPorDefecto();

	            }
	        });
		
	}
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(255, 255, 0));
		this.setBackground(new Color(25, 25, 112));
		this.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 23));
		this.setBounds(281, 543, 205, 52);
		this.setFocusable(false);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
	}
	
	private void estilosAlternativos() {
		this.setForeground(new Color(255, 255, 0));
		this.setBackground(new Color(112, 25, 25));
		this.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 23));
		this.setBounds(281, 543, 205, 52);
		this.setFocusable(false);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		
	}
	
}
