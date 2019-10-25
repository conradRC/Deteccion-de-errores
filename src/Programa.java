/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programunid2;

import java.awt.Color;
import java.util.Arrays;

/**
 *
 * @author Jasive
 */
public class Programa extends javax.swing.JFrame {

    String auxiliarcito = "";

    public Programa() {
        initComponents();
        etiIncorrecta.setVisible(false);
        etiCorrecta.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOracion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtVRC = new javax.swing.JTextField();
        VRC = new javax.swing.JLabel();
        txtNumeros = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etiCorrecta = new javax.swing.JLabel();
        etiIncorrecta = new javax.swing.JLabel();
        jVerificar = new javax.swing.JButton();
        txtBinario = new javax.swing.JTextField();
        txtBitPar = new javax.swing.JTextField();
        txtModif = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNuevaOracion = new javax.swing.JTextField();
        v = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BINARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("BIT DE PARIDAD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        txtOracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOracionActionPerformed(evt);
            }
        });
        txtOracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOracionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOracionKeyReleased(evt);
            }
        });
        jPanel1.add(txtOracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 380, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ORACIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 153, 153));
        jTextField1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jTextField1.setText("VRC VERIFICACIÓN DE PARIDAD");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        txtVRC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVRCKeyPressed(evt);
            }
        });
        jPanel1.add(txtVRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 380, 30));

        VRC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        VRC.setText("VRC");
        jPanel1.add(VRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumerosActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 210, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TREN DE BIT");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, 20));

        etiCorrecta.setBackground(new java.awt.Color(102, 204, 0));
        etiCorrecta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiCorrecta.setText("TRANSMISIÓN DE DATOS CORRECTA");
        jPanel1.add(etiCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, 20));

        etiIncorrecta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiIncorrecta.setText("TRANSMISIÓN DE DATOS CORRECTA");
        jPanel1.add(etiIncorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jVerificar.setBackground(new java.awt.Color(0, 255, 255));
        jVerificar.setText("Verificar");
        jVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(jVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));
        jPanel1.add(txtBinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 380, 30));
        jPanel1.add(txtBitPar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 210, 30));

        txtModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModifActionPerformed(evt);
            }
        });
        txtModif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModifKeyReleased(evt);
            }
        });
        jPanel1.add(txtModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 380, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("MODIFICABLE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("NUEVA ORACIÒN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));
        jPanel1.add(txtNuevaOracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 380, 30));
        jPanel1.add(v, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 210, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOracionKeyPressed

    }//GEN-LAST:event_txtOracionKeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtVRCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVRCKeyPressed


    }//GEN-LAST:event_txtVRCKeyPressed
   
    private void txtOracionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOracionKeyReleased
//utilización de l evento keyReleased para evitar el uso de un botón       
//obtenemos el valor de la caja de texto
        String cadena = txtOracion.getText();
        String valores = "";
        String par = "";
        String aux2 = "",aux3="";
        String auxiliarcito = "";
        //recorremos la cadena que hemos ingresado
        for (int a = 0; a < cadena.length(); a++) {
            int contador = 0;
            String temporal = "";
            //conversión a binario de cada uno de los caracteres
            temporal = "" + Integer.toBinaryString(cadena.charAt(a));
            valores += temporal + "\n";
            //ciclo para poder verificar la información que vamos a obtener para el tren de bit
            for (int q = 0; q < temporal.length(); q++) {
                if (temporal.charAt(q) == '1') {
                    //datos de la caja de texto "tren de bit"
                    contador++;
                }
            }          
            //verificación de paridad 0
            if (contador % 2 == 0) {
                par += "0" + "\n";
                auxiliarcito += temporal + "0 ";
               //etiCorrecta.setVisible(true);
            } else {
                //verificacion de paridad 1
                par += "1" + "\n";
                auxiliarcito += temporal + "1 ";
                contador++;
                //etiIncorrecta.setVisible(true);
            }
             aux2 += contador + " ";
            int sum=0;
        }
        
        
        //asignación de datos a las diferentes cajas de texto
        txtVRC.setText(auxiliarcito);
        txtBinario.setText(valores + "");
        System.out.println(valores);
        txtModif.setText(auxiliarcito + "");
        txtBitPar.setText(par + "");
        txtNumeros.setText(aux2);
        v.setText(aux3);
    }//GEN-LAST:event_txtOracionKeyReleased

    private void jVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerificarActionPerformed
        //verificación de transmisión de datos correcta  
      String [] numeros=txtModif.getText().split(" ");
      boolean bandera=true;
      for(int i=0;i<numeros.length;i++){
         int a= Integer.parseInt(numeros[i]);
         if(a%2!=0){
         bandera=false;
         }
      }
      if(bandera==true){
        etiCorrecta.setVisible(true);
        etiIncorrecta.setVisible(false);
      }else{
       etiIncorrecta.setVisible(true);
      etiCorrecta.setVisible(false);
      }
    }//GEN-LAST:event_jVerificarActionPerformed

    private void txtOracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOracionActionPerformed

    private void txtNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumerosActionPerformed
   
    private void txtModifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModifKeyReleased
      String [] textModificado=txtModif.getText().split(" ");
      String palabraFinal="",nuevotrenbit="";
      for(int i=0;i<textModificado.length;i++){
          String au=textModificado[i].substring(0, textModificado[i].length()-1);
         String au2=textModificado[i];
          int aucont=0;
          for(int k=0;k<au2.length();k++){
              if(au2.charAt(k)=='1'){
                  aucont++;
              }
          }
          nuevotrenbit+=" "+aucont;
         // String palabra=textModificado[i];
        palabraFinal+=" "+(char)(Integer.parseInt(au,2));
      }
      txtNuevaOracion.setText(palabraFinal);
      txtNumeros.setText(nuevotrenbit);
      
      
    }//GEN-LAST:event_txtModifKeyReleased

    private void txtModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModifActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Programa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel VRC;
    private javax.swing.JLabel etiCorrecta;
    private javax.swing.JLabel etiIncorrecta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jVerificar;
    private javax.swing.JTextField txtBinario;
    private javax.swing.JTextField txtBitPar;
    private javax.swing.JTextField txtModif;
    private javax.swing.JTextField txtNuevaOracion;
    private javax.swing.JTextField txtNumeros;
    private javax.swing.JTextField txtOracion;
    private javax.swing.JTextField txtVRC;
    private javax.swing.JTextField v;
    // End of variables declaration//GEN-END:variables
}
