package Contoller;
	
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import View.Interface;

public class Controller_interface implements KeyListener {
	private Interface in;
	private JTextField txt1[];
	private JTextField txt2[];
	private int size=0;
	int count [];
	public Controller_interface(Interface in) {
		this.in= in;
		prueba();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		String m = "Mensaje recibido correctamente";
		String m1 = "Mensaje no recibido correctamente";
		String message="";
		if(e.getSource() == in.txt[0]) {
			message = in.txt[0].getText();
			
			String binary [] =letters_to_binary(message);
			int    decimal []=binary_to_decimal(binary);
			count =count(decimal);
			String addp[] = addParity(count, binary);
			
			in.txt[1].setText(array_to_cadena(binary));
			in.txt[2].setText(Arrays.toString(count));
			addCeldas(addp);
			
			String extract_txt [] = extract(txt1);
			String destino [] = delete_Parity(extract_txt);
			int    decimal2 []=binary_to_decimal(destino);
			int    count2 []=count(decimal2);
			
			in.destino.setText(array_to_cadena(destino));
			
			if(validation(count,count2))
				in.mensajeFinal.setText(m+ ": " + message);
		}
			for (int c = 0; c < txt1.length; c++) {
				if(e.getSource()==txt1[c]) {
					String extract_tx [] = extract(txt1);
					String destin [] = delete_Parity(extract_tx);
					int    decimal22 []=binary_to_decimal(destin);
					int    count22 []=count(decimal22);
					if(validation(count,count22))
						in.mensajeFinal.setText(m+ " : " + message);
					else in.mensajeFinal.setText(m1);
				}
			}
	}
	
	public boolean validation(int [] count, int [] count2) {
		boolean flag = Arrays.equals(count, count2);
		return flag;
	}
	
	public String array_to_cadena(String [] a) {
		String text = "";
		for (int c = 0; c < a.length; c++)
			text +="   "+a[c];
		return text;
	}
	
	public String [] extract(JTextField [] textf) {
		String text_cad []= new String [textf.length];
		for (int c = 0; c < text_cad.length; c++)
			text_cad [c] = textf[c].getText();
		return text_cad;
	}
	
	
	public void prueba() {
		String a [] =letters_to_binary("hello");
		int [] b=binary_to_decimal(a);
		int [] c=count(b);
		String with_parity []= addParity(c,a);
		delete_Parity(with_parity);
	}
	
	public String [] letters_to_binary(String word) {
		size = word.length();
		char[] lettres= word.toCharArray();
		String [] binary = new String [size];
		for (byte c = 0; c < size; c++) {
			byte number_ascii = (byte) lettres[c];
			binary[c] = Integer.toBinaryString(number_ascii);	
		}
	return binary;
	}
	
	public int[] count(int [] binary) {
		int parity[]= new int[binary.length];
		for (int c = 0; c < parity.length; c++) { 
			parity[c] =Integer.bitCount(binary[c]);
		}
	return parity;
	}
	
	
	public int [] binary_to_decimal(String [] binary) {
		Long aux_numberDecimal[] = new Long[binary.length];
		int numberDecimal [] = new int[binary.length];
		for (int c = 0; c < binary.length; c++) {
			aux_numberDecimal[c]= Long.parseLong(binary[c],2);
			numberDecimal[c]= aux_numberDecimal[c].intValue();
		}
	return numberDecimal;
	}
	
	
	public String [] addParity(int [] count, String [] binary) {
		String [] binary_with_parity = new String[binary.length];
		for (int c = 0; c < count.length; c++) {
			if(count[c]%2==0)	binary_with_parity[c] = binary[c] + "0";
			else 				binary_with_parity[c] = binary[c] + "1";
		}		
	return binary_with_parity;
	}	
	
	
	public String [] delete_Parity(String [] binary) {
		String binary_without_parity [] = new String[binary.length]; 
		for (int c = 0; c < binary.length; c++)
			binary_without_parity[c] = binary[c].substring(0, binary[c].length()-1);
	return binary_without_parity;
	}
	

	public void addCeldas(String [] data) {
		int length = data.length;
		txt1 = new JTextField[length];
		in.panel_paridad.removeAll();
		in.panel_paridad.repaint();
		for (int c = 0; c < length; c++) {
			txt1[c] = new JTextField(data[c]);
			txt1[c].setFont(new Font("Cambria", Font.PLAIN, 14));
			txt1[c].setBounds(c*75+3, 1, 70, 28);
			txt1[c].setBorder(new LineBorder(Color.WHITE));
			txt1[c].addKeyListener(this);
			in.panel_paridad.add(txt1[c]);
		}
		in.panel_paridad.repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}

	




