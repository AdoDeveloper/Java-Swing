/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.controladores;

public class Operacion extends Conexion{
    public void Consultar(String pConsulta)
    {
        try
        {
            if(super.Conectar())
            {
                java.sql.Statement s = super._connexion.createStatement();
                java.sql.ResultSet rs = s.executeQuery (pConsulta);
                while (rs.next())
                {
                    System.out.println (rs.getInt (1) + " " + rs.getString (2)+" "+rs.getInt(3)+" "+rs.getInt(4)+
                    " "+rs.getString(5)+" "+rs.getDouble(6)+" "+rs.getInt(7));
                }
            }
        }
        catch(Exception ex)
        {
            
        }
    }
}
