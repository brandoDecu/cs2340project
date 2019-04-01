package com.theLads.spacetrader.model;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all the interactors for the application.
 *
 */

public class Model {
//    Model is a facade so that UI knows nothing about the backend

    public final static String DEFAULT_BINARY_FILE_NAME = "data.bin";

    /** the data repository */
    private Repository myRepository;

    private Map<String, Object> interactorMap;

    private static  Model instance = new Model();

    public static Model getInstance() { return instance; }



    /**
     * Make a new Model instance
     */
    private Model() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    private void registerInteractors() {
        interactorMap.put("Game", new GameInteractor(myRepository));
    }


    public GameInteractor getGameInteractor() {
        return (GameInteractor) interactorMap.get("Game");
    }


    /**
     * Load Binary Repository
     * @param file the binary file
     * @return success
     */
    public boolean loadBinaryRepository(File file) {
        boolean success = true;
        try {
            /*
              To read, we must use the ObjectInputStream since we want to read our model in with
              a single read.
             */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            myRepository = (Repository) in.readObject();
            registerInteractors();
            in.close();
        } catch (IOException e) {
            Log.e("Model", "Error reading an entry from binary file",e);
            success = false;
        } catch (ClassNotFoundException e) {
            Log.e("Model", "Error casting a class from the binary file",e);
            success = false;
        }
       // if (myRepository == null || myRepository.getCurrentGame().getPlayer().getName() == null) {
        //    success = false;
       // } else {
        //    Log.d("Model", myRepository.getCurrentGame().getPlayer().getName());
        //}
        Log.d("Model", "hello");


        return success;
    }


    /**
     * Save Repository
     * @param file the binary file
     * @return success
     */
    public boolean saveBinaryRepository(File file) {
        boolean success = true;
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.

               We have to use an ObjectOutputStream to write objects.

               One thing to be careful of:  You cannot serialize static data.
             */


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out.writeObject(myRepository);
            out.close();

        } catch (IOException e) {
            Log.e("Model", "Error writing an entry from binary file",e);
            success = false;
        }
        return success;
    }


}
