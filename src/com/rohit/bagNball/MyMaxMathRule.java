package com.rohit.bagNball;

import java.util.Iterator;

/**
 * Created by rbansal on 01/04/15.
 */
class MyMaxMathRule implements MaxMathRule {
    int maxCount;
    Ball first;

    public MyMaxMathRule(Ball frameOfRef) {
        this.first = frameOfRef;
        this.maxCount = 0;
    }

    @Override
    public String toString() {
        return "Maximum Rule : There can be maximum of " + this.maxCount + " " + this.first.toString() + "s";
    }

    @Override
    public boolean isApplicableFor(Ball b) {
        if ((this.first == null) || (b == null)) {
            return false;
        } else {
            return this.first.isSameAs(b);
        }
    }

    @Override
    public boolean apply(BallCollection balls, Ball newBall) {
        if (isApplicableFor(newBall)) {
            if (this.maxCount == 0) {
                return false;
            } else {
                // find the number of balls, it the list, of same colour as of newBall
                int ballCount = balls.noOfBallsOf(newBall);
                return (ballCount < this.maxCount);
            }
        }
        return true;
    }

    @Override
    public MaxMathRule max(int count) {
        this.maxCount = count;
        return this;
    }
}
