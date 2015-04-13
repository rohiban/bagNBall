package com.rohit.bagNball;

/**
 * Created by rbansal on 01/04/15.
 */
public class MyAssociationRule implements AssociationRule {

    Ball first;
    Ball second;
    boolean coExist;

    public MyAssociationRule(Ball frameOfRef) {
        this.first = frameOfRef;
        this.second = null;
        coExist = true;
    }

    @Override
    public String toString() {
        if (this.second == null) {
            return "Rule Object not fully formed, yet ...";
        } else {
            String assoc = this.coExist ? "ONLY" : "NOT";
            return "Association Rule : " + this.first.toString() + " can " + assoc + " be with " + this.second.toString();
        }
    }

    @Override
    public boolean isApplicableFor(Ball b) {
        if (this.first == null || this.second == null || b == null) {
            return false;
        } else {
            return  (b.isSameAs(this.first) || b.isSameAs(this.second));
        }
    }

    @Override
    public AssociationRule canNotBeWith(Ball b) {
        this.second = b;
        coExist = false;
        return this;
    }

    @Override
    public AssociationRule canOnlyBeWith(Ball b) {
        this.second = b;
        coExist = true;
        return this;
    }

    @Override
    public boolean apply(BallCollection balls, Ball newBall) {
        boolean colourFound = false;

        if (isApplicableFor(newBall)) {
            if (this.coExist && newBall.isSameAs(this.second)) {
                return true;
            } else {
                Ball colourToSearch;

                // determine which colour to search for
                if (newBall.isSameAs(this.first)) {
                    colourToSearch = this.second;
                } else {
                    colourToSearch = this.first;
                }

                // find if list has the other colour
                colourFound = balls.hasBallOfColour(colourToSearch);

                return colourFound ? this.coExist : !this.coExist;
            }
        }
        return true;
    }
}
