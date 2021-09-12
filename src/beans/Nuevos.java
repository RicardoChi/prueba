/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Nuevos extends Cliente {
    private String partida;
    private String destino;
    private String salida;
    private String hora;
    private double tarifa;
    private double precioViaje;
    private double costoPasaje;
    
    
    public Nuevos(){
        
    }

    public Nuevos(String partida, String destino, String salida, String hora, double tarifa, double precioViaje, double costoPasaje) {
        this.partida = partida;
        this.destino = destino;
        this.salida = salida;
        this.hora = hora;
        this.tarifa = tarifa;
        this.precioViaje = precioViaje;
        this.costoPasaje = costoPasaje;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getPrecioViaje() {
        return precioViaje;
    }

    public void setPrecioViaje(double precioViaje) {
        this.precioViaje = precioViaje;
    }

    public double getCostoPasaje() {
        return costoPasaje;
    }

    public void setCostoPasaje(double costoPasaje) {
        this.costoPasaje = costoPasaje;
    }

    
   
}
