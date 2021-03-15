import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder{
    private Random ran;
    private ArrayList<String> respuestas;
    private HashMap<String, String> respuestasAsociadas;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder(){
        ran = new Random();
        respuestas = new ArrayList<>();
        respuestas.add("Eso es facil de resolver");
        respuestas.add("Eso va a dar problemas...");
        respuestas.add("Necesito verlo en persona");
        respuestas.add("Ejecuta ctrl+alt F5");
        respuestas.add("Habra que cambiar el equipo");
        respuestasAsociadas = new HashMap<>();
        respuestasAsociadas.put("raton", "Conectalo y desconectalo");
        respuestasAsociadas.put("teclado", "Al ser bluethoot prueba a emparejarlo");
        respuestasAsociadas.put("monitor", "Comprueba el cable de corriente");
        respuestasAsociadas.put("hdd", "Habra que pasarle un software para ver su estado");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput){
        String aDevolver = "";
        boolean encontrada = false;
        HashSet<String> entrada = userInput;
        for(String respuestaActual : entrada){
            if(respuestasAsociadas.get(respuestaActual) != null && encontrada == false){
                aDevolver = respuestasAsociadas.get(respuestaActual);
                encontrada = true;
            } else if(encontrada == false){
                aDevolver = respuestas.get(ran.nextInt(respuestas.size()));
            }
        }
        return aDevolver;
    }
}
