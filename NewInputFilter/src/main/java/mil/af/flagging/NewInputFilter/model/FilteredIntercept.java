package main.java.mil.af.flagging.NewInputFilter.model;

import java.sql.Timestamp;

public class FilteredIntercept {

    private final long interceptID;
    private final Timestamp ts;
    private final String status;

    public FilteredIntercept(long interceptID, Timestamp ts, String status) {
        this.interceptID = interceptID;
        this.ts = ts;
        this.status = status;
    }

    public FilteredIntercept(long interceptID, Timestamp ts) {
        this.interceptID = interceptID;
        this.ts = ts;
        this.status = "ASSOC-REQ";
    }

    public long getInterceptID() {
        return interceptID;
    }

    public Timestamp getTs() {
        return ts;
    }

    public String getStatus() {
        return status;
    }

    public static FilteredIntercept from(Intercept intercept) {
        return new FilteredIntercept(intercept.getInterceptID(), intercept.getTimeStamp());
    }
}
