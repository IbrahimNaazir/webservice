/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ibrahim
 */
@WebService(serviceName = "displayCustomer")
public class displayCustomer {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "displayCustomers")
    public List displayCustomers(@WebParam(name = "List1") List List1) {
        try{
            String host = "jdbc:derby://localhost:1527/EBanking";
            String user1 = "w1583004";
            String pass1 = "123";
                  
            Connection conn = DriverManager.getConnection(host,user1,pass1);
                     
            Statement st = conn.createStatement();
            String sql = "SELECT accountNo,name FROM CUSTOMER";
            ResultSet rs = st.executeQuery(sql);
                   
                
            while(rs.next()){
                        
                String account = rs.getString("accountNo");
                String name = rs.getString("name");
                List1.add(account +" - "+ name);
                       
            }
                   return List1; 
                    
        }catch(SQLException err){
            System.out.println(err.getMessage());          
        }
        return List1;
    }
}
