
public class Game {

    private final Board board;
    private State state;

    public Game(Board board) {
        this.board = board;
        // Suponemos que el jugador con las fichas negras puede hacer la primera jugada
        // (es decir, el tablero es de orden como mínimo 2)
        this.state = State.BLACK;
    }

    public boolean isFinished() {

        return state == State.FINISHED;
    }

    public boolean isSame(State player, Position position) {
        if (player == State.WHITE) return board.isWhite(position);
        else if(player == State.BLACK) return board.isBlack(position);
        return false;
    }

    public boolean isOther(State player, Position position) {
        if (player == State.WHITE) return board.isBlack(position);
        else if (player == State.BLACK) return board.isWhite(position);
        return false;
    }

    public boolean someSame(State player, Position position, Direction direction) {

        //inicials
        if (!board.contains(position) || board.isEmpty(position)) return false;
        if (isSame(player, position)) return true;


        Position NowPos = position;
        while (true) {
            NowPos = direction.move(NowPos);
            if (!board.contains(NowPos) || board.isEmpty(NowPos)) return false;
            if (isSame(player, NowPos)) return true;
        }
    }

    public boolean isReverseDirection(State player, Position position, Direction direction) {
        Position NextPos = direction.move(position);
        if (!board.contains(NextPos) || !isOther(player,NextPos)) return false;

        return someSame(player,NextPos,direction);
    }

    public boolean[] directionsOfReverse(State player, Position position) {
        boolean[] direction = new boolean[Direction.ALL.length];

        for (int i = 0; i < Direction.ALL.length; i++) {
            direction[i] = isReverseDirection(player,position,Direction.ALL[i]);
        }

        return direction;
    }

    private static boolean allFalse(boolean[] bools) {
        for(int i = 0; i < bools.length; i++) {
            boolean b = bools[i];
            if (b) return false;
        }

        return true;
    }

    public boolean canPlayPosition(State player, Position position) {
        if(!board.isEmpty(position)) return false;
        boolean[] directions = directionsOfReverse(player,position);

        return !allFalse(directions);
    }

    public boolean canPlay(State player) {
        int size = board.size();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Position position = new Position(row, column);
                if (canPlayPosition(player, position))
                    return true;
            }
        }

        return false;
    }


    private void disk(Position position) {
        if(state == State.BLACK) {
            board.setBlack(position);
        }
        else if(state == State.WHITE) {
            board.setWhite(position);
        }
    }

    private void reverse(Position position, Direction direction) {
        Position NowPos = position;
        NowPos = direction.move(NowPos);

        while (!isSame(state,NowPos)) {
            board.reverse(NowPos);
            NowPos = direction.move(NowPos);
        }
    }

    private void reverse(Position position, boolean[] directions) {
        for(int i = 0; i < Direction.ALL.length; i++) {
            if(directions[i]) {
                reverse(position,Direction.ALL[i]);
            }
        }
    }

    private void changeTurn() {
        State player2;
        if(state == State.BLACK) {
            player2 = State.WHITE;
        } else {
            player2 = State.BLACK;
        }

        if (canPlay(player2)) {
            state = player2;
            return;
        } else if(canPlay(state)) return; // jugar una altra vegada
        state = State.FINISHED;
    }

    private State tryPlayer(State player) {
        if (canPlay(player))return player;
        else return State.FINISHED;

    }


    public void move(Position position) {
        if (!this.board.isEmpty(position)) return;
        boolean[] directions = this.directionsOfReverse(this.state, position);
        if (allFalse(directions)) return;
        this.disk(position);
        this.reverse(position, directions);
        this.changeTurn();
    }

    public String getStatus() {
        String move;
        if (this.state == State.FINISHED) {
            move = "FINISHED";
        } else {
            move = (this.state == State.BLACK ? "BLACK" : "WHITE") + " moves";
        }
        return String.format("%s - %s", this.board.getStatus(), move);
    }
}

