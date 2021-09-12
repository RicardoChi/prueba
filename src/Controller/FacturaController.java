/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import beans.Factura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class FacturaController {
    public ArrayList<Factura> listaFactura;

    public FacturaController(){
        listaFactura = new ArrayList<Factura>();
        cargar();          
    }
    public void add(Factura factura){
       listaFactura.add(factura);
    }
    public Factura get(int indice){
        return listaFactura.get(indice);
    }
    public int size(){
        return listaFactura.size();
    }
    public int getNumeroVuelo(){       
            return (int)(Math.random()*100000+999999);
     }
    public double precioTotal(){
       double st=0;
       for(int i=0;i<listaFactura.size();i++){
           st+=listaFactura.get(i).getTarifa();
       }   
        return st;
    }
     public void grabar(){
    try{
        PrintWriter pw;
        String linea;
        pw= new PrintWriter(new FileWriter("factura.txt"));
        for(int i=0;i<size();i++){
            linea=(listaFactura.get(i).getNumeroVuelo()+ ";" + 
                       listaFactura.get(i).getTicket()+ ";" +
                       listaFactura.get(i).getNombre()+ ";"+
                       listaFactura.get(i).getApellidoPaterno()+ ";"+
                       listaFactura.get(i).getApellidoMaterno()+ ";"+
                       listaFactura.get(i).getDni()+ ";"+
                       listaFactura.get(i).getDestino()+ ";"+
                       listaFactura.get(i).getSalida()+ ";"+
                       listaFactura.get(i).getHora()+ ";"+
                       listaFactura.get(i).getPrecioViaje() + ";"+
                       listaFactura.get(i).getTarifa()+ ";"+
                       listaFactura.get(i).getSexo()+ ";"+
                       listaFactura.get(i).getClase()+ ";"+
                       listaFactura.get(i).getAsiento()+ ";"+
                       listaFactura.get(i).getEquipaje()+ ";"+
                       listaFactura.get(i).getTipoPago()+ ";"+
                       listaFactura.get(i).getNombrePais()+ ";"+ 
                       listaFactura.get(i).getPuertaEmbarque()+ ";"+
                       listaFactura.get(i).getEstado()+ ";"
                    

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
        br = new BufferedReader(new FileReader("Factura.txt"));
        while((linea = br.readLine()) != null ){
            array = linea.split(";");
            Factura factura =
                    new Factura((array[0].trim()), array[1].trim(),
                            array[2].trim(), array[3].trim(),array[4].trim(),array[5].trim(),array[6].trim(),
                            array[7].trim(),Double.parseDouble(array[8].trim()),array[9].trim(),array[10].trim(),array[11].trim()
                            ,array[12].trim(),array[13].trim());
            
            listaFactura.add(factura);
        }
        br.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
    public String getAsiento(){
     String palabra="";
     
     int codigoAscii=(int)Math.floor(Math.random()*(70-65)+65);
         palabra = palabra + (char)codigoAscii; 
         
         return palabra;
    }
    public int getNumero(){
          return (int)(Math.random()*(9 -1)+1);
   
}
    public Factura buscar(String num){
     for(Factura auxiliar:listaFactura)
         if(auxiliar.getTicket().equalsIgnoreCase(num))
             return auxiliar;
    return null;
    }
    
    
}

