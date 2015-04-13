package com.rohit.bagNball;

/**
 * Created by rbansal on 11/04/15.
 */
public class MyLonelyRule implements LonelyRule {
    Ball ball;
    boolean isLonely;

    public MyLonelyRule(Ball b) {
        this.ball = b;
        this.isLonely = true;
    }

    @Override
    public boolean isApplicableFor(Ball b) {
        if (this.ball == null) {
            return false;
        } else {
            return b.isSameAs(this.ball);
        }
    }

    @Override
    public boolean apply(BallCollection balls, Ball newBall) {
        if (isApplicableFor(newBall)) {
            return this.isLonely ? (balls.size() == 0) : (balls.size() > 0);
        } else {
            return true;
        }
    }

    @Override
    public LonelyRule canNotBeAlone() {
        this.isLonely = false;
        return this;
    }

    @Override
    public LonelyRule canOnlyBeAlone() {
        this.isLonely = true;
        return this;
    }

    @Override
    public String toString() {
        String s = isLonely ? " is a LONELY ball" : " HAS to have some company";
        return "Lonely Rule: " + this.ball.toString() + s;
    }
}
