/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge
 */
public class MensajeDAO {

    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                String query = "INSERT INTO mensajes (id_mensaje, mensaje, autor_mensaje, fecha_mensaje) VALUES (NULL,?,?,current_timestamp())";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try(Connection conexion = db_connect.get_connection()){
            String query ="SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
            
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
           PreparedStatement ps = null;
           
           try {
               String query="DELETE FROM mensajes WHERE id_mensaje = ?";
               ps = conexion.prepareStatement(query);
               ps.setInt(1, id_mensaje);
               ps.executeUpdate();
               System.out.println("El mensaje ha sido borrado");
               
           }catch(SQLException e){
               System.out.println(e);
               System.out.println("No se pudo borrar el mensaje");
               
           }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                String query="UPDATE FROM mensajes SET mensaje = ? WHERE id_mensajes = ? ";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje se actualizo correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
