/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ibrahim
 */
@WebService(serviceName = "ManageEmployees")
public class ManageEmployees {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddEmployee")
    public String AddEmployee(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "position") String position) {
        
            try{
                    String host = "jdbc:derby://localhost:1527/EBanking";
                    String user1 = "w1583004";
                    String pass1 = "123";
                  
                    Connection conn = DriverManager.getConnection(host,user1,pass1);
                    
                    Statement st = conn.createStatement();
                    String sql = "INSERT INTO EMPLOYEE VALUES('"+username+"','"+password+"','"+name+"','"+position+"')";
                    st.executeUpdate(sql);
                    
                
                    return "a";
                }catch(SQLException err){
                    System.out.println(err.getMessage());
                    return err.getMessage();
                }
        
        
        
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editEmployee")
    public String editEmployee(@WebParam(name = "oldUsername") String oldUsername, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "fullName") String fullName, @WebParam(name = "jobPosition") String jobPosition) {
        
        try{
            //change based on the database you are connecting to
            String host = "jdbc:derby://localhost:1527/EBanking";
            String user1 = "w1583004";
            String pass1 = "123";
                  
            Connection conn = DriverManager.getConnection(host,user1,pass1);
                    
            Statement st = conn.createStatement();
            String sql = "UPDATE EMPLOYEE SET username ='"+username+"',password='"+password+"',fullName='"+fullName+"',jobPosition='"+jobPosition+"' WHERE username ='"+oldUsername+"'";
            st.executeUpdate(sql);
                    
                
            return "a";
        }catch(SQLException err){
            System.out.println(err.getMessage());
            return err.getMessage();
        }
        
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteEmployee")
    public String deleteEmployee(@WebParam(name = "username") String username) {
        try{
                    String host = "jdbc:derby://localhost:1527/EBanking";
                    String user1 = "w1583004";
                    String pass1 = "123";
                  
                    Connection conn = DriverManager.getConnection(host,user1,pass1);
                    
                    Statement st = conn.createStatement();
                    String sql = "DELETE FROM EMPLOYEE WHERE username = '"+username+"'";
                    st.executeUpdate(sql);
                    
                
                    return "a";
                }catch(SQLException err){
                    System.out.println(err.getMessage());
                    return err.getMessage();
                }
        
    }

}
