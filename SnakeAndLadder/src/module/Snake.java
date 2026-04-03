package module;

public class Snake extends Jump{

    public Snake(int start, int end) {
        super(start, end);
        if(start<= end){
            throw new IllegalArgumentException("Snake head always be in higher position than tail");
        }
    }

}
