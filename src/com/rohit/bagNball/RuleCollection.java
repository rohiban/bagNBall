package com.rohit.bagNball;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rbansal on 10/04/15.
 */
public class RuleCollection {
    ArrayList<Rule> rules;

    public RuleCollection() {
        this.rules = new ArrayList<Rule>();
    }

    @Override
    public String toString() {
        String ruleString = "";

        Iterator<Rule> ruleIterator = this.rules.iterator();
        while (ruleIterator.hasNext()) {
            Rule r = ruleIterator.next();
            ruleString += "    " + r.toString() + "\n";
        }
        return ruleString;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public boolean satisfiesRules(BallCollection balls, Ball aBall) {
        Iterator<Rule> ruleIterator = this.rules.iterator();
        while (ruleIterator.hasNext()) {
            Rule r = ruleIterator.next();
            if (!r.apply(balls, aBall)) {
                return false;
            }
        }
        return true;
    }
}
