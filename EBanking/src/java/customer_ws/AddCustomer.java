/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ibrahim
 */
@WebService(serviceName = "AddCustomer")
public class AddCustomer {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCustomers")
    public String addCustomers(@WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "accountType") String accountType, @WebParam(name = "sortCode") String sortCode, @WebParam(name = "balance") String balance, @WebParam(name = "card") String card, @WebParam(name = "name") String name, @WebParam(name = "birthDate") String birthDate, @WebParam(name = "address") String address, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "email") String email) {
        
         try{
                    String host = "jdbc:derby://localhost:1527/EBanking";
                    String user1 = "w1583004";
                    String pass1 = "123";
                  
                    Connection conn = DriverManager.getConnection(host,user1,pass1);
                    
                    Statement st = conn.createStatement();
                    String sql = "INSERT INTO CUSTOMER VALUES('"+accountNumber+"','"+accountType+"','"+sortCode+"','"+balance+"','"+card+"','"+name+"','"+birthDate+"','"+address+"','"+mobileNo+"','"+email+"')";
                    st.executeUpdate(sql);
                    
                
                    return "a";
                }catch(SQLException err){
                    System.out.println(err.getMessage());
                    return err.getMessage();
                }
        
        
        
    }
}
