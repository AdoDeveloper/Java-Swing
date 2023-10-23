/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pru.controladores;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import pru.modelos.modeloProductos;

public class Controlador extends Conexion{
    private modeloProductos modelo;
    
    public Controlador(){
        modelo = new modeloProductos();
    }
    
    public ArrayList<modeloProductos> TODOS_LOS_PRODUCTOS()
    {
        ArrayList<modeloProductos> Productos = new ArrayList<>();
        try
        {
            if(super.Conectar())
            {
                java.sql.Statement s = super._connexion.createStatement();
                java.sql.ResultSet rs = s.executeQuery("SELECT ProductID, ProductName, CategoryID, UnitPrice, UnitsInStock FROM products;");
                while (rs.next())
                {
                    modeloProductos producto=new modeloProductos();
                    producto.setProductID(rs.getInt(1));
                    producto.setProductName(rs.getString (2));
                    producto.setCategoryID(rs.getInt(3));
                    producto.setUnitPrice(rs.getDouble(4));
                    producto.setUnitsInStock(rs.getInt(5));
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
    
    //Método para eliminar
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
    
    //Método para actualizar
    public int actualizar(int productID, String productName, int categoryID, double unitPrice, int unitsInStock) {
    int FilasAfectadas = 0;
    try {
        if (super.Conectar()) {
            String sql = "UPDATE products SET ProductName = ?, CategoryID = ?, UnitPrice = ?, UnitsInStock = ? WHERE ProductID = ?";
            
            // Usar una PreparedStatement para evitar problemas de seguridad
            PreparedStatement pstmt = super._connexion.prepareStatement(sql);
            pstmt.setString(1, productName);
            pstmt.setInt(2, categoryID);
            pstmt.setDouble(3, unitPrice);
            pstmt.setInt(4, unitsInStock);
            pstmt.setInt(5, productID);
            
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
    
    //Método para insertar
    public int insertar(String productName,int supplierID, int categoryID, 
                        String quantityPerUnit, double unitPrice, int unitsInStock,
                        int unitsOnOrder,int reorderLevel, int discontinued) {
    int FilasAfectadas = 0;
    try {
        if (super.Conectar()) {
            String sql = "INSERT INTO products(ProductName,SupplierID, CategoryID,"
                         + "QuantityPerUnit,UnitPrice, UnitsInStock, UnitsOnOrder, "
                         + "ReorderLevel, Discontinued) VALUES(?,?,?,?,?,?,?,?,?)";
            
            // Usar una PreparedStatement para evitar problemas de seguridad
            PreparedStatement pstmt = super._connexion.prepareStatement(sql);
            pstmt.setString(1, productName);
            pstmt.setInt(2, supplierID);
            pstmt.setInt(3, categoryID);
            pstmt.setString(4, quantityPerUnit);
            pstmt.setDouble(5, unitPrice); 
            pstmt.setInt(6, unitsInStock);
            pstmt.setInt(7, unitsOnOrder);
            pstmt.setInt(8, reorderLevel);
            pstmt.setInt(9, discontinued);
            
            // Ejecutar la insercion y obtener el número de filas afectadas
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
}
