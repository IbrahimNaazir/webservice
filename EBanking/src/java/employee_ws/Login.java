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
import java.util.Properties;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ibrahim
 */
@WebService(serviceName = "Login")
public class Login {


    /**
     * Web service operation
     */
    
    
    
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
           String user = "nothing";
           String pass = "nothing";
                try{
                    String host = "jdbc:derby://localhost:1527/EBanking";
                    String user1 = "w1583004";
                    String pass1 = "123";
                  
                    Connection conn = DriverManager.getConnection(host,user1,pass1);
                     
                    Statement st = conn.createStatement();
                    String sql = "SELECT username,password FROM EMPLOYEE WHERE username ='"+username+"'";
                    ResultSet rs = st.executeQuery(sql);
                   
                
                    while(rs.next()){
                        if(rs.getString("username").equals(username)&& rs.getString("password").equals(password)){
                            user = rs.getString("username");
                            pass = rs.getString("password");
                        }
                    }
                    
                    if(username.equals(user)&& password.equals(pass)){
                        return "a";
                    }else {
                        return "b";
                        
                    }
                }catch(SQLException err){
                    System.out.println(err.getMessage());
                    user = err.getMessage();
                }
        
        
            return user;
        
    }
}
