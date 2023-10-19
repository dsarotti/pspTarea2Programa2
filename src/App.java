import java.util.Scanner;


/**
 * Este Programa ejecuta otro programa java siempre y cuando este último conste de un solo archivo.
 * @author Dante Sarotti
 * @version 0.1
 */
public class App {
    public static void main(String[] args) throws Exception {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el argumento que pasarle al programa: ");
        String argumento = sc.nextLine();
        try {

            // Crea un objeto ProcessBuilder
            ProcessBuilder builder = new ProcessBuilder("java", "ProgramaUno.java",argumento);

            //Redireccionar las entradas y salidas del proceso hijo a las mismas del proceso actual.
            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectErrorStream(true);

            // Inicia el proceso
            Process proceso = builder.start();

            // Espera a que el proceso termine
            int retornoProceso = proceso.waitFor();

            // Mostrar el valor de retorno del proceso
            System.out.println("\nEl proceso ha terminado con código de retorno: "+ retornoProceso );

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con la ejecución del programa.");
            e.printStackTrace();
        }
        sc.close();
        System.out.println("\nSaliendo del programa.");
    }
}