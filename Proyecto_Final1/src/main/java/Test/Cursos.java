package Test;

import Conexion.Cls_Conexion;
import Datos.DAO_CursosImpl;
import Dominio.DTO_Cursos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Cursos extends javax.swing.JFrame {

    /**
     * Creates new form Cursos
     */
    public Cursos() {
        initComponents();
        model = (DefaultTableModel) this.jTable1.getModel();        
    }
    DefaultTableModel model;
    
    //Arreglar Listar y Actualizar
    
    private void seleccionar(){
        model.setRowCount(0);
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            DAO_CursosImpl curso = new DAO_CursosImpl(conexion);
            List<DTO_Cursos> cursos = curso.select();
            
            cursos.forEach(cursos2 ->{
                int id = cursos2.getId_curso();
                String nombre = cursos2.getNombre_curso();
                String catedratico = cursos2.getCatedratico();
                String seccion = cursos2.getSeccion();
                
                model.addRow(new Object[]{id, nombre, catedratico, seccion});
            });
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error: "+ex);
        }
    }
    
    private void agregar(String nombreC, String catedratico, String seccion){
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            DAO_CursosImpl cursosDAO = new DAO_CursosImpl(conexion);
            
            DTO_Cursos cursoDTO = new DTO_Cursos();
            cursoDTO.setNombre_curso(nombreC);
            cursoDTO.setCatedratico(catedratico);
            cursoDTO.setSeccion(seccion);
            
            cursosDAO.insert(cursoDTO);
            
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Se ha agregado un nuevo curso");
        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(null, "Entramos al rollback: "+ex);
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
            DAO_CursosImpl cursosDAO = new DAO_CursosImpl(conexion);
            
            DTO_Cursos cursoDTO = new DTO_Cursos();
            cursoDTO.setId_curso(id);
            cursosDAO.delete(cursoDTO);
            
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Curso Borrado");
            
        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(null,"Entramos al rollback: "+ex);
                conexion.rollback();
            } catch (SQLException exl) {
                JOptionPane.showMessageDialog(null, exl);
            }
        }
    }
    
    private void actualizar(int id, String nombre, String catedratico, String seccion){
        Connection conexion = null;
        try {
            conexion = Cls_Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            DAO_CursosImpl cursoDAO = new DAO_CursosImpl(conexion);
            
            DTO_Cursos cursoDTO = new DTO_Cursos();
            cursoDTO.setId_curso(id);
            cursoDTO.setNombre_curso(nombre);
            cursoDTO.setCatedratico(catedratico);
            cursoDTO.setSeccion(seccion);
            cursoDAO.update(cursoDTO);
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Se ha actualizado el curso");
            
        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(null, "Entramos al rollback: "+ex);
                conexion.rollback();
            } catch (SQLException exl) {
                JOptionPane.showMessageDialog(null, exl);
            }
        }
        
    }
    
    private void limpiar(){
        TextField_Nombre.setText("");
        TextField_Catedratico.setText("");
        TextField_Seccion.setText("");
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
        Button_Seleccionar = new javax.swing.JButton();
        Button_Agregar = new javax.swing.JButton();
        Button_Borrar = new javax.swing.JButton();
        Button_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextField_Nombre = new javax.swing.JTextField();
        TextField_Catedratico = new javax.swing.JTextField();
        TextField_Seccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TextField_Id = new javax.swing.JTextField();
        Button_Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_curso", "nombre_curso", "catedratico", "seccion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Button_Seleccionar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Seleccionar.setText("Listar Cursos");
        Button_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SeleccionarActionPerformed(evt);
            }
        });

        Button_Agregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Agregar.setText("Agregar Curso");
        Button_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AgregarActionPerformed(evt);
            }
        });

        Button_Borrar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Borrar.setText("Borrar Curso");
        Button_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BorrarActionPerformed(evt);
            }
        });

        Button_Actualizar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button_Actualizar.setText("Actualizar Curso");
        Button_Actualizar.setToolTipText("");
        Button_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ActualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Curso");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Catedratico");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Seccion");

        TextField_Nombre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        TextField_Catedratico.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        TextField_Seccion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("Id para borrar o actualizar");

        TextField_Id.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

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
                .addGap(228, 228, 228)
                .addComponent(Button_Seleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(215, 215, 215))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 78, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(Button_Agregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addGap(65, 65, 65)
                        .addComponent(TextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TextField_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(TextField_Catedratico))
                    .addComponent(TextField_Seccion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(Button_Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_Actualizar)
                .addGap(61, 61, 61)
                .addComponent(Button_Borrar)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TextField_Catedratico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TextField_Seccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(Button_Agregar)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_Borrar)
                            .addComponent(Button_Actualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(Button_Seleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(Button_Regresar)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_Button_SeleccionarActionPerformed

    private void Button_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AgregarActionPerformed
        // TODO add your handling code here:
        if(TextField_Nombre.getText().equals("") || TextField_Catedratico.getText().equals("") || TextField_Seccion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nombre, catedratico o seccion estan vacios");
        }else{
            String nombre, catedratico, curso;
            nombre = TextField_Nombre.getText();
            catedratico = TextField_Catedratico.getText();
            curso = TextField_Seccion.getText();
            agregar(nombre, catedratico, curso);
            limpiar();
        }
        
       
    }//GEN-LAST:event_Button_AgregarActionPerformed

    private void Button_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BorrarActionPerformed
        // TODO add your handling code here:
        if(TextField_Id.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Id esta vacio");
        }else{
             int id = Integer.parseInt(TextField_Id.getText());
            borrar(id);
        }
       
    }//GEN-LAST:event_Button_BorrarActionPerformed

    private void Button_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ActualizarActionPerformed
        // TODO add your handling code here:
        if(TextField_Nombre.getText().equals("") || TextField_Catedratico.getText().equals("") || TextField_Seccion.getText().equals("") || TextField_Id.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nombre, catedratico, id o seccion estan vacios");
        }else{
            int id;
            String nombre, catedratico, seccion;
            id = Integer.parseInt(TextField_Id.getText());
            nombre = TextField_Nombre.getText();
            catedratico = TextField_Catedratico.getText();
            seccion = TextField_Seccion.getText();
            actualizar(id, nombre, catedratico, seccion);
            limpiar();
        }
        
    }//GEN-LAST:event_Button_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Actualizar;
    private javax.swing.JButton Button_Agregar;
    private javax.swing.JButton Button_Borrar;
    private javax.swing.JButton Button_Regresar;
    private javax.swing.JButton Button_Seleccionar;
    private javax.swing.JTextField TextField_Catedratico;
    private javax.swing.JTextField TextField_Id;
    private javax.swing.JTextField TextField_Nombre;
    private javax.swing.JTextField TextField_Seccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
