package lld.snakeladder;

public abstract class Jump {
    int fromIndex;
    int toIndex;
    abstract void createJump(int cellPos);
}
