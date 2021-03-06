/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author mkangelo
 */
public class mensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("Tu nombre: ");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje: ");
        int id_mensajes=sc.nextInt();
        MensajesDAO.borrarMensajesDB(id_mensajes);
    }
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("Ingresa el ID del mensaje: ");
        int id_mensajes = sc.nextInt();
        
        Mensajes actualizacion = new Mensajes();
        actualizacion.setIdMensaje(id_mensajes);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajesDB(actualizacion);
    }
}
