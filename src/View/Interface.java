package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Contoller.Controller;
import javax.swing.JScrollPane;

public class Interface extends JPanel {
	public JTextField txt[];
	public JTextField eti[];
	public int x=180;
	public int y=80;
	public int largo=700;
	public int ancho=45;
	public Interface() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		String [] etiquetas = {"Mensaje :","Mensaje en binario :", "Paridad :", "Destino :","Mensaje recibido: "};
		JScrollPane js[]= new JScrollPane[etiquetas.length];
		JScrollPane js1[]= new JScrollPane[etiquetas.length-2];
		JLabel lb [] = new JLabel[etiquetas.length]; 
		eti = new JTextField[etiquetas.length-2];
		txt = new JTextField[etiquetas.length];
		
		for (int c = 0; c < etiquetas.length; c++) {
			lb[c] = new JLabel(etiquetas[c]);
			lb[c].setHorizontalAlignment(SwingConstants.RIGHT);
			lb[c].setBounds(20, (c+1)*y, 150, 15);
			lb[c].setFont(new Font("Sitka Text", Font.PLAIN, 15));
			lb[c].setBackground(Color.WHITE);
			add(lb[c]);
		}
		
		for (int c = 0; c < lb.length; c++)
			js [c]= new JScrollPane();
		
		for (int c = 0; c < lb.length-2; c++)
			js1 [c]= new JScrollPane();
		
		for (int c = 0; c < etiquetas.length; c++) {
			txt[c] = new JTextField();
			txt[c].setBorder(new LineBorder(Color.gray));
			txt[c].setBackground(Color.WHITE);
			txt[c].setBounds(x, (c+1)*y-15, largo, ancho);
			js[c].setBounds(x, (c+1)*y-15, largo, ancho);
			txt[c].setFont(new Font("Cambria", Font.BOLD, 14));
			add(txt[c]);
			add(js[c]);
			js[c].setViewportView(txt[c]);
			js[c].setBorder(new LineBorder(new Color(130, 135, 144), 0));
		}
		
		for (int c = 0; c < etiquetas.length-2; c++) {
			eti[c] = new JTextField();
			eti[c].setBorder(new LineBorder(Color.gray));
			eti[c].setBackground(Color.WHITE);
			eti[c].setBounds(x+largo+10, +(c+2)*y-15, 150, ancho);
			js1[c].setBounds(x+largo+10, +(c+2)*y-15, 150, ancho);
			eti[c].setFont(new Font("Cambria", Font.BOLD, 14));
			add(eti[c]);
			add(js1[c]);
			js1[c].setViewportView(eti[c]);
			js1[c].setBorder(new LineBorder(new Color(130, 135, 144), 0));
		}
	}
	public void conect_controller(Controller control) {
			txt[0].addKeyListener(control);
			txt[2].addKeyListener(control);
	}
	
	public static void main(String [] args) {
		JFrame ventana = new JFrame();
		Interface interf= new Interface();
		Controller control= new Controller(interf);
		interf.conect_controller(control);
		ventana.setSize(1100,550);
		ventana.setDefaultCloseOperation(3);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().add(interf);
		ventana.setVisible(true);
	}
}
