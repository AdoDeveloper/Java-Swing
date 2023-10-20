/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.controladores;
import crud.modelos.modeloProductos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudControlador extends crud.controladores.Conexion{
    
    private modeloProductos modelo;
    
    public CrudControlador(){
        modelo = new modeloProductos();
    }
    
    public int eliminar(int IDProducto)
    {
    int FilasAfectadas = 0;
    try {
        if (super.Conectar()) {
            String sql = "DELETE FROM products WHERE ProductID = ?";
            
            // Usar una PreparedStatement para evitar problemas de seguridad
            PreparedStatement pstmt = super._connexion.prepareStatement(sql);
            pstmt.setInt(1, IDProducto);
            
            // Ejecutar la eliminación y obtener el número de filas afectadas
            FilasAfectadas = pstmt.executeUpdate();
            
            // Cierra la declaración y la conexión
            pstmt.close();
            super.Desconectar();
        } else {
            FilasAfectadas = -1;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Puedes manejar la excepción adecuadamente aquí, por ejemplo, registrando el error o mostrando un mensaje al usuario.
        // Aquí simplemente se imprime el stack trace.
    }
    
    return FilasAfectadas;
    }
    
    public int actualizar(int productID, String productName, int supplierID, int categoryID, String quantityPerUnit, double unitPrice, int unitsInStock) {
    int FilasAfectadas = 0;
    try {
        if (super.Conectar()) {
            String sql = "UPDATE products SET ProductName = ?, SupplierID = ?, CategoryID = ?, QuantityPerUnit = ?, UnitPrice = ?, UnitsInStock = ? WHERE ProductID = ?";
            
            // Usar una PreparedStatement para evitar problemas de seguridad
            PreparedStatement pstmt = super._connexion.prepareStatement(sql);
            pstmt.setString(1, productName);
            pstmt.setInt(2, supplierID);
            pstmt.setInt(3, categoryID);
            pstmt.setString(4, quantityPerUnit);
            pstmt.setDouble(5, unitPrice);
            pstmt.setInt(6, unitsInStock);
            pstmt.setInt(7, productID);
            
            // Ejecutar la actualización y obtener el número de filas afectadas
            FilasAfectadas = pstmt.executeUpdate();
            
            // Cierra la declaración y la conexión
            pstmt.close();
            super.Desconectar();
        } else {
            FilasAfectadas = -1;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Aquí simplemente se imprime el stack trace.
    }
    
    return FilasAfectadas;
    }
    
    public ArrayList<modeloProductos> TODOS_LOS_PRODUCTOS()
    {
        ArrayList<modeloProductos> Productos = new ArrayList<>();
        try
        {
            if(super.Conectar())
            {
                java.sql.Statement s = super._connexion.createStatement();
                java.sql.ResultSet rs = s.executeQuery("SELECT ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock FROM products;");
                while (rs.next())
                {
                    modeloProductos producto=new modeloProductos();
                    producto.setProductID(rs.getInt(1));
                    producto.setProductName(rs.getString (2));
                    producto.setSupplierID(rs.getInt(3));
                    producto.setCategoryID(rs.getInt(4));
                    producto.setQuantityPerUnit(rs.getString(5));
                    producto.setUnitPrice(rs.getDouble(6));
                    producto.setUnitsInStock(rs.getInt(7));
                    Productos.add(producto);
                }
            }
            
            super.Desconectar();
        }
        catch(Exception ex)
        {
            
        }
        return Productos;
    }

}
