/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.controladores;

public class Configuracion {
    
    private String _Servidor="localhost";
    private String _Puerto="3306";
    private String _Usuario="root";
    private String _Clave="root";
    private String _Base ="northwind";
    
    public String getServidor() {
        return _Servidor;
    }

    public void setServidor(String _Servidor) {
        this._Servidor = _Servidor;
    }

    public String getPuerto() {
        return _Puerto;
    }

    public void setPuerto(String _Puerto) {
        this._Puerto = _Puerto;
    }

    public String getUsuario() {
        return _Usuario;
    }

    public void setUsuario(String _Usuario) {
        this._Usuario = _Usuario;
    }

    public String getClave() {
        return _Clave;
    }

    public void setClave(String _Clave) {
        this._Clave = _Clave;
    }

    public String getBase() {
        return _Base;
    }

    public void setBase(String _Base) {
        this._Base = _Base;
    }

}
