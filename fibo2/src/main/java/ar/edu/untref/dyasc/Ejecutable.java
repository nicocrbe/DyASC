package ar.edu.untref.dyasc;
public class Ejecutable {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe ingresar al menos un parámetro");
            return;
        }
        int n;
        String serie = "";

       if(args[0].matches("[0-9]+")) {
           n = Integer.parseInt(args[0]);
           serie = SerieFibonacci.fibonacciHorizontal(n);
       }else if(args[0].contains("-o") && args.length == 2){
           n = Integer.parseInt(args[1]);
           String direccion = args[0].split("=")[1];
           serie = SerieFibonacci.getFibonacciPorDireccion(n, serie, direccion);
       }else{
            System.out.println("Opción no válida");
        }
        System.out.println(serie);
    }
}
