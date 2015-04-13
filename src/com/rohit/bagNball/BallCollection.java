package com.rohit.bagNball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rbansal on 09/04/15.
 */
public class BallCollection {
    List<Ball> balls;
    int maxCount;

    public BallCollection (int max) {
        this.balls = new ArrayList<Ball>();
        this.maxCount = max;
    }

    public int size() {
        return this.balls.size();
    }

    public String toString() {
        String ballString = "";

        Iterator<Ball> ballIterator = this.balls.iterator();
        while (ballIterator.hasNext()) {
            Ball b = ballIterator.next();
            ballString += "    " + b.toString() + "\n";
        }
        return ballString;
    }

    public boolean add(Ball b) {
        if (this.balls.size() < this.maxCount) {
            this.balls.add(b);
            return true;
        } else {
            //System.out.println("Bag is full, can't take any more balls ...");
            return false;
        }
    }

    public boolean hasBallOfColour(Ball ball) {
        Iterator<Ball> ballIterator = this.balls.iterator();
        while (ballIterator.hasNext()) {
            Ball b = ballIterator.next();
            if (b.isSameAs(ball)) {
                return true;
            }
        }
        return false;
    }

    public int noOfBallsOf(Ball ball) {
        int count = 0;
        Iterator<Ball> ballIterator = this.balls.iterator();
        while (ballIterator.hasNext()) {
            Ball b = ballIterator.next();
            if (b.isSameAs(ball)) {
                count++;
            }
        }
        return count;
    }
}
