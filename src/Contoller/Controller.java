package Contoller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JPanel;

import View.Interface;

public class Controller implements KeyListener {
	private Interface in;
	private String message="";
	private int [] countOne,countTwo;
	public Controller(Interface in) {
		this.in= in;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource() == in.txt[0]) {
			message = in.txt[0].getText();		                //OBTENEMOS EL MENSAJE INGRESADO
			
			String binary [] =letters_to_binary(message); 		//CONVERTIMOS EL MENSAJE A BINARIO
			countOne =count(binary);  					//CONVERTIMOS EL BINARIO A DECIMAL
			String withParity [] = addParity(countOne, binary);
			int    countWithParity [] =count(withParity);  		//CONVERTIMOS EL BINARIO A DECIMAL
			
			in.txt[1].setText(array_to_cadena(binary));
			in.txt[2].setText(array_to_cadena(withParity));
			in.txt[3].setText(array_to_cadena(binary));
			
			in.eti[0].setText(Arrays.toString(countOne));
			in.eti[1].setText(Arrays.toString(countWithParity));
			in.eti[2].setText(Arrays.toString(countOne));			
			
			if(!in.txt[0].getText().isEmpty())
			in.txt[4].setText("Mensaje recibido con éxito : " + message); 
			else 
			clean();			
		}
		
		
		if(e.getSource()==in.txt[2]){
			String cadena = in.txt[2].getText();
			String [] delete_Parity = delete_Parity(cadena);
			countTwo =count(delete_Parity);
			in.txt[3].setText(array_to_cadena(delete_Parity));
			in.eti[2].setText(Arrays.toString(countTwo));	
			
			String destino = in.txt[3].getText();
			int b [] = binary_to_decimal(format(destino));
			System.out.println(Arrays.toString(b));
			
			if(validationMessage(countOne, countTwo)) {
				in.txt[4].setText("Mensaje recibido con éxito : " + convert_to_String(b));
			}
			else {
				in.txt[4].setText("Error detectado" );
			}
		}
	}
	
	
	public boolean validationMessage(int [] parOne,int [] parTwo) {
		int parA[] = isPar(parOne);
		int parB[] = isPar(parTwo);
		boolean isValido = Arrays.equals(parA, parB);
		return isValido;
	}
	
	
	public String convert_to_String(int [] numbers) {
		String word= "";
		for (int c = 0; c < numbers.length; c++) {
			word = word+Character.toString((char) numbers[c]);
		} 
		return word;
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

	public String [] delete_Parity(String concat) {
		String [] binary= format(concat);
		String binary_without_parity [] = new String[binary.length]; 
		for (int c = 0; c < binary.length; c++)
			binary_without_parity[c] = binary[c].substring(0, binary[c].length()-1);
		return binary_without_parity;
	}
	
	public String [] format(String concat) {
		String n1= concat.trim();
		String n = n1.replaceAll("\\s", ",");
		String [] binary= n.split(",,,");
		return binary;
	}
	
	
	public int [] count(String [] binary) {
		Long aux_numberDecimal[] = new Long[binary.length];
		int numberDecimal [] = new int[binary.length];
		int count[]= new int[binary.length];
		for (int c = 0; c < binary.length; c++) {
			aux_numberDecimal[c]= Long.parseLong(binary[c],2);
			numberDecimal[c]= aux_numberDecimal[c].intValue();
			count[c] =Integer.bitCount(numberDecimal[c]);
		}
		return count;
	}
	
	public String [] letters_to_binary(String word) {
		int size = word.length();
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
		for (int c = 0; c < parity.length; c++) 
			parity[c] =Integer.bitCount(binary[c]);
	return parity;
	}
	
	
	public String array_to_cadena(String [] a) {
		String text = "";
		for (int c = 0; c < a.length; c++)
			text +="   "+a[c];
		return text;
	}
	
	public String [] addParity(int [] count, String [] binary) {
		String [] binary_with_parity = new String[binary.length];
		int [] par = isPar(count);
		for (int c = 0; c < par.length; c++) {
			if(par[c]==0)	
				binary_with_parity[c] = binary[c] + "0";
			else
				binary_with_parity[c] = binary[c] + "1";
		}
		return binary_with_parity;
	}
	
	public int [] isPar(int [] count) {
		int v [] = new int[count.length];
		
		for (int c = 0; c < count.length; c++) {
			if(count[c]%2==0)	v[c]= 0;
			else				v[c]= 1;			
		}
		return v;
	}
	
	
	public void clean() {
		in.txt[1].setText("");
		in.txt[2].setText("");
		in.txt[3].setText("");
		in.txt[4].setText("");
		in.eti[0].setText("");
		in.eti[1].setText("");
		in.eti[2].setText("");
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
	}
}
