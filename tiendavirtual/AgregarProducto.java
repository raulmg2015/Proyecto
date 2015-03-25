/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendavirtual;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author AYUSO
 */
public class AgregarProducto extends javax.swing.JFrame {

    /**
     * Creates new form AgregarProducto
     */
    DatosUsuario oDatosUsuario;
    public AgregarProducto() {
        initComponents();
        this.getContentPane().setBackground(Color.ORANGE);
        setTitle("Agregar Producto");
         setLocationRelativeTo(null);
        URL url = getClass().getResource("icono.png");
        ImageIcon icono = new ImageIcon( url );
        setIconImage(icono.getImage()); 
        oDatosUsuario = DatosUsuario.getDatosUsuario();
        jLabel1.setText(oDatosUsuario.getNombre());
        
        this.setSize(480, 460);
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/virtualtienda?zeroDateTimeBehavior=convertToNull","root", "");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from categoria");
            //int fin;
            rs.last();
            //fin = rs.getRow();
            rs.first();
            jComboBox1.addItem(rs.getString(2));

            while (rs.next()){
                jComboBox1.addItem(rs.getString(2));
            }
            /*for (int i = 1;i<fin+1;i++){
                
                jComboBox1.addItem(rs.getString(2));
                rs.next();
            }*/
                
                //System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " "); 
            
                
            conexion.close();
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombreproducto = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        Descripcion = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Guradardatos = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        bseleccionar = new javax.swing.JButton();
        txtimagen = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar Articulo");

        Nombreproducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nombreproducto.setText("Nombre del Producto:");

        Categoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Categoria.setText("Categoria:");

        Descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Descripcion.setText("Descripcion:");

        Guradardatos.setBackground(new java.awt.Color(0, 153, 153));
        Guradardatos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Guradardatos.setText("Guardar Datos");
        Guradardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuradardatosActionPerformed(evt);
            }
        });

        Regresar.setBackground(new java.awt.Color(0, 153, 153));
        Regresar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Imagen:");

        bseleccionar.setText("Seleccionar imagen");
        bseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bseleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Categoria)
                            .addComponent(Descripcion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Guradardatos)
                        .addGap(18, 18, 18)
                        .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bseleccionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombreproducto)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Categoria))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(Descripcion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(bseleccionar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guradardatos)
                            .addComponent(Regresar))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
          this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_RegresarActionPerformed

    private void GuradardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuradardatosActionPerformed
        // TODO add your handling code here:
        oDatosUsuario = DatosUsuario.getDatosUsuario();
        Icon icono = new ImageIcon(getClass().getResource("baratero3.gif"));
        int idEntindad = jComboBox1.getSelectedIndex()+1;
        int opc;
         opc=JOptionPane.showOptionDialog(null, "¿Esta seguro que desea agregar el Producto?" ,null , WIDTH, WIDTH, icono,new Object[]{"SI" , "N0"} , null);
         if (opc==0) {
            try
           {
               FileInputStream  archivofoto;
               archivofoto = new FileInputStream(txtimagen.getText());
               Class.forName("com.mysql.jdbc.Driver");
               Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/virtualtienda?zeroDateTimeBehavior=convertToNull","root", "");
               Statement s = conexion.createStatement();
                             
                   s.execute("INSERT INTO producto(idProducto,idUsuario,idCategoria,Nombre_producto,Descripcion,Nombre_imagen,Imagen)"
                           + "VALUES(NULL,"+oDatosUsuario.getIdUsuario()+","+idEntindad+",'"+jTextField1.getText()+"','"+jTextArea1.getText()+"','"+txtimagen.getText()+"','"+archivofoto
                           +"')");
                   JOptionPane.showMessageDialog(this, "Datos ingresados correctamente",null,WIDTH,icono);
                   dispose();
                            
                 conexion.close();
               
           } catch (ClassNotFoundException | SQLException e)
           {
           } catch (FileNotFoundException ex) {
                Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_GuradardatosActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void bseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bseleccionarActionPerformed
        // TODO add your handling code here:
        JFileChooser archivo = new JFileChooser();
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("/home/armand/Imágenes");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
         if(ventana == JFileChooser.APPROVE_OPTION){
              File file = archivo.getSelectedFile();
              txtimagen.setText(String.valueOf(file));
              Image foto= getToolkit().getImage(txtimagen.getText());
              foto= foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
              imagen.setIcon(new ImageIcon(foto));
         }
    }//GEN-LAST:event_bseleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Categoria;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JButton Guradardatos;
    private javax.swing.JLabel Nombreproducto;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton bseleccionar;
    private javax.swing.JLabel imagen;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel txtimagen;
    // End of variables declaration//GEN-END:variables
}
