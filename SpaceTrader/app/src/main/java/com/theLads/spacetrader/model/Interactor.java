package com.theLads.spacetrader.model;



/**
 * Interface for our concrete interactors
 */
abstract class Interactor {

    private final Repository myRepository;

    /**
     * Interactor constructor that uses passed in repository
     * @param repo repository passed in
     */
    Interactor(Repository repo) {
        myRepository = repo;
    }

    /**
     * Returns the Repository associated wth with an Interactor
     * @return the Repository associated wth with an Interactor
     */
    Repository getRepository() {
        return myRepository;
    }

}
