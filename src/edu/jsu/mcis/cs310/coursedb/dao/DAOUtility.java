package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                
                ResultSetMetaData rsmd = rs.getMetaData();
                
                int column = rsmd.getColumnCount();
                
                JsonObject temp = new JsonObject();
                if(rs.next()){
                    for(int x = 1; x <= column; x++){
                        String columnName = rsmd.getColumnName(x);
                        String value = rs.getString(x);
                        temp.put(columnName, value);
                    }
                    /*String sectionTemp = rs.getString("section");
                    System.out.println(sectionTemp);
                    String numTemp = rs.getString("num");
                    System.out.println(numTemp);
                    String columnTemp = rs.getString("subjectid");
                    System.out.println(columnTemp);*/
                }else{
                    System.out.println("No rows found");
                }
                records.add(temp);
                
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
