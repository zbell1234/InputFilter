package main.java.mil.af.flagging.NewInputFilter.Workflow;

import java.sql.Connection;
import java.util.ArrayList;
import main.java.mil.af.flagging.NewInputFilter.Interfaces.IProducer;
import main.java.mil.af.flagging.NewInputFilter.db.InterceptDAO;
import main.java.mil.af.flagging.NewInputFilter.model.DatabaseRecord;

import java.util.concurrent.ArrayBlockingQueue;

public class DatabaseReader implements IProducer<DatabaseRecord> {

    private ArrayBlockingQueue<DatabaseRecord> queue;
    private InterceptDAO dao;
    private ArrayList<Long> IDs;
    private ArrayList<DatabaseRecord> buffer;
    private Connection conn;

    @Override
    public DatabaseRecord produce() {
        Long ID = IDs.get(0);
        IDs.remove(ID);
        
        return null;
    }

    public DatabaseReader(ArrayBlockingQueue<DatabaseRecord> queue, InterceptDAO dao, Connection conn) {
        this.queue = queue;
        this.dao = dao;
        this.conn = conn;
    }
    
    public void run() {
        IDs = dao.getInterceptIDs(conn);
        while(!IDs.isEmpty()) {
            DatabaseRecord dbr = produce();
            if(!buffer.isEmpty()) {
                queue.addAll(buffer);
            }
        }
    }
}
