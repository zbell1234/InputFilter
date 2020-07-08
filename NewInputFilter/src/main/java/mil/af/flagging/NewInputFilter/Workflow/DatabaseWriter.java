package main.java.mil.af.flagging.NewInputFilter.Workflow;

import main.java.mil.af.flagging.NewInputFilter.Interfaces.IConsumer;
import main.java.mil.af.flagging.NewInputFilter.db.InterceptDAO;
import main.java.mil.af.flagging.NewInputFilter.model.DatabaseUpdate;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;

public class DatabaseWriter implements IConsumer<DatabaseUpdate> {

    private ArrayBlockingQueue<DatabaseUpdate> queue;
    private InterceptDAO dao;
    private Connection conn;

    public DatabaseWriter(ArrayBlockingQueue<DatabaseUpdate> queue, InterceptDAO dao, Connection conn) {
        this.queue = queue;
        this.dao = dao;
        this.conn = conn;
    }

    @Override
    public void consume(DatabaseUpdate databaseUpdate) {
        queue.add(databaseUpdate);
    }

    public void post() {

    }
}
