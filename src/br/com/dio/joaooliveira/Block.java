package br.com.dio.joaooliveira;

public class Block {
    private final int SIZE = 3;
    Cell[][] cells = new Cell[3][3];

    public Block() {
        for(int r = 0; r < SIZE; r++) {
            for(int c = 0; c < SIZE; c++) {
                cells[r][c] = new Cell();
            }
        }
    }

    public void insert(int row, int column, int value) {
        cells[row][column].changeValue(value);
    }

    boolean isValuePresentInRow(int row, int value) {
        for(int i = 0; i < 3; i++) {
            if(cells[row][i].getValue() == value) return true;
        }

        return false;
    }

    boolean isValuePresentInColumn(int column, int value) {
        for(int i = 0; i < 3; i++) {
            if(cells[i][column].getValue() == value) return true;
        }

        return false;
    }

    boolean contains(int value) {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(cells[r][c].getValue() == value) return true;
            }
        }

        return false;
    } 
}
