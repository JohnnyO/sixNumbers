package org.github.johnnyo.sixNumbers;

public enum Operation {
    
    
    ADDITION("+") {

        @Override
        public int result(int x, int y) {
            return x + y;
        }

        @Override
        public boolean isValid(int x, int y) {
            return true;
        }

    },
    SUBTRACTION("-"){

        @Override
        public int result(int x, int y) {
            return Math.abs(x - y);
        }

        @Override
        public boolean isValid(int x, int y) {
            return true;
        }
        
    },
    MULTIPLICATION("*") {
        @Override
        public int result(int x, int y) {
            return x*y;
        }

        @Override
        public boolean isValid(int x, int y) {
            return true;
        }
        
    },
    DIVISION("/") {

        @Override
        public int result(int x, int y) {
            if (x % y == 0) {
                return x / y;
            } else {
                return y / x;
            }
        }

        @Override
        public boolean isValid(int x, int y) {
            return (x % y == 0 || y %x == 0);
        }
        
    };
    private final String symbol;
    
    
    private Operation(String symbol) {
        this.symbol = symbol;
    }
    
    public abstract int result(int x, int y);
    
    public abstract boolean isValid(int x, int y);

    public String print() {
        return symbol;
    }

}


