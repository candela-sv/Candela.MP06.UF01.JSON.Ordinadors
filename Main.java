import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static final String FITXER_INDIVIDUAL = "Fitxers/ordinador.json";
	private static final String FITXER_LLISTA = "Fitxers/ordinadors.json";
	
    public static void main(String[] args) {
        Ordinador ordinador1 = new Ordinador ("1234", "HP", "15s", 64, 256, "Intel i7");
        Ordinador ordinador2 = new Ordinador ("2234", "Samsung", "17e", 32, 128, "Intel i9");
        
        List<Ordinador> ordinadors = new ArrayList<>();
        ordinadors.add(ordinador1);
        ordinadors.add(ordinador2);

        OrdinadorLogic logic = new OrdinadorLogic();

        String jsonOrdinador = logic.serializeOrdinador(ordinador1);
        logic.writeToFile(FITXER_INDIVIDUAL, jsonOrdinador);

        String jsonOrdinadors = logic.serializeOrdinadors(ordinadors);
        logic.writeToFile(FITXER_LLISTA, jsonOrdinadors);

        String jsonOrdinadorFromFile = logic.readFromFile(FITXER_INDIVIDUAL);
        Ordinador deserializedOrdinador = logic.deserializeOrdinador(jsonOrdinadorFromFile);
        System.out.println("Ordinador deserialitzat des de fitxer:");
        System.out.println(deserializedOrdinador);

        String jsonOrdinadorsFromFile = logic.readFromFile(FITXER_LLISTA);
        List<Ordinador> deserializedOrdinadors = logic.deserializeOrdinadors(jsonOrdinadorsFromFile);
        System.out.println("Llista d'Ordinadors deserialitzada des de fitxer:");
        for (Ordinador ordinador : deserializedOrdinadors) {
            System.out.println(ordinador);
        }
    }
}
