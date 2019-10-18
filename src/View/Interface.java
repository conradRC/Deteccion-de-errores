package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import Contoller.Controller_interface;

public class Interface extends JPanel {
	public JTextField txt[];
	public JPanel panel_paridad,panel_destino;
	public JLabel mensajeFinal; 
	public int x=210;
	public int y=60;
	public int largo=900;
	public int ancho=30;
	public Interface() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		String [] etiquetas = {"Mensaje :","Mensaje en binario :","Cantidad de unos :", "Paridad :", "Destino :","Mensaje recibido: "};
		
		JLabel lb [] = new JLabel[etiquetas.length]; 
		txt = new JTextField[etiquetas.length-1];
		
		for (int c = 0; c < etiquetas.length; c++) {
			lb[c] = new JLabel(etiquetas[c]);
			lb[c].setHorizontalAlignment(SwingConstants.RIGHT);
			lb[c].setBounds(50, (c+1)*y, 150, 15);
			lb[c].setFont(new Font("Sitka Text", Font.PLAIN, 14));
			lb[c].setBackground(Color.WHITE);
			add(lb[c]);
		}
		
		for (int c = 0; c < txt.length-2; c++) {
			txt[c] = new JTextField();
			txt[c].setBounds(x, (c+1)*y-5, largo, ancho);
			txt[c].setFont(new Font("Cambria", Font.PLAIN, 14));
			txt[c].setColumns(10);
			txt[c].setBackground(Color.WHITE);
			txt[c].setBorder(new LineBorder(Color.gray));
			add(txt[c]);
		}
		
		txt[1].setEditable(false);
		txt[2].setEditable(false);
		
		panel_paridad = new JPanel();
		panel_paridad.setBorder(new LineBorder(Color.gray));
		panel_paridad.setBackground(Color.WHITE);
		panel_paridad.setBounds(x, 4*y-5, largo, ancho);
		panel_paridad.setLayout(null);
		add(panel_paridad);
		
		panel_destino = new JPanel();
		panel_destino.setBorder(new LineBorder(Color.gray));
		panel_destino.setBackground(Color.WHITE);
		panel_destino.setBounds(x, 5*y-5, largo, ancho);
		panel_destino.setLayout(null);
		add(panel_destino);
		
		mensajeFinal = new JLabel();
		mensajeFinal.setBorder(new LineBorder(Color.gray));
		mensajeFinal.setBackground(Color.WHITE);
		mensajeFinal.setBounds(x, 6*y-5, largo, ancho);
		add(mensajeFinal);
	}
	
	public void conect_controller(Controller_interface control) {
		for (int c = 0; c < txt.length-2; c++)
			txt[c].addKeyListener(control);
	}
	
	public static void main(String [] args) {
		JFrame ventana = new JFrame();
		Interface interf= new Interface();
		Controller_interface control= new Controller_interface(interf);
		interf.conect_controller(control);
		ventana.setSize(1200,500);
		ventana.setDefaultCloseOperation(3);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().add(interf);
		ventana.setVisible(true);
	}
}
