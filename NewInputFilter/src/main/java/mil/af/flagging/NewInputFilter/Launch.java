package main.java.mil.af.flagging.NewInputFilter;

import main.java.mil.af.flagging.NewInputFilter.db.InterceptDAO;

import java.io.IOException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launch {

    public static Logger LOG = Logger.getLogger(Launch.class.getName());
    public static InterceptDAO iDAO;// = new InterceptDAO();

    public static void main(String[] args) {
        Instant start = Instant.now();

        if(args.length < 1) {
            showUsage(); //Need at least DBConfig
            //Could potentially expand to include things like [Number of threads/workers], [Input Format], [Output Format], etc
        }
        try{
            //DatabaseConfiguration dbConfig;
            throw new IOException();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "{0}", ex);
        }

        //Fetch all work to do
        //Somehow split work between runnables
        //For each runnable, run
        //cdl.await()
        //do logging (final records inserted, etc)

        //DatabaseReader - Produces DatabaseRecords
        //InterceptReader - Consumes DataBaseRecords, Produces Intercepts
        //FilterWorker - Consumes Intercepts, Produces FilteredIntercepts
        //InterceptWriter - Consumes FilteredIntercepts, Produces DatabaseUpdates
        //DatabaseWriter - Consumes DataBaseUpdates

        Instant endTime = Instant.now();
    }

    private static void showUsage() {
    }

}
