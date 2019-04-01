package com.theLads.spacetrader.model;



/**
 * Interface for our concrete interactors
 */
public abstract class Interactor {

    private final Repository myRepository;

    Interactor(Repository repo) {
        myRepository = repo;
    }

    protected Repository getRepository() {
        return myRepository;
    }

}
