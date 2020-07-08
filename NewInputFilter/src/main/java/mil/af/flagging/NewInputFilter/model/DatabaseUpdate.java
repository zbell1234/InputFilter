package main.java.mil.af.flagging.NewInputFilter.model;

import java.sql.Timestamp;

public class DatabaseUpdate {

    private long interceptID;
    private Timestamp ts;
    private String status;

    public DatabaseUpdate(long interceptID, Timestamp ts, String status) {
        this.interceptID = interceptID;
        this.ts = ts;
        this.status = status;
    }

    public long getInterceptID() {
        return interceptID;
    }

    public void setInterceptID(long interceptID) {
        this.interceptID = interceptID;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static DatabaseUpdate from(FilteredIntercept fInt) {
        return new DatabaseUpdate(fInt.getInterceptID(), fInt.getTs(), fInt.getStatus());
    }
}
