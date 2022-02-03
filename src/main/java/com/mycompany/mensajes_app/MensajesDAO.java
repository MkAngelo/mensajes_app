/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensajes"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println();
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void borrarMensajesDB(int id_mensajes){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try{
                String query="DELETE FROM mensajes WHERE id_mensajes = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensajes);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            } catch(SQLException e){
                System.out.println(e);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void actualizarMensajesDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try{
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensajes = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado");
            } catch(SQLException e){
                System.out.println(e);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
