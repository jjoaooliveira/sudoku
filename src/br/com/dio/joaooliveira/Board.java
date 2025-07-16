package br.com.dio.joaooliveira;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Board {
    private final int SIZE = 3;
    private List<List<Block>> blocks;

    public Board() {
        init();
    }

    public void insert(int row, int column, int value) {
        Block block = blockResolution(row, column);
        block.insert(row, column, value);
    }

    private void init() {
        for(int r = 0; r < SIZE; r++) {
            List<Block> blockList = Stream.generate(Block::new).limit(SIZE).toList();
            blocks.add(blockList);
        }
        fillBlock();
    }

    private boolean isValueValid(int row, int column, int value) {
        for(int c = 0; c < SIZE; c++) { // itera linha
            if(blockResolution(row, c).isValuePresentInRow(row, value)) return false;
        }

        for(int r = 0; r < SIZE; r++) { // itera coluna
            if(blockResolution(r, column).isValuePresentInColumn(column, value)) return false;
        }

        if(blockResolution(row, column).contains(value)) return false;

        return true;
    }

    private void fillBlock() {
        Random random = new Random();
        int i = 0;
        
        while (i < 9) {
            var randomRow = random.nextInt(9);
            var randomColumn = random.nextInt(9);
            var randomValue = random.nextInt(9);
            
            if(isValueValid(randomRow, randomColumn, randomValue)) {
                Block block = blockResolution(randomRow, randomColumn);
                block.insert(randomRow, randomColumn, randomValue);
                i++;
            }
            continue;
        }
    }

    private Block blockResolution(int row, int column) {
        List<Block> blockLine = null;
        Block block = null;
        
        switch (row) {
            case 1, 2, 3:
                blockLine = blocks.get(0);
                break;

            case 4, 5, 6:
                blockLine = blocks.get(1);
                break;
                
            case 7, 8, 9:
                blockLine = blocks.get(2);
                break;
        
            default:
                blockLine = null;
                break;
        }

        switch (column) {
            case 1, 2, 3:
                block = blockLine.get(0);
                break;

            case 4, 5, 6:
                block = blockLine.get(1);
                break;
                
            case 7, 8, 9:
                block = blockLine.get(2);
                break;
        
            default:
                block = null;
                break;
        }

        return block;
    }
}
