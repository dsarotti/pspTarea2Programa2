import java.util.Scanner;


/**
 * Este Programa ejecuta otro programa java siempre y cuando este último conste de un solo archivo.
 * @author Dante Sarotti
 * @version 0.1
 */
public class App {
    public static void main(String[] args) throws Exception {
    
        //Obtener por teclado los argumentos con los que ejecutar el programa
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el argumento que pasarle al programa: ");
        String argumento = sc.nextLine();

        //Obtener el runtime
        Runtime r = Runtime.getRuntime();
        
        //Crear el proceso
        Process p = r.exec("java ProgramaUno.java "+ argumento);

        //Ejecutar el proceso y esperar a que finalice
        int retornoProceso = p.waitFor();
        System.out.println("Con Runtime la ejecución devuelve el valor de retorno " + retornoProceso);

        sc.close();
        System.out.println("\nSaliendo del programa.");
    }
}