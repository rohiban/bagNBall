package com.rohit.bagNball;

/**
 * Created by rbansal on 26/03/15.
 */
public class TheBag {
    int capacity;
    BallCollection ballsInBag;
    RuleCollection rulesOfBag;

    public TheBag(int noOfBalls){
        this.ballsInBag = new BallCollection(noOfBalls);
        this.capacity = noOfBalls;
        this.rulesOfBag = new RuleCollection();
    }

    public void addRule(Rule rule) {
        this.rulesOfBag.addRule(rule);
    }

    public boolean addBall(Ball theBall) {
        if (this.ballsInBag.size() < this.capacity) {
            if (rulesOfBag.satisfiesRules(this.ballsInBag, theBall)) {
                //System.out.println("Successfully added a " + theBall.toString());
                return ballsInBag.add(theBall);
            } else {
                System.out.println("Failed to add a " + theBall.toString());
                return false;
            }
        } else {
            System.out.println("Bag is full, can't take any more balls ...");
            return false;
        }
    }

    public String toString() {
        // list all balls
        String ballString = "Bag has these balls - \n";
        ballString += this.ballsInBag.toString();

        // list all rules
        String ruleString = "Bag has these rules - \n";
        ruleString += this.rulesOfBag.toString();

        return ballString + ruleString;
    }

    public static void main (String[] args) {
        TheBag myBag = new TheBag(15);

        // set rules for this bag
        myBag.addRule(new MyAssociationRule(Ball.BLACK).canNotBeWith(Ball.BROWN));
        myBag.addRule(new MyAssociationRule(Ball.WHITE).canOnlyBeWith(Ball.YELLOW));
        myBag.addRule(new MyMaxMathRule(Ball.GREEN).max(4));
        myBag.addRule(new MyRelativeMathRule(Ball.RED).cantBeMoreThan(2, Ball.YELLOW));
        myBag.addRule(new MyLonelyRule(Ball.PINK).canNotBeAlone());

        // add few balls to the bag
        myBag.addBall(Ball.PINK);
        myBag.addBall(Ball.BROWN);
        myBag.addBall(Ball.WHITE);
        myBag.addBall(Ball.GREEN);
        myBag.addBall(Ball.YELLOW);
        myBag.addBall(Ball.BLACK);
        myBag.addBall(Ball.GREEN);
        myBag.addBall(Ball.WHITE);
        myBag.addBall(Ball.GREEN);
        myBag.addBall(Ball.RED);
        myBag.addBall(Ball.GREEN);
        myBag.addBall(Ball.RED);
        myBag.addBall(Ball.RED);
        myBag.addBall(Ball.GREEN);
        myBag.addBall(Ball.ORANGE);

        // print contents of the bag
        System.out.println(myBag.toString());
    }
}
