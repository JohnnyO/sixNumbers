package org.github.johnnyo.sixNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    private int solution;
    private int[] inputs;

    public Solver(int solution, int[] inputs) {
        this.solution = solution;
        this.inputs = inputs;
    }

    public String solve() {
        List<Node> nodes = new ArrayList<Node>();
        for (int number : inputs) {
            nodes.add(new Node.Primitive(number));
        }
        return recursiveSolve(nodes, solution).prettyPrint();
    }

    public Node recursiveSolve(List<Node> nodes, int solution) {

        for (Node node : nodes) {
            if (node.getValue() == solution) {
                return node;
            }
        }

        if (nodes.size() <= 1)
            return null;

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                List<Node> subset = new ArrayList<Node>(nodes.size());
                for (Node node : nodes) {
                    subset.add(node);
                }
                Node first = subset.get(i);
                Node second = subset.get(j);

                subset.remove(first);
                subset.remove(second);

                Node result = null;

                Node addition = new Node.Composite(first, second, Operation.ADDITION);
                subset.add(addition);
                result = recursiveSolve(subset, solution);
                if (result != null)
                    return result;

                subset.remove(addition);
                addition = new Node.Composite(first, second, Operation.MULTIPLICATION);
                subset.add(addition);

                result = recursiveSolve(subset, solution);
                if (result != null)
                    return result;

                subset.remove(addition);
                addition = new Node.Composite(first, second, Operation.SUBTRACTION);
                subset.add(addition);

                result = recursiveSolve(subset, solution);
                if (result != null)
                    return result;
            }
        }
        return null;
    }
    
    public static void main(String [] args) {
        Solver solver = new Solver(214, new int [] {6,7,10,6,10,9});
        System.out.println(solver.solve());
    }
    

}
