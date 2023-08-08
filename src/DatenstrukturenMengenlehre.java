import java.util.*;

public class DatenstrukturenMengenlehre {
    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(3);
        a.add(5);
        //Set<Integer> b = Set.of(3, 5, 7); //so kann das Set nicht mehr verändert werden.
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 5, 7, 11));
        Set<Integer> c = new HashSet<>(Arrays.asList(5, 7, 9));

        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("C = " + c);

        //Vereinigungsmenge
        Set<Integer> union = unionAmmount(a, b, c);
        System.out.println("Vereinigungsmenge: " + union);
        System.out.println();

        //Schnittmenge A B C
        Set<Integer> cross = intersections(a, b, c);
        System.out.println("Schnittmenge: " + cross);

        //Schnittmenge A B
        Set<Integer> crossAB = new HashSet<>(a);
        crossAB.retainAll(b);
        System.out.println("A ∩ B: " + crossAB);
        //Schnittmenge A C
        Set<Integer> crossAC = new HashSet<>(a);
        crossAC.retainAll(c);
        System.out.println("A ∩ C: " + crossAC);
        //Schnittmenge C B
        Set<Integer> crossCB = new HashSet<>(c);
        crossCB.retainAll(b);
        System.out.println("C ∩ B: " + crossCB);
        System.out.println();

        //Differenzmengenmöglichkeiten A B C
        Set<Integer> difference = differenceQuantity(a, b, c);
        System.out.println("Differenzmenge a: " + difference);
        Set<Integer> differenceb = differenceQuantityb(a, b, c);
        Set<Integer> differencebalternative = differenceQuantity(b, a, c);
        Set<Integer> diffShort = getDifference(getDifference(b, a), c);
        System.out.println("Differenzmenge b: " + differenceb);
        System.out.println("Differenzmenge b with 3 changed parameters: " + differencebalternative);
        System.out.println("Differenzmenge b with 2 methods: " + diffShort);
        Set<Integer> differencec = differenceQuantityc(a, b, c);
        System.out.println("Differenzmenge c: " + differencec);
        //Differenzmenge A B (B A wäre auch noch möglich)
        Set<Integer> differenceAB = new HashSet<>(a);
        differenceAB.removeAll(b);
        System.out.println("A ohne B: " + differenceAB);
        //Differenzmenge A C (C A wäre auch möglich)
        Set<Integer> differenceAC = new HashSet<>(a);
        differenceAB.removeAll(c);
        System.out.println("A ohne C: " + differenceAC);
        //Differenzmenge C B (B C wäre auch möglich
        Set<Integer> differenceCB = new HashSet<>(c);
        differenceAB.removeAll(b);
        System.out.println("C ohne B: " + differenceCB);
        System.out.println();

        //Vereinigung und Schnittmengen Mix
        System.out.println("A u (B ∩ C): " + getUnion(a, getintersection(b, c)));
        System.out.println("B u (A ∩ C): " + getUnion(b, getintersection(a, c)));
        System.out.println("C u (A ∩ B): " + getUnion(c, getintersection(a, b)));
        System.out.println("(A u B) ∩ C: " + getintersection(getUnion(a, b), c));
        System.out.println("(A u C) ∩ B: " + getintersection(getUnion(a, c), b));
        System.out.println("(B u C) ∩ A: " + getintersection(getUnion(b, c), a));


    }

    public static Set<Integer> unionAmmount(Set<Integer> a, Set<Integer> b, Set<Integer> c) {   //Vereinigungsmenge
        Set<Integer> union  = new HashSet<>();
        union.addAll(a);
        System.out.println(union);
        union.addAll(b);
        System.out.println(union);
        union.addAll(c);
        return union;
    }

    public static Set<Integer> intersections(Set<Integer> a, Set<Integer> b, Set<Integer> c) {  //Schnittmenge
        Set<Integer> cross = new HashSet<>(a);
        System.out.println(cross);
        cross.retainAll(b);
        System.out.println(cross);
        cross.retainAll(c);
        return cross;
    }

    /**
     * subtracts all values of b from a
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static Set<Integer> differenceQuantity(Set<Integer> a, Set<Integer> b, Set<Integer> c) {     //Differenzmenge
        Set<Integer> difference = new HashSet<>(a);
        System.out.println(difference);
        difference.removeAll(b);
        System.out.println(difference);
        difference.removeAll(c);
        return difference;
    }
    public static Set<Integer> differenceQuantityb(Set<Integer> a, Set<Integer> b, Set<Integer> c) {     //Differenzmenge
        Set<Integer> difference = new HashSet<>(b);
        System.out.println(difference);
        difference.removeAll(a);
        System.out.println(difference);
        difference.removeAll(c);
        return difference;
    }
    public static Set<Integer> differenceQuantityc(Set<Integer> a, Set<Integer> b, Set<Integer> c) {     //Differenzmenge
        Set<Integer> difference = new HashSet<>(c);
        System.out.println(difference);
        difference.removeAll(a);
        System.out.println(difference);
        difference.removeAll(b);
        return difference;
    }
    //Methoden für Vereinigung und Schnittmengen Mix
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
    public static Set<Integer> getintersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static Set<Integer> getDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

}
