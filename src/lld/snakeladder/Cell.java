package lld.snakeladder;

public class Cell {
    private int position;
    private Jump jump;

    public Cell(int position) {
        this.position = position;
        this.jump = null;
    }

    void addSnake() throws Exception {
        if (jump == null) {
            jump = new Snake(position);
        } else {
            throw new Exception("SNAKE ::: Already a jump configured");
        }
    }

    void addLadder() throws Exception {
        if (jump == null) {
            jump = new Ladder(position);
        } else {
            throw new Exception("LADDER ::: Already a jump configured");
        }
    }

    public boolean hasJump() {
        return jump != null;
    }

    public int jumpToPosition() throws Exception {
        if(hasJump())
        {
            return jump.toIndex;
        }
        else
        {
            throw new Exception("ERROR :::::::: No jump configured for this cell :::::::: ");
        }
    }
}
