package br.com.dio.joaooliveira;

public class Cell {
    private int value;
    private final boolean isFixed;

    public Cell() {
        this.value = 0;
        this.isFixed = false;
    }

    public Cell(int value, boolean isFixed) {
        this.value = value;
        this.isFixed = isFixed;
    }

    public boolean isCellValueFixed() {
        return isFixed;
    }

    public void changeValue(int newValue) {
        if(isCellValueFixed()) throw new RuntimeException();
        this.value = newValue;
    }

    public int getValue() {
        return value;
    }
}
