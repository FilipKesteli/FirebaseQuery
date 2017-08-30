package com.kesteli.filip.firebasequery;

/**
 * Created by Valemate on 29.8.2017..
 */

public class DinosaurFacts {

    double height;
    double length;
    double weight;
    public DinosaurFacts() {
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }
    public double getHeight() {
        return height;
    }
    public double getLength() {
        return length;
    }
    public double getWeight() {
        return weight;
    }

}
