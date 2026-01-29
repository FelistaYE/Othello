

public class Cell {

    private static final char WHITE = 'w';
    private static final char BLACK = 'b';
    private static final char EMPTY = '·';

    private char state;

    private Cell(char state) {
        this.state = state;
    }

    public static Cell empty() {

        return new Cell(EMPTY);
    }

    public static Cell white() {

        return new Cell(WHITE);
    }

    public static Cell black() {

        return new Cell(BLACK);
    }

    public boolean isEmpty() {

        return state == EMPTY;
    }

    public boolean isWhite() {

        return state == WHITE;
    }

    public boolean isBlack() {

        return state == BLACK;
    }

    public void setWhite() {
        state = WHITE;
    }

    public void setBlack() {
        state = BLACK;
    }

    public void reverse() {
        if(state == EMPTY) state = EMPTY;
        else if(state == WHITE) state = BLACK;
        else if(state == BLACK) state = WHITE;
    }

    public String toString() {
        return String.valueOf(this.state);
    }

    public static Cell cellFromChar(char c) {
        return switch (c) {
            case 'w' -> white();
            case 'b' -> black();
            default -> empty();
        };
    }
}
