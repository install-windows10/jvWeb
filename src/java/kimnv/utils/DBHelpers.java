/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kimnv.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author nguye
 */
public class DBHelpers implements Serializable{
    public static Connection makeConnection() 
            throws NamingException, SQLException{
        
        Context currentContext = new InitialContext();
        Context tomcatContext = (Context) currentContext.lookup("java:comp/env");
        DataSource DSTest = (DataSource) tomcatContext.lookup("DSTest");
        Connection con = DSTest.getConnection();
        
        
        return con;
    }
}
