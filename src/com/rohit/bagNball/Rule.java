package com.rohit.bagNball;

import java.util.List;

/**
 * Created by rbansal on 26/03/15.
 */
interface Rule {
    public boolean apply(BallCollection balls, Ball newBall);
    public boolean isApplicableFor(Ball b);
}
