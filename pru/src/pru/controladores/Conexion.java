/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pru.controladores;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private final Configuracion oConfiguracion = new Configuracion();
    public final String
    URL = "jdbc:mysql://"+oConfiguracion.getServidor()+":"+
            oConfiguracion.getPuerto()+"/"+oConfiguracion.getBase();
    
    protected Connection _connexion;
    
    protected boolean Conectar()
    {
        boolean Conectado=false;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            _connexion = (Connection) DriverManager.getConnection(URL, oConfiguracion.getUsuario(), oConfiguracion.getClave());
            Conectado=true;
            System.out.println("Conexion abierta");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            Conectado=false;
        }
        return Conectado;
}
        protected void Desconectar()
        {
        try
        {
            if (_connexion != null && !_connexion.isClosed())
            {
            _connexion.close();
            System.out.println("Conexion cerrada");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}
