package com.rohit.bagNball;

/**
 * Created by rbansal on 11/04/15.
 */
public interface LonelyRule extends Rule {
    public LonelyRule canNotBeAlone();
    public LonelyRule canOnlyBeAlone();
}
