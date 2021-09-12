/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import beans.Pais;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class PaisController {
    private ArrayList<Pais> listaPais;

    public PaisController(){
        listaPais = new ArrayList<Pais>();
        cargar();          
    }
    public Pais get(int indice){
        return listaPais.get(indice);
    }
    public int size(){
        return listaPais.size();
    }
    public void cargar(){
    try{
        BufferedReader br;
        String linea=null;
        String[] array=null;
        br = new BufferedReader(new FileReader("pais.txt"));
        while((linea = br.readLine()) != null ){
            array = linea.split(";");
            Pais pais =
                    new Pais((array[0].trim()), array[1].trim());
            listaPais.add(pais);
        }
        br.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    
}
