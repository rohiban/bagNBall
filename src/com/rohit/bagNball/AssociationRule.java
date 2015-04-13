package com.rohit.bagNball;

/**
 * Created by rbansal on 01/04/15.
 */
public interface AssociationRule extends Rule {
    public AssociationRule canNotBeWith(Ball b);
    public AssociationRule canOnlyBeWith(Ball b);
}
