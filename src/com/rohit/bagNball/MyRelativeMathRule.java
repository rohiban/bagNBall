package com.rohit.bagNball;

import java.util.Iterator;
import java.util.List;

/**
 * Created by rbansal on 03/04/15.
 */
public class MyRelativeMathRule implements RelativeMathRule {
    Ball first;
    Ball comparedTo;
    int times;

    public MyRelativeMathRule(Ball frameOfRef) {
        this.first = frameOfRef;
        this.comparedTo = null;
        times = 0;
    }

    @Override
    public String toString() {
        if (this.comparedTo == null) {
            return "This Rule object has not been fully formed yet ... ";
        } else {
            return "Relative Number Rule : " + this.first.toString() + "s can NOT be more than " + this.times + " times of " + this.comparedTo.toString() + "s";
        }
    }

    @Override
    public boolean isApplicableFor(Ball b) {
        if ((this.first == null) || (b == null)) {
            return false;
        } else {
            return this.first.isSameAs(b);
        }
    }

//    int noOfBallsOfColour(List<Ball> balls, BallColour bc) {
//        int ballCount = 0;
//
//        Iterator<Ball> ballIterator = balls.iterator();
//        while (ballIterator.hasNext()) {
//            Ball ballOfList = ballIterator.next();
//            if (ballOfList.getColour().isSameAs(bc)) {
//                ballCount++;
//            }
//        }
//        return ballCount;
//    }

    @Override
    public boolean apply(BallCollection balls, Ball newBall) {
        if (isApplicableFor(newBall)) {
            // find the number of balls, in the list, which have same colour as newBall
            int newColourCount = balls.noOfBallsOf(newBall);

            // find the number of balls, in the list, which have same colour as comparedTo
            int compareToCount = balls.noOfBallsOf(this.comparedTo);

            return newColourCount < (times * compareToCount);
        }
        return true;
    }

    @Override
    public RelativeMathRule cantBeMoreThan(int times, Ball b) {
        this.comparedTo = b;
        this.times = times;
        return this;
    }
}
