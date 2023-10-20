/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package region.controladores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import region.modelos.modeloRegion;

public class Controlador extends region.controladores.Conexion{
    private modeloRegion modelo;
    
     public Controlador(){
         modelo = new modeloRegion();
     }
    
     public ArrayList<modeloRegion> TODASREGIONES(){
         ArrayList<modeloRegion> Regiones = new ArrayList<>();
         try{
            if(super.Conectar()){
                java.sql.Statement s = super._connexion.createStatement();
                java.sql.ResultSet rs = s.executeQuery("SELECT RegionID, RegionDescription FROM region");
                     while (rs.next())
                     {
                         modeloRegion region = new modeloRegion();
                         region.setRegionID(rs.getInt(1));
                     }
                
            }else{
                
            }    
         }catch(Exception e){
         
         }
         return Regiones;
     }
}
