import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Opp1ArrayListChallenge2TREE {
    int leaves;
    int id;

    public Opp1ArrayListChallenge2TREE (int leaves, int id) {
        this.leaves = leaves;
        this.id = id;
    }

    public static void main(String[] args) {
        List<Opp1ArrayListChallenge2TREE> trees = new ArrayList<>();
        Random r = new Random();
        int totalLeaves = 0;
        int maxLeaves = 0;
        Opp1ArrayListChallenge2TREE treeWithMaxLeaves = null;

        for (int i = 0; i < 100; i++) {
            int leaves = r.nextInt(101);
            int id = i + 1;
            Opp1ArrayListChallenge2TREE tree = new Opp1ArrayListChallenge2TREE (leaves, id);
            trees.add(tree);
            totalLeaves += leaves;

            if (leaves > maxLeaves){
                maxLeaves = leaves;
                treeWithMaxLeaves = tree;
            }
        }
        for (Opp1ArrayListChallenge2TREE t : trees) {
            System.out.println("ID:" + t.id + " Blätter: " + t.leaves);
        }
        System.out.println("Gesamtzahl der Blätter: " + totalLeaves);
        System.out.println("Baum " + treeWithMaxLeaves.id + " hat " + maxLeaves + " Blätter.");
    }

}
