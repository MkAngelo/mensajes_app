/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mkangelo
 */
public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query="INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch(SQLException ex){
                System.out.println(ex);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        
    }
    
    public static void borrarMensajesDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajesDB(Mensajes mensajes){
        
    }
}
