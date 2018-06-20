package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return isWinner(true);
    }

    public boolean isWinnerO() {
        return isWinner(false);
    }

    public boolean isWinner(boolean checCell) {
        boolean result = false;
        for (int i = 0; i != table.length; i++) {
            for (int j = 0; j != table.length; j++) {
                if (table[table.length - 1][0] == table[table.length - 1][i] || table[0][table.length - 1] == table[j][table.length - 1] || table[0][table.length - 2] == table[i][table.length - 2] || table[table.length - 2][0] == table[table.length - 2][j] || table[0][0] == table[table.length - 1 - i][0] || table[0][0] == table[0][table.length - 1 - i] || table[0][0] == table[table.length - 1 - j][table.length - 1 - j] || table[0][table.length - 1] == table[i][table.length - 1 - i]) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i != table.length; i++) {
            for (int j = 0; j != table.length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    result = true;
                }
            }
        }
        return result;
    }

}
