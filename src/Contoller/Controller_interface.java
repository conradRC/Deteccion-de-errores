package Contoller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JTextField;
import View.Interface;

public class Controller_interface implements KeyListener {
	private Interface in;
	private int size=0;
	private int count [];
	private String message="";
	private int    decimal22 [];
	private int    parOne [];
	private int    parTwo [];
	private String separate[];
	

	public Controller_interface(Interface in) {
		this.in= in;
	}
	
	public boolean validationMessage(int [] parOne,int [] parTwo) {
		boolean isValido = false;
		System.out.println(Arrays.toString(parOne) +" : "+ Arrays.toString(parTwo));
		for (int i = 0; i < parOne.length; i++) {
			if(parOne[i]==parTwo[i]){
				isValido=true;
			}
			else{
				isValido=false;
				break;
			}
		}
		return isValido;
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource() == in.txt[0]) {
			message = in.txt[0].getText();				  //OBTENEMOS EL MENSAJE INGRESADO
			
			String binary [] =letters_to_binary(message); //CONVERTIMOS EL MENSAJE A BINARIO	
			int    decimal []=binary_to_decimal(binary);  //CONVERTIMOS EL BINARIO A DECIMAL   
			count =count(decimal);						  //CON EL DECIMAL CONTAMOS LOS UNOS (1)	
			
			in.txt[1].setText(array_to_cadena(binary));	  //AGREGAMOS EL MENSAJE EN BINARIO A LA CASILLA DE "MENSAJE EN BINARIO"
			in.eti[0].setText(deleteCorchet(Arrays.toString(count))); //AGREGAMOS EL CONTEO DE LA LINEA 48 EN EL PRIMER CAMPO COLUMNA 3 FILA 1
			
			int [] c= isPar(count);						  //VERIFIAMOS CON BASE AL CONTEO, CUALES SON PARES
			parOne= c;
			
			String addp[] = addParity(c, binary);		  //AGREGAMOS EL BIT DE PARIDAD A CADA SEGEMENTO DE BITS
			in.txt[2].setText(deleteCorchet(Arrays.toString(addp)));//AGREGAMOS LOS BITS CON EL BIT DE PARIDAD PERO LE QUITAMOS LOS CORCHETES
			
			int [] asd= countStringInBinary(addp);			//CONTAMOS CANTIDAD DE UNOS (SOLO QUE ES OTRO MÉTODO POR QUE ES UNA CADENA)	
			in.eti[1].setText(deleteCorchet(Arrays.toString(asd)));//BORRAMOS CORCHETES DE LO ANTEORIOR Y AGREGAMOS AL CAMPO COLUMNA 3 FILA 2
			
			
			in.txt[3].setText(array_to_cadena(binary));		//COMO NO VA CAMBIAR EN ESTA PARTE, AGREGAMOS EL MENSAJE DE DESTINO DIRECTAMENTE EN EL CAMPO "DESTINO"
			
			in.txt[4].setText("Mensaje recibido con éxito : " + message); //AGREGAMOS EL MENSAJE EN EL CAMPO "MENSAJE"
		}
		//EN ESTA PARTE VERFICAMOS SI SE MODIFICA EL CAMPO DE PARIDAD
		/*if(e.getSource()==in.txt[2]){		//ESCUCHA SI SE MODIFICA EL CAMPO DE "PARIDAD" (ENTRA CADA VEZ QUE SE MODIFICA EL CAMPO)
			String cadena = in.txt[2].getText();	//OBTIENE LA CADENA DEL CAMPO (YA QUE SE MODIFICÓ ALGO)
			String destino =deleteCorchet(cadena);//SE BORRAN LOS CORCHETES
			System.out.println();
			//in.txt[3].setText(cadena);	//SE ACTUALIZAN LOS DATOS DE DESTINO CON RESPECTO AL CAMPO DE PARIDAD
			
			String [] delete_Parity = delete_Parity(cadena);
			in.txt[3].setText(deleteCorchet(Arrays.toString(delete_Parity)));
			
			
			String [] convertToArray = cadena.split(", ");
			int    decimal []=binary_to_decimal(convertToArray);  //CONVERTIMOS EL BINARIO A DECIMAL
			int []countNewMenssage =count(decimal);						  //CON EL DECIMAL CONTAMOS LOS UNOS (1)
			in.eti[2].setText(deleteCorchet(Arrays.toString(countNewMenssage)));
			
			
			String a = in.txt[3].getText();
			String b = deleteCorchet(cadena);
			String []c = b.split(",");
			int counstr []= countStringInBinary(c);
			parTwo = isPar(counstr);
			
			
			
			//VERIFICAR SI EL MENSAJE ES CORRECTO
			if(validationMessage(parOne, parTwo)) {
				in.txt[4].setText("Mensaje recibido con éxito : " + message);
			}
			else {
				in.txt[4].setText("Error detectado : " );
			}
		}*/
	}
	
	
	public void updateData() {
		
	}
	
	public String deleteCorchet(String str) {
		return str.substring(1,str.length()-1);
	}
	
	
	public void prueba() {
		/*String bb [] =letters_to_binary("hello");
		System.out.println(Arrays.toString(bb));
		
		int [] b=binary_to_decimal(bb);
		System.out.println(Arrays.toString(b));
		
		int [] ba=count(b);
		int [] c= isPar(ba);
		System.out.println("par  " +Arrays.toString(c));
		
		String with_parity []= addParity(c,bb);
		System.out.println(Arrays.toString(with_parity));
		
		int [] asd= countStringInBinary(with_parity);
		System.out.println("erg"+Arrays.toString(asd));
		
		//delete_Parity(with_parity);
		//System.out.println(Arrays.toString(delete_Parity(with_parity)));
	
		System.out.println("converso: "+ convert_to_String(b));*/
		     
	}
	
	public int [] countStringInBinary(String a[]) {
		int [] one = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			int size = a[i].length();
			
			for (int j = 0; j < size; j++) {
				if(a[i].charAt(j)=='1') {
					one[i]=one[i]+1;
				}	
			}
		}
		return one;
	}
	
	public String convert_to_String(int [] numbers) {
		String word= "";
		for (int c = 0; c < numbers.length; c++) {
			word = word+Character.toString((char) numbers[c]);
		} 
		return word;
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
		for (int c = 0; c < parity.length; c++) 
			parity[c] =Integer.bitCount(binary[c]);
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
			if(count[c]==0){	
				binary_with_parity[c] = binary[c] + "0";
			}
			else{
				binary_with_parity[c] = binary[c] + "1";
			}
		}
	return binary_with_parity;
	}
	
	
	public int [] isPar(int [] count) {
		int v [] = new int[count.length];
		for (int c = 0; c < count.length; c++) {
			if(count[c]%2==0){	
				v[c]= 0;
			}
			else{
				v[c]= 1;
			}	
		}
		return v;
	}
	
	public String [] delete_Parity(String concat) {
		String [] binary= concat.split(",");
		String binary_without_parity [] = new String[binary.length]; 
		for (int c = 0; c < binary.length; c++)
			binary_without_parity[c] = binary[c].substring(0, binary[c].length()-1);
	return binary_without_parity;
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}

	




