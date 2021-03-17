/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import kimnv.utils.DBHelpers;

/**
 *
 * @author nguye
 */
public class DBTestDAO {
    
    public boolean checkLogin(String username, String password) 
            throws SQLException{
            
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBHelpers.makeConnection();
            if(con != null){
                String sql = "Select username"
                        + " From TblTest"
                        + " Where username like ? and password like ?";
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery(sql);
                
                if(rs.next())
                    return true;
            }
        }catch(Throwable t){
            t.printStackTrace();
        }finally{
            if(con != null)
                con.close();
            if(stm != null)
                stm.close();
        }
        
        return false;
    }
    
}
