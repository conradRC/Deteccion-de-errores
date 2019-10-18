package Contoller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import View.Interface;

public class Controller_interface implements KeyListener {
	private Interface in;
	private String cadenaBinari="";
	private String [] destino;
	private String [] cadenaBinaria;
	private String [] strBinary;
	private JTextField txt1[];
	private JTextField txt2[];
	private int un[];
	private int size=0;
	private int [] enviado, recibido;
	private boolean  [] flags, flags1;
	public Controller_interface(Interface in) {
		this.in= in;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		in.mensajeFinal.setText("Mensaje recibido correctamente");
		if(e.getSource() == in.txt[0]) {
			String m = in.txt[0].getText();
			size = m.length();
			String mensaje =cadenaABinario(in.txt[0].getText());
			addCeldas(size);
			destino = new String [txt1.length];
			for (int c = 0; c < cadenaBinaria.length; c++)
				 destino [c]= removeBit(txt1[c].getText());
			
			addCeldasB(size, destino);
			in.txt[1].setText(cadenaBinari);
			in.txt[2].setText(Arrays.toString(un));
			
			
			isPar(destino);
			if(verification(recibido,un)) {
				in.mensajeFinal.setText("Mensaje recibido correctamente");
			}
		}
			
		else {
			for (int c = 0; c < size; c++) {
				if(e.getSource() == txt1[c]) {
					for (int d = 0; d < cadenaBinaria.length; d++)
						destino [d]= removeBit(txt1[d].getText()); 
						addCeldasB(size, destino);
				}
			}
		}
	}

	public String removeBit(String binary) {
		String nw_binary = binary.substring(0, binary.length()-1);
		return nw_binary;
	}
	
	public void addCeldas(int length) {
		txt1 = new JTextField[length];
		in.panel_paridad.removeAll();
		in.panel_paridad.repaint();
		for (int c = 0; c < length; c++) {
			txt1[c] = new JTextField(cadenaBinaria[c]);
			txt1[c].setFont(new Font("Cambria", Font.PLAIN, 14));
			txt1[c].setBounds(c*75+3, 1, 70, 28);
			txt1[c].setBorder(new LineBorder(Color.WHITE));
			txt1[c].addKeyListener(this);
			in.panel_paridad.add(txt1[c]);
		}
		in.panel_paridad.repaint();
	}
	
	public void addCeldasB(int length,String [] destino) {
		txt2 = new JTextField[length];
		in.panel_destino.removeAll();
		in.panel_destino.repaint();
		for (int c = 0; c < length; c++) {
			txt2[c] = new JTextField(destino[c]);
			txt2[c].setFont(new Font("Cambria", Font.PLAIN, 14));
			txt2[c].setBounds(c*75+3, 1, 70, 28);
			txt2[c].setBorder(new LineBorder(Color.WHITE));
			txt2[c].setEditable(false);
			in.panel_destino.add(txt2[c]);
		}
		in.panel_destino.repaint();
	}
	
	
		
	public String cadenaABinario(String parCadena){
	    int longitud = parCadena.length();
	    cadenaBinaria=new String [longitud];
	    enviado = new int[longitud];
	    strBinary=new String [longitud];
	    String resultado="";
	    cadenaBinari ="";
	    un= new int [longitud];
	    // System.out.println("longitud="+longitud+" longitud cadeBinaria"+cadenaBinaria.length +" longitud un"+ un.length);
	    for(int i=0;i<longitud;i++){
	       cadenaBinaria[i]= String.format("%8s", Integer.toBinaryString(parCadena.charAt(i)));
	       cadenaBinari+= String.format("%10s", Integer.toBinaryString(parCadena.charAt(i)));
	       strBinary[i]= String.format("%10s", Integer.toBinaryString(parCadena.charAt(i)));
	       un[i]=Integer.bitCount(parCadena.charAt(i));
	       if(un[i]%2==0) {
	    	   cadenaBinaria[i]+="0";
	    	   enviado[i]= 0;
	       }
	       else {
	    	   cadenaBinaria[i]+="1";
	    	   enviado[i]= 1;
	       }
	       resultado+=cadenaBinaria[i];
	    } 
	 //  System.out.println(Arrays.toString(strBinary));
	    // System.out.println("cadena: "+parCadena+"\n"+"convertido a binario: "+cadenaBinari+"\n"+"cantidad de 1 recibidos: "+Arrays.toString(un));
	    //System.out.println("Bit de paridad agregado: "+Arrays.toString(cadenaBinaria));
	    return resultado;
     }	

	
	  public void isPar(String [] destino) {
		  recibido = new int[destino.length];
		  
		  for (int c = 0; c < destino.length; c++) {
			  for (int i = 0; i < destino.length; i++) {
				  if(destino[c].charAt(i)==('1')) {
						recibido[c]= recibido[c]+1;
			      }
			  }
		  }
		  System.out.println(Arrays.toString(recibido));
		  
		  
	  }
	
	 public boolean verification(int [] f, int [] g) {
		 boolean flag= Arrays.equals(f, g);
		 return flag;
	 }
		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
	
}

	




