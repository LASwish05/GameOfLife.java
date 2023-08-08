import java.util.HashMap;
import java.util.Map;

public class hashMapUebungen {
    public static void main(String[] args) {

        HashMap<String, Integer> empIds = new HashMap();

        empIds.put("Alex", 100);
        empIds.put("Carl", 101);
        empIds.put("Jerry", 102);
        System.out.println(empIds);

        System.out.println(empIds.get("Carl"));

        System.out.println(empIds.containsKey("Jerry"));
        System.out.println(empIds.containsKey("George"));

        System.out.println(empIds.containsValue(100));
        System.out.println(empIds.containsValue(109));

        empIds.put("Jerry", 103);       //put erzeugt oder ändert wenn schon vorhanden
        System.out.println(empIds);
        empIds.replace("Jerry", 104);   //wenn Jerry nicht existieren würde, würde nichts passieren
        System.out.println(empIds);

        empIds.putIfAbsent("Carl", 115);    //passiert nichts da nur erstellt würde, wenn es Carl nochnicht geben würde
        System.out.println(empIds);
        empIds.putIfAbsent("Steve", 200);
        System.out.println(empIds);

        empIds.remove("Steve");
        System.out.println(empIds);

        Map map = new HashMap<>();
        map.put("Apfel", 0.05);
        map.put(true, 123);
        //(Key, Value)
        System.out.println(map.get("Apfel"));
        System.out.println(map.get(true));

    }
}
