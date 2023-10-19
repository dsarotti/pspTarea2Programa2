/**
 * Programa que recibe un array de strings y 
 * devuelve un resultado en función del contenido del array
 * @author Dante Sarotti
 * @version 0.1
 */
public class ProgramaUno {

    /**
     * admite argumentos desde main() y devuelve con System.exit() los siguientes valores:
     * Si el número de argumentos es < 1 devuelve 1
     * Si el argumento es una cadena devuelve 2
     * Si el argumento es un número entero negativo devuelve 3
     * En cualquier otro caso devuelve 0
     * @param args argumentos de entrada
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        for (String string : args) {
            if (string.isEmpty()){

                //No hay argumentos
                System.exit(1);
            }else if (comprobarSiEsInt(string)){
                if (Integer.parseInt(string)>=0){

                    //Es un entero positivo
                    System.exit(0); 
                }else {  
                
                    //Es un entero negativo
                    System.exit(3);
                }
            }
            //No es un entero
            System.exit(2);
        }
    }

     /** 
     * Comprueba si el parámetro de entrada contiene
     * únicamente un número entero o no
     * 
     * @param texto el texto que se va a comprobar
     * @return Boolean 
     */
    public static Boolean comprobarSiEsInt(String texto){
        try{
            Integer.parseInt(texto);
        }catch (NumberFormatException e){

            //Si se genera la excepción, no es un número entero.
            return false;
        }
        return true;
    }
}