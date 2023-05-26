package org.talentwunder.spyrobot.model;

public enum Heading {
    N, W, E, S;

    static {
        N.left = W;
        N.right = E;
        W.left = S;
        W.right = N;
        E.left = N;
        E.right = S;
        S.left = E;
        S.right = W;
    }
    Heading left;
    Heading right;

    public Heading getLeft(){
        return left;
    }
    public Heading getRight(){
        return right;
    }

}
