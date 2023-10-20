/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pru.vistas;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pru.controladores.Controlador;
import pru.modelos.modeloProductos;

public class ActualizarProducto extends javax.swing.JDialog {
        
    private int productoID; // Variable para almacenar el ID del producto que se está editando

    // Constructor que recibe el ID del producto a editar
    public ActualizarProducto(int productoID, boolean par) {
        initComponents();
        this.productoID = productoID; // Almacena el ID del producto a editar
        cargarDatosDelProducto(productoID); // Carga los datos del producto en los campos
    }
    
    private void cargarDatosDelProducto(int productoID) {
    Controlador oProducto = new Controlador();

    // Obtén la lista de todos los productos
    ArrayList<modeloProductos> productos = oProducto.TODOS_LOS_PRODUCTOS();

    // Busca el producto con el ID proporcionado
    modeloProductos productoEncontrado = null;
    for (modeloProductos producto : productos) {
        if (producto.getProductID() == productoID) {
            productoEncontrado = producto;
            break;
        }
    }

    if (productoEncontrado != null) {
        // Muestra el ID del producto sin permitir la edición
        tfIDProducto.setText(String.valueOf(productoEncontrado.getProductID()));
        tfIDProducto.setEditable(false);

        // Rellena los otros campos del formulario con los datos del producto
        tfNombreProducto.setText(productoEncontrado.getProductName());
        tfIDCategoria.setText(String.valueOf(productoEncontrado.getCategoryID()));
        tfPrecioUnitario.setText(String.valueOf(productoEncontrado.getUnitPrice()));
        tfExistencia.setText(String.valueOf(productoEncontrado.getUnitsInStock()));
    } else {
        // Maneja el caso en el que no se pudo encontrar el producto con el ID especificado
        JOptionPane.showMessageDialog(this, "No se pudo encontrar el producto con ID " + productoID, "Error", JOptionPane.ERROR_MESSAGE);
        // Puedes decidir si quieres cerrar el formulario o realizar otra acción apropiada.
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

        tfIDProducto = new javax.swing.JTextField();
        tfNombreProducto = new javax.swing.JTextField();
        tfIDCategoria = new javax.swing.JTextField();
        tfPrecioUnitario = new javax.swing.JTextField();
        tfExistencia = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIDCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(tfIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfIDCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnActualizar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        // Obtén el ID del producto desde el campo no editable tfIDProducto
    int idProducto = Integer.parseInt(tfIDProducto.getText());

    // Obtén los valores de los campos de texto
    String nombreProducto = tfNombreProducto.getText();
    int idCategoria = Integer.parseInt(tfIDCategoria.getText());
    double precioUnitario = Double.parseDouble(tfPrecioUnitario.getText());
    int existencia = Integer.parseInt(tfExistencia.getText());

    // Asegúrate de que se haya ingresado un valor en todos los campos
    if (nombreProducto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Llama a un método en CrudControlador para actualizar el producto
    Controlador oProducto = new Controlador();
    int filasAfectadas = oProducto.actualizar(idProducto, nombreProducto,idCategoria, precioUnitario, existencia);

    if (filasAfectadas > 0) {
        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        // Cierra la ventana ActualizarProductos sin afectar la ventana principal
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JTextField tfExistencia;
    private javax.swing.JTextField tfIDCategoria;
    private javax.swing.JTextField tfIDProducto;
    private javax.swing.JTextField tfNombreProducto;
    private javax.swing.JTextField tfPrecioUnitario;
    // End of variables declaration//GEN-END:variables

}