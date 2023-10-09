import java.util.Scanner;


/**
 * Programa que invoca otro programa java compilado y guardado en ./bin
 * @author Dante Sarotti
 * @version 0.1
 */
public class Programa2 {
    public static void main(String[] args) throws Exception {
        
        // Especificar la ruta a las clases
        final String classPath = ".\\bin";
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el argumento que pasarle al programa: ");
        String argumento = sc.nextLine();
        try {
            // Crea un objeto ProcessBuilder
            ProcessBuilder builder = new ProcessBuilder("java","-cp", classPath,"ProgramaUno",argumento);

            //Redireccionar las entradas y salidas del proceso hijo a las mismas del proceso actual.
            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectErrorStream(true);

            // Inicia el proceso
            Process proceso = builder.start();

            // Espera a que el proceso termine
            int retornoProceso = proceso.waitFor();

            // Puedes verificar el valor de retorno si lo deseas
            System.out.println("\nEl proceso ha terminado con código de retorno: "+ retornoProceso );

        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
        System.out.println("\nSaliendo del programa.");
    }
}