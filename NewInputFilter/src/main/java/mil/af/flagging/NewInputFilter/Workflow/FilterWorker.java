package main.java.mil.af.flagging.NewInputFilter.Workflow;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.logging.Logger;

import main.java.mil.af.flagging.NewInputFilter.Interfaces.IConsumer;
import main.java.mil.af.flagging.NewInputFilter.Interfaces.IProducer;
import main.java.mil.af.flagging.NewInputFilter.model.FilteredIntercept;
import main.java.mil.af.flagging.NewInputFilter.model.Intercept;

public class FilterWorker implements Runnable, IProducer<FilteredIntercept>, IConsumer<Intercept> {

    private static final Logger LOG = Logger.getLogger(FilterWorker.class.getName());

    private final DataSource ds;
    private final int workerID;
    private ArrayList<Intercept> workQueue = new ArrayList<>();

    public FilterWorker(DataSource ds, int workerID) {
        this.ds = ds;
        this.workerID = workerID;
    }

    @Override
    public void run() {
        //do stuff
        //getWork(workerID, count)
        //processWork()
        //postWork(results)
        //cleanIDB()
    }

    public ArrayList<Intercept> getWork() {
        ArrayList<Intercept> ret = new ArrayList<>();

        return ret;
    }

    @Override
    public FilteredIntercept produce() {
        return null;
    }

    @Override
    public void consume(Intercept intercept) {

    }
    
    private boolean elnotFilter(Intercept intercept) {
        return false;
    }
}
