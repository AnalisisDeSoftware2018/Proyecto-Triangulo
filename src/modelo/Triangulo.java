package modelo;

/**
 *
 * @author laboratorios
 */
public class Triangulo {

    /**
     * @param args the command line arguments
     */
    
    private double lado1;
    private double lado2;
    private double lado3;
    
    public Triangulo(double lado1,double lado2,double lado3){
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
    }
    
//    public static void main(String[] args) {
//       Triangulo t1 = new Triangulo(1,2,3);
//        System.out.println("T1: " + t1.tipo());
//        
//        Triangulo t2 = new Triangulo(2,2,3);
//        System.out.println("T2: " + t2.tipo());
//        
//        Triangulo t3 = new Triangulo(2,2,2);
//        System.out.println("T3: " + t3.tipo());
//        
//        Triangulo t4 = new Triangulo(4,5,6);
//        System.out.println("T4: " + t4.tipo());
//    }
    
    public boolean esTriangulo(){
        return esMayorLado(lado1, lado2, lado3) &&
                esMayorLado(lado2, lado3, lado1) &&
                esMayorLado(lado1, lado3, lado2);
    }
    
    public boolean esMayorLado(double a, double b, double c){
        return (a+b)>c;
    }
    
   public String tipo(){
       if (esTriangulo()){
            if(lado1==lado2 && lado2==lado3){
                return "Triángulo equilátero";
            }else if(lado1!=lado2 && lado2!=lado3 && lado1!=lado3){
                return "Triángulo escaleno";
            }
            return "Triángulo isósceles";
       }
       return "No se forma un triángulo";
   }
}