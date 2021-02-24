import java.util.Random;
import java.util.ArrayList;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder{
    private Random ran;
    private ArrayList<String> array;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder(){
        ran = new Random();
        array = new ArrayList<>();
        array.add("Eso es facil de resolver");
        array.add("Eso va a dar problemas...");
        array.add("Necesito verlo en persona");
        array.add("Ejecuta ctrl+alt F5");
        array.add("Habra que cambiar el equipo");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(){
        return array.get(ran.nextInt(array.size()));
    }
}
