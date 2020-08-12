/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class Cliente extends Persona{
    
    private ArrayList<Hijo> hijos;
    private boolean formaDePagoDebitoAutomatico;
    private boolean formaDePagoTarjetaCredito;
    private boolean formaDePagoTransferenciaBancaria;
    
    public static final int SOLTERO = 1;
    public static final int CASADO = 2;
    public static final int DIVORCIADO = 3;

    public Cliente(String nombre, String apellido, boolean esMasculino, int estadoCivil) {
        super(nombre, apellido, esMasculino, estadoCivil);
    }
    
    public Cliente(String nombre, String apellido, boolean esMasculino, int estadoCivil,
                ArrayList<Hijo> hijos, boolean formaDePagoDebitoAutomatico, 
                boolean formaDePagoTarjetaCredito, boolean formaDePagoTransferenciaBancaria) {
        super(nombre, apellido, esMasculino, estadoCivil);
        this.hijos = hijos;
        this.formaDePagoDebitoAutomatico = formaDePagoDebitoAutomatico;
        this.formaDePagoTarjetaCredito = formaDePagoTarjetaCredito;
        this.formaDePagoTransferenciaBancaria = formaDePagoTransferenciaBancaria;
    }

    public ArrayList<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Hijo> hijos) {
        this.hijos = hijos;
    }

    public boolean isFormaDePagoDebitoAutomatico() {
        return formaDePagoDebitoAutomatico;
    }

    public void setFormaDePagoDebitoAutomatico(boolean formaDePagoDebitoAutomatico) {
        this.formaDePagoDebitoAutomatico = formaDePagoDebitoAutomatico;
    }

    public boolean isFormaDePagoTarjetaCredito() {
        return formaDePagoTarjetaCredito;
    }

    public void setFormaDePagoTarjetaCredito(boolean formaDePagoTarjetaCredito) {
        this.formaDePagoTarjetaCredito = formaDePagoTarjetaCredito;
    }

    public boolean isFormaDePagoTransferenciaBancaria() {
        return formaDePagoTransferenciaBancaria;
    }

    public void setFormaDePagoTransferenciaBancaria(boolean formaDePagoTransferenciaBancaria) {
        this.formaDePagoTransferenciaBancaria = formaDePagoTransferenciaBancaria;
    }
    
    
}
