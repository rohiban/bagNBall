package com.rohit.bagNball;

/**
 * Created by rbansal on 26/03/15.
 */
public class Ball {
    public static Ball RED = new Ball(BallColour.RED);
    public static Ball GREEN = new Ball(BallColour.GREEN);
    public static Ball BLUE = new Ball(BallColour.BLUE);
    public static Ball YELLOW = new Ball(BallColour.YELLOW);
    public static Ball BLACK = new Ball(BallColour.BLACK);
    public static Ball BROWN = new Ball(BallColour.BROWN);
    public static Ball WHITE = new Ball(BallColour.WHITE);
    public static Ball ORANGE = new Ball(BallColour.ORANGE);
    public static Ball PINK = new Ball(BallColour.PINK);

    BallColour colour;

    public Ball(BallColour colour) {
        this.colour = colour;
    }

    public BallColour getColour() {
        return this.colour;
    }

    public boolean isSameAs(Ball ball) {
        //return this.colour.isSameAs(ball.getColour());
        return this.colour == ball.getColour();
    }

    public String toString() {
        return this.colour.toString() + " colour ball";
    }
}
