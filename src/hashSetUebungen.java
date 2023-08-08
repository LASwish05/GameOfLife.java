import java.util.*;

public class hashSetUebungen {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();        //würde man TreeSet benutzen würde die natürliche Ordnung natural order haben, bei String also alphabetisch
                                                    //LinkedHashSet behält die Reihenfolge in der geaddet wurde bei
        names.add("Alex");
        names.add("Lebron");
        names.add("Michael");
        names.add("Kevin");
        names.add("Alex");
        names.add("Kyrie");

        names.remove("Kevin");          //entfernen
        //names.clear();                    //entfernt alles

        //System.out.println(names);
        System.out.println(names.size());      //Größe des Sets
        System.out.println(names.contains("Michael"));
        System.out.println(names.isEmpty());

        for (String name : names) {             //loop through the set
            System.out.println(name);
        }

        //Lambda
        //System.out.println();
        //names.forEach(System.out::println);         //in Klammern Befehl was mit aller(forEach) gemacht werden soll

        System.out.println();
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        //Set können z.b. verwendet werden um duplikate aus einer Liste zu bekommen/entfernen
        System.out.println();
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(1);
        numberList.add(2);
        numberList.add(4);
        numberList.add(5);
        System.out.println(numberList);
        Set<Integer> numberSet = new HashSet<>();           //Set<Integer> numberSet = new HashSet<>(numberList);
        numberSet.addAll(numberList);                       //dann braucht man diese Zeile nicht mehr
        System.out.println(numberSet);

    }
}
