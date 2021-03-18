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
    private HashMap<HashSet<String>, String> respuestasAsociadas;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder(){
        HashSet<String> perifericos = new HashSet<>();
        perifericos.add("raton");
        perifericos.add("teclado");
        perifericos.add("impresora");
        HashSet<String> corriente = new HashSet<>();
        corriente.add("monitor");
        corriente.add("alimentacion");
        corriente.add("arranque");
        HashSet<String> software = new HashSet<>();
        software.add("hdd");
        software.add("usb");
        software.add("ram");
        ran = new Random();
        respuestas = new ArrayList<>();
        respuestas.add("Eso es facil de resolver");
        respuestas.add("Eso va a dar problemas...");
        respuestas.add("Necesito verlo en persona");
        respuestas.add("Ejecuta ctrl+alt F5");
        respuestas.add("Habra que cambiar el equipo");
        respuestasAsociadas = new HashMap<>();
        respuestasAsociadas.put(perifericos, "Conectalo y desconectalo");
        respuestasAsociadas.put(corriente, "Comprueba el cable de corriente");
        respuestasAsociadas.put(software, "Habra que pasarle un software para ver su estado");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput){
        String aDevolver = "";
        if(respuestasAsociadas.get(userInput) != null){
            aDevolver = respuestasAsociadas.get(userInput);
        } else{
            aDevolver = respuestas.get(ran.nextInt(respuestas.size()));
        }
        return aDevolver;
    }
}
