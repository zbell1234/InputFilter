package main.java.mil.af.flagging.NewInputFilter.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.mil.af.flagging.NewInputFilter.model.DatabaseRecord;

public class InterceptDAO {

    private static Logger LOG = Logger.getLogger(InterceptDAO.class.getName());
    private final DataSource ds;
    private final String DEFAULTSTATUS = "ASSOC-REQ";
    private final String DEFAULTFLOW = "NEW-DATA";

    public InterceptDAO(DataSource ds) {
        this.ds = ds;
    }

    public ArrayList<Long> getInterceptIDs(Connection conn) {
        String query = "select intercept_id from IDB_STATES where status = ?";
        ArrayList<Long> ret = new ArrayList();

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, DEFAULTFLOW);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("intercept_id");
                ret.add(id);
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Could not create a connection", ex);
        }
        return ret;
    }
    
    public ArrayList<DatabaseRecord> getIntercepts(Connection conn, ArrayList<Long> ids) {
        ArrayList<DatabaseRecord> ret = new ArrayList<>();
        String query = "select s.intercept_id, i.elnot, mt.mt_desc, i.country_code, i.rd_out_stat, num_bursts, sysdate ts " +
                       "from idb_states s " +
                       "left join intercepts i " +
                       "on i.intercept_id = s.intercept_id " +
                       "join SEDSCAF_MT mt " +
                       "on mt.mt = i.mod_type " +
                       "where s.intercept_id = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
             for(long id : ids) {
                 ps.setLong(1, id);
                 ResultSet rs = ps.executeQuery();
                 rs.next();
                 DatabaseRecord temp = DatabaseRecord.from(rs.getLong("intercept_id"), rs.getString("elnot"), rs.getString("mt_desc"), 
                         rs.getString("country_code"), rs.getString("country_code"), rs.getLong("num_bursts"), rs.getTimestamp("ts"));
                 ret.add(temp);
             }   
        } catch(SQLException e) {
                
        }   
              
        
        return ret;
    }
}
