package org.github.johnnyo.sixNumbers;

public interface Node {

    public int getValue();

    public String prettyPrint();

    public static class Primitive implements Node {

        private final int value;

        public Primitive(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public String prettyPrint() {
            return Integer.toString(value);
        }
    }

    public static class Composite implements Node {
        private final Node first;
        private final Node second;
        private Operation operation;

        public Composite(Node first, Node second, Operation operation) {
            this.first = first;
            this.second = second;
            this.operation = operation;

        }

        @Override
        public int getValue() {
            // TODO Auto-generated method stub
            return operation.result(first.getValue(), second.getValue());
        }

        @Override
        public String prettyPrint() {
            if (first.getValue() > second.getValue()) {
                return "(" + first.prettyPrint() + " " + operation.print() + " " + second.prettyPrint() + ")";
            } else {
                return "(" + second.prettyPrint() + " " + operation.print() + " " + first.prettyPrint() + ")";
            }
        }

    }

}
