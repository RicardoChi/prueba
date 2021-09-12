/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import beans.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class ClienteController {
    private ArrayList<Cliente> listaCliente;

public ClienteController(){
    listaCliente=new ArrayList<Cliente>();
    cargar();
}
public void agregar(Cliente cliente){
        listaCliente.add(cliente);
    }
public Cliente get(int indice){
    return listaCliente.get(indice);
}
public int size(){
    return listaCliente.size();
}
public int obtenerCorrelativo(){
    if(listaCliente.size()==0){
        return 1;
    }else{
        return listaCliente.get(listaCliente.size()-1).getCodigo()+1;
    }
}
public Cliente buscar(int cod){
     for(int i=0;i<listaCliente.size();i++)
         if(listaCliente.get(i).getCodigo() == cod)
             return listaCliente.get(i);
    return null;
    }  

public void grabar(){
        try{
            PrintWriter pw;
            String linea;
            pw=new PrintWriter(new FileWriter("cliente.txt"));
            for(int i=0;i<size();i++){
               linea=(listaCliente.get(i).getCodigo() + ";" + 
                      listaCliente.get(i).getNombre() + ";" +
                      listaCliente.get(i).getApellidoPaterno()+ ";" +
                      listaCliente.get(i).getApellidoMaterno()+ ";"+
                      listaCliente.get(i).getFechaN()+";"+
                      listaCliente.get(i).getEstado()+ ";"+
                      listaCliente.get(i).getDni()+ ";"+
                      listaCliente.get(i).getCorreo()+ ";"+
                      listaCliente.get(i).getSexo()+ ";"
                      
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
            String[] array=null;
            br = new BufferedReader(new FileReader("cliente.txt"));
            while((linea = br.readLine()) !=null){
                array = linea.split(";");
                Cliente Cliente= 
                        new Cliente(Integer.parseInt(array[0].trim()),array[1].trim(),
                        array[2].trim(),array[3].trim(),array[4].trim(),array[5].trim(),
                                array[6].trim(),array[7].trim(),array[8].trim()
                        );
                listaCliente.add(Cliente);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
   
}