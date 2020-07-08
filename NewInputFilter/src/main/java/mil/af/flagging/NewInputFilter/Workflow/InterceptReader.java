package main.java.mil.af.flagging.NewInputFilter.Workflow;

import main.java.mil.af.flagging.NewInputFilter.Interfaces.IConsumer;
import main.java.mil.af.flagging.NewInputFilter.Interfaces.IProducer;
import main.java.mil.af.flagging.NewInputFilter.model.Intercept;
import main.java.mil.af.flagging.NewInputFilter.model.DatabaseRecord;
import java.util.ArrayList;

public class InterceptReader implements IProducer<Intercept>, IConsumer<DatabaseRecord> {

    private ArrayList<DatabaseRecord> records;
    private ArrayList<Intercept> intercepts;

    @Override
    public Intercept produce() {
        return Intercept.from(records.get(0));
    }

    @Override
    public void consume(DatabaseRecord databaseRecord) {
        records.add(databaseRecord);
    }

    public void post(Intercept i) {
        intercepts.add(i);
    }

    public ArrayList<Intercept> getIntercepts() {
        return this.intercepts;
    }
}
