
import java.util.StringTokenizer;

public class Board {
    private final Cell[][] cells;
    private final Display display;
    private final int order;

    private int black;
    private int white;

    public Board(int order, Display display) {
        this.order = order;
        this.cells = new Cell[2 * order][2 * order];
        this.black = 0;
        this.white = 0;
        this.display = display;
        initBoard();
    }

    public Board(int order) {
        this(order, null);
    }

    private void initBoard() {

        for (int row = 0; row < 2*order; row++) {
            for (int colum = 0; colum < 2*order; colum++) {
                cells[row][colum] = Cell.empty();
            }
        }

        int central = order - 1;
        cells[central][central] = Cell.white();
        white++;
    
        if(display != null) display.setWhite(new Position(central, central));
        
        cells[central+1][central+1] = Cell.white();
        white++;
        
        if(display != null) display.setWhite(new Position(central+1, central+1));
        
        cells[central+1][central] = Cell.black();
        black++;
        
        if(display != null) display.setBlack(new Position(central+1, central));
        
        cells[central][central+1] = Cell.black()    ;
        black++;
        
        if(display != null) display.setBlack(new Position(central, central+1));
    }


    public int size() {
        return 2 * order;
    }

    public boolean contains(Position position) {
        int X = position.getRow();
        int Y = position.getColumn();
        return X >= 0 && X < size() && Y >= 0 && Y < size();
    }

    public boolean isEmpty(Position position) {
        if (!contains(position)) return false;
        return cells[position.getRow()][position.getColumn()].isEmpty();
    }

    public boolean isWhite(Position position) {
        if(!contains(position)) return false;
        return cells[position.getRow()][position.getColumn()].isWhite();
    }

    public boolean isBlack(Position position) {
        if(!contains(position)) return false;
        return cells[position.getRow()][position.getColumn()].isBlack();
    }

    public void setWhite(Position position) {
        if(!contains(position) || !isEmpty(position)) return;
        
        cells[position.getRow()][position.getColumn()].setWhite();
        white++;
        
        if (display != null) display.setWhite(position);
    }

    public void setBlack(Position position) {
        if(!contains(position) || !isEmpty(position)) return;
        
        cells[position.getRow()][position.getColumn()].setBlack();
        black++;

        if (display != null) display.setBlack(position);

    }

    public void reverse(Position position) {
        
        if(!contains(position) || isEmpty(position)) return;

        Cell cell = cells[position.getRow()][position.getColumn()];
        boolean colorW = cell.isWhite();
        cell.reverse();

        if(colorW){
            white--;
            black++;
        }
        else {
            white++;
            black--;
        }

        if (display != null){
            if(colorW) display.setBlack(position);
            else display.setWhite(position);
        }

    }

    public void loadBoard(String str) {
        StringTokenizer st = new StringTokenizer(str, "\n");
        int row = 0;
        this.white = 0;
        this.black = 0;
        while (st.hasMoreTokens()) {
            String rowChars = st.nextToken();
            loadRow(this.cells[row], rowChars);
            row += 1;
        }

    }

    private void loadRow(Cell[] cellRow, String rowChars) {
        for (int column = 0; column < cellRow.length; column++) {
            Cell cell = Cell.cellFromChar(rowChars.charAt(column));
            cellRow[column] = cell;
            if (cell.isWhite()) white += 1;
            else if (cell.isBlack()) black += 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        for (Cell[] cell : this.cells) {
            for (Cell value : cell) {
                sb.append(value.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getStatus() {
        return String.format("B:%3d W:%3d", this.black, this.white);
    }
}
