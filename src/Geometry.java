import acm.graphics.GDimension;
import acm.graphics.GPoint;

public class Geometry {

    private final int windowWidth;
    private final int windowHeight;
    private final int numCols;
    private final int numRows;
    private final double boardPadding;
    private final double cellPadding;

    public Geometry(int windowWidth, int windowHeight, int numCols, int numRows, double boardPadding, double cellPadding) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.numCols = numCols;
        this.numRows = numRows;
        this.boardPadding = boardPadding;
        this.cellPadding = cellPadding;
    }

    public int getRows() {

        return numRows;
    }

    public int getColumns() {

        return numCols;
    }

    public GDimension boardDimension() {

        return new GDimension(windowWidth - windowWidth * (2 * boardPadding) , windowHeight - windowHeight * (2 * boardPadding));
    }

    public GPoint boardTopLeft() {

        return new GPoint(windowWidth * boardPadding , windowHeight * boardPadding);
    }

    public GDimension cellDimension() {
;
        return new GDimension(boardDimension().getWidth() / numCols , boardDimension().getHeight() / numRows);
    }
    //       versió més entendible:
    //       double CellWidth = boardDimension().getWidth() / numCols;
    //       double CellHeight = boardDimension().getHeight() / numRows;
    //       return new GDimension(CellWidth , CellHeight);

    public GPoint cellTopLeft(int x, int y) {

        return new GPoint(boardTopLeft().getX() + x * cellDimension().getWidth() , boardTopLeft().getY() + y * cellDimension().getHeight());
    }

    public GDimension tokenDimension() {

        return new GDimension(cellDimension().getWidth() * (1-2*cellPadding), cellDimension().getHeight() * (1-2*cellPadding));
    }

    public GPoint tokenTopLeft(int x, int y) {

        GPoint CellTopLeft = cellTopLeft(x, y);
        GDimension CellDim = cellDimension();

        double tokenTop = CellTopLeft.getX() + CellDim.getWidth() * cellPadding ;
        double tokenLeft = CellTopLeft.getY() + CellDim.getHeight() * cellPadding;

        return new GPoint(tokenTop, tokenLeft);
    }

    public GPoint centerAt(int x, int y) {

        GPoint CellXY = cellTopLeft(x, y);
        GDimension CellDim = cellDimension();

        double centerX = CellXY.getX() + CellDim.getWidth() /2 ;
        double centerY = CellXY.getY() + CellDim.getHeight() /2;

        return new GPoint(centerX, centerY);
    }

    //Implemented
    public Position xyToCell(double x, double y) {
        GPoint boardTopLeft = boardTopLeft();
        GDimension cellDimension = cellDimension();
        return new Position(
                (int) ((x - boardTopLeft.getX()) / cellDimension.getWidth()),
                (int) ((y - boardTopLeft.getY()) / cellDimension.getHeight()));
    }
}
