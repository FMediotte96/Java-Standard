package ar.com.eduit.curso.java.entities;

public class Cuenta {
    private int nro;
    private String moneda;
    private float saldo;
    
    //constructor
    /**
     * Método deprecado por Carlos Ríos el 2017/09/07 por ser
     * inseguro, usar en su reemplazo Cuenta(int nro, String moneda)
     * 
     */
//    @Deprecated
//    public Cuenta() {//constructor vacio
//    }

    public Cuenta(int nro, String moneda) {
        this.nro = nro;
        this.moneda = moneda;
        this.saldo=0;
    }
    
    public void depositar(float monto){saldo+=monto;}
    
    public void debitar(float monto){
        if(saldo>=monto) saldo-=monto;
        else System.out.println("Saldo Insuficiente.");
    }

    @Override
    public String toString(){
        return nro+" "+moneda+" "+saldo;
    }

    public int getNro() {
        //Código de auditoria y control
        return nro;
    }

    public String getMoneda() {
        //Código de auditoria y control
        return moneda;
    }

    public float getSaldo() {
        //Código de auditoria y control
        return saldo;
    }
}
