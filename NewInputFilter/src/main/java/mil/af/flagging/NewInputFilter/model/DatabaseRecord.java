package main.java.mil.af.flagging.NewInputFilter.model;

import java.sql.Timestamp;

public class DatabaseRecord {
    private long interceptID;
    private String elnot;
    private String modTypeDesc;
    private String countryCode;
    private String rdOutStat;
    private long numBursts;
    private Timestamp timeStamp;

    public DatabaseRecord() {
        this.interceptID = -1;
        this.elnot = "";
        this.modTypeDesc = "";
        this.countryCode = "";
        this.rdOutStat = "";
        this.numBursts = -1;
        this.timeStamp = Timestamp.valueOf("");
    }
    
    public DatabaseRecord(long interceptID, String elnot, String modTypeDesc, String countryCode, String rdOutStat, long numBursts, Timestamp ts){
        this.interceptID = interceptID;
        this.elnot = elnot;
        this.modTypeDesc = modTypeDesc;
        this.countryCode = countryCode;
        this.rdOutStat = rdOutStat;
        this.numBursts = numBursts;
        this.timeStamp = ts;
    }

    public long getInterceptID() {
        return interceptID;
    }

    public void setInterceptID(long interceptID) {
        this.interceptID = interceptID;
    }

    public String getElnot() {
        return elnot;
    }

    public void setElnot(String elnot) {
        this.elnot = elnot;
    }

    public String getModTypeDesc() {
        return modTypeDesc;
    }

    public void setModTypeDesc(String modTypeDesc) {
        this.modTypeDesc = modTypeDesc;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRdOutStat() {
        return rdOutStat;
    }

    public void setRdOutStat(String rdOutStat) {
        this.rdOutStat = rdOutStat;
    }

    public long getNumBursts() {
        return numBursts;
    }

    public void setNumBursts(long numBursts) {
        this.numBursts = numBursts;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static DatabaseRecord from(long ID, String elnot, String mt, String cc, String rd, long bursts, Timestamp ts) {
        return new DatabaseRecord(ID, elnot, mt, cc, rd, bursts, ts);
    }
}
