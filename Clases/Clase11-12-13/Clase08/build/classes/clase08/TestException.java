package clase08;

public class TestException {
    public static void generarException(){
        int[] vector=new int[4];
        vector[10]=20;
    }                                   
    public static void generarException(boolean x){
        if(x) System.out.println(10/0);
    }
    public static void generarException(String texto){
        System.out.println(texto.length());
    }
}
