package main.java.mil.af.flagging.NewInputFilter.Workflow;

import main.java.mil.af.flagging.NewInputFilter.Interfaces.IConsumer;
import main.java.mil.af.flagging.NewInputFilter.Interfaces.IProducer;
import main.java.mil.af.flagging.NewInputFilter.model.DatabaseUpdate;
import main.java.mil.af.flagging.NewInputFilter.model.FilteredIntercept;

public class InterceptWriter implements IProducer<DatabaseUpdate>, IConsumer<FilteredIntercept> {

    @Override
    public void consume(FilteredIntercept filteredIntercept) {

    }

    @Override
    public DatabaseUpdate produce() {
        return null;
    }
}
