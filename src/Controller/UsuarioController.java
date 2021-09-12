/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import beans.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UsuarioController {
    public List<Usuario> listaUsuario;
    
    public UsuarioController(){
        this.listaUsuario= new ArrayList<Usuario>();
        cargar();
    }
    public void add(Usuario usuario){
        this.listaUsuario.add(usuario);
    }
    public Usuario get(int posicion){
        return this.listaUsuario.get(posicion);
    }
    public int size(){
        return listaUsuario.size();
    }
    public boolean getValidar(String usuario, String password){
        for(int i=0;i<size();i++){
        if(this.listaUsuario.get(i).getNombreUsuario().equalsIgnoreCase(usuario) 
                && this.listaUsuario.get(i).getContraseñaUsuario().equalsIgnoreCase(password)){
            return true;
            }
        }
        return false;
    }
    public void grabar(){
        try{
            PrintWriter pw;
            String linea;
            pw=new PrintWriter(new FileWriter("usuario.txt"));
            for(int i=0;i<size();i++){
               linea=(listaUsuario.get(i).getCodigo() + ";" + 
                      listaUsuario.get(i).getNombreUsuario()+ ";" +
                      listaUsuario.get(i).getContraseñaUsuario()+ ";" 
                       ); 
               pw.println(linea);
            }
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void cargar(){
        try{
            BufferedReader br;
            String linea=null;
            //array es un nombre cualquiera
            String[] array=null;
            //abrir un espacio en la memoria para meter los datos
            br = new BufferedReader(new FileReader("usuario.txt"));
            while((linea = br.readLine()) !=null){
                array = linea.split(";");
                //crear el objeto de tipo producto con los datos del archivo
                Usuario usuario=
                        new Usuario(Integer.parseInt(array[0].trim()),array[1].trim(),
                                array[2].trim());
                //Agregar el objeto al ArrayList
                listaUsuario.add(usuario);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
