/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.controladores;
import crud.modelos.modeloProductos;
import java.util.ArrayList;

public class CrudControlador extends crud.controladores.Conexion{
    
    private modeloProductos modelo;
    
    public CrudControlador(){
        modelo = new modeloProductos();
    }
    
    public ArrayList<modeloProductos> TODOSPRODUCTOS()
    {
        ArrayList<modeloProductos> Productos=new ArrayList<>();
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
                    producto.setUnitsInStock(rs.getInt(6));
                    Productos.add(producto);
                }
            }
        }
        catch(Exception ex)
        {
            
        }
        return Productos;
    }
}
