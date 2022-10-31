package Test;

import Conexion.Cls_Conexion;
import Datos.DAO_AlumnosImpl;
import Dominio.DTO_Alumnos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Alumno extends javax.swing.JFrame {

    /**
     * Creates new form Alumno
     */
    public Alumno() {
        initComponents();
        model = (DefaultTableModel) this.jTable1.getModel();
    }
    
    DefaultTableModel model;
    
    //Arreglar actualizar
    
    private void seleccionar(){
        model.setRowCount(0);
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            DAO_AlumnosImpl alumno = new DAO_AlumnosImpl(conexion);
            List<DTO_Alumnos> alumnos = alumno.select();
            
            alumnos.forEach(alumnos2 ->{
                int id = alumnos2.getId_alumno();
                int carne = alumnos2.getCarne_alumno();
                String nombre = alumnos2.getNombre_alumno();
                String correo = alumnos2.getCorreo();
                
                model.addRow(new Object[]{id, carne, nombre, correo});
            });
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Hubo un error: "+ex);
        }
    }
    
    private void agregar(int carne, String nombre, String correo){
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            DAO_AlumnosImpl alumnoDAO = new DAO_AlumnosImpl(conexion);
            
            DTO_Alumnos alumnosDTO = new DTO_Alumnos();
            alumnosDTO.setCarne_alumno(carne);
            alumnosDTO.setNombre_alumno(nombre);
            alumnosDTO.setCorreo(correo);
            
            alumnoDAO.insert(alumnosDTO);
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Se ha agregado un nuevo alumno");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entramos al rollback: "+ex);
            try {
                conexion.rollback();
            } catch (SQLException exl) {
                JOptionPane.showMessageDialog(null, exl);
            }
        }
    }
    
    private void actualizar(int carne, int id, String nombre, String correo){
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            DAO_AlumnosImpl alumnoDAO = new DAO_AlumnosImpl(conexion);
            
            DTO_Alumnos alumnosDTO = new DTO_Alumnos();
            alumnosDTO.setId_alumno(id);
            alumnosDTO.setCarne_alumno(carne);
            alumnosDTO.setNombre_alumno(nombre);
            alumnosDTO.setCorreo(correo);
            
            alumnoDAO.update(alumnosDTO);
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Se ha actualizado al alumno");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entramos al rollback: "+ex);
            try {
                conexion.rollback();
            } catch (SQLException exl) {
                JOptionPane.showMessageDialog(null, exl);
            }
        }
    }
    
    private void borrar(int id){
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            DAO_AlumnosImpl alumnoDAO = new DAO_AlumnosImpl(conexion);
            
            DTO_Alumnos alumnosDTO = new DTO_Alumnos();
            alumnosDTO.setId_alumno(id);
            alumnoDAO.delete(alumnosDTO);
            
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Se ha borrado al alumno");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entramos al rollback: "+ex);
            try {
                conexion.rollback();
            } catch (SQLException exl) {
                JOptionPane.showMessageDialog(null, exl);
            }
        }
    }
    
    private void limpiar(){
        TextField_Nombre.setText("");
        TextField_Carne.setText("");
        TextField_Correo.setText("");
        TextField_Id.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Button_Agregar = new javax.swing.JButton();
        Button_Actualizar = new javax.swing.JButton();
        Button_Borrar = new javax.swing.JButton();
        Button_Seleccionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextField_Carne = new javax.swing.JTextField();
        TextField_Nombre = new javax.swing.JTextField();
        TextField_Correo = new javax.swing.JTextField();
        TextField_Id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Button_Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Carne", "Nombre", "Correo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Button_Agregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Agregar.setText("Agregar Alumno");
        Button_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AgregarActionPerformed(evt);
            }
        });

        Button_Actualizar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Actualizar.setText("Actualizar Alumno");
        Button_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ActualizarActionPerformed(evt);
            }
        });

        Button_Borrar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Borrar.setText("Borrar Alumno");
        Button_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BorrarActionPerformed(evt);
            }
        });

        Button_Seleccionar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Seleccionar.setText("Listar Alumnos");
        Button_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SeleccionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Carne");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Correo");

        TextField_Carne.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        TextField_Nombre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        TextField_Correo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        TextField_Id.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Id para borrar o actualizar");

        Button_Regresar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Regresar.setText("Regresar");
        Button_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(Button_Seleccionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_Agregar)
                                .addGap(190, 190, 190))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(137, 137, 137)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(TextField_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                                                .addComponent(TextField_Carne)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(65, 65, 65)
                                            .addComponent(TextField_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(Button_Actualizar)
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Button_Borrar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(Button_Regresar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(Button_Seleccionar)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextField_Carne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TextField_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(Button_Agregar)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(TextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_Actualizar)
                            .addComponent(Button_Borrar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(Button_Regresar)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_Button_SeleccionarActionPerformed

    private void Button_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AgregarActionPerformed
        // TODO add your handling code here:
        if(TextField_Nombre.getText().equals("") || TextField_Carne.getText().equals("") || TextField_Correo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nombre, contraseña o carne estan vacios");
        }else{
            int carne;
            String nombre, correo;
            carne = Integer.parseInt(TextField_Carne.getText());
            nombre = TextField_Nombre.getText();
            correo = TextField_Correo.getText();
            agregar(carne, nombre, correo);
            limpiar();
        }
        
    }//GEN-LAST:event_Button_AgregarActionPerformed

    private void Button_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ActualizarActionPerformed
        // TODO add your handling code here:
        if(TextField_Nombre.getText().equals("") || TextField_Carne.getText().equals("") || TextField_Correo.getText().equals("") || TextField_Id.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nombre, contraseña o carne estan vacios");
        }else{
            int carne, id;
            String nombre, correo;
            id = Integer.parseInt(TextField_Id.getText());
            carne = Integer.parseInt(TextField_Carne.getText());
            nombre = TextField_Nombre.getText();
            correo = TextField_Correo.getText();
            actualizar(carne, id, nombre, correo);
            limpiar();
            
        }
        
    }//GEN-LAST:event_Button_ActualizarActionPerformed

    private void Button_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BorrarActionPerformed
        // TODO add your handling code here:
        if(TextField_Id.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Id esta vacio");
        }else{
            int id = Integer.parseInt(TextField_Id.getText());
            borrar(id);
            limpiar();
            
        }
        
    }//GEN-LAST:event_Button_BorrarActionPerformed

    private void Button_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RegresarActionPerformed
        // TODO add your handling code here:
        Elegir_tabla tabla = new Elegir_tabla();
        tabla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Button_RegresarActionPerformed

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
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Actualizar;
    private javax.swing.JButton Button_Agregar;
    private javax.swing.JButton Button_Borrar;
    private javax.swing.JButton Button_Regresar;
    private javax.swing.JButton Button_Seleccionar;
    private javax.swing.JTextField TextField_Carne;
    private javax.swing.JTextField TextField_Correo;
    private javax.swing.JTextField TextField_Id;
    private javax.swing.JTextField TextField_Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}