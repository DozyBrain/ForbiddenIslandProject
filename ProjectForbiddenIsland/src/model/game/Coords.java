package model.game;

public class Coords {

	private int x;
	private int y;

        public Coords (int x, int y) {
            setX(x);
            setY(y);
        }
        

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    public void show() {
            System.out.println("x" +this.getX());
            System.out.println("y" +this.getY());
    }

}