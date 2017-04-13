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
@WebService(serviceName = "ManageCustomers")
public class ManageCustomers {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCustomer")
    public String deleteCustomer(@WebParam(name = "accountNo") String accountNo) {
        
        
        try{
                    String host = "jdbc:derby://localhost:1527/EBanking";
                    String user1 = "w1583004";
                    String pass1 = "123";
                  
                    Connection conn = DriverManager.getConnection(host,user1,pass1);
                    
                    Statement st = conn.createStatement();
                    String sql = "DELETE FROM CUSTOMER WHERE accountNo = '"+accountNo+"'";
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
    public String editCustomer(@WebParam(name = "oldAccountNo") String oldAccountNo, @WebParam(name = "newAccountNo") String newAccountNo, @WebParam(name = "accountType") String accountType, @WebParam(name = "sortCode") String sortCode, @WebParam(name = "balance") String balance, @WebParam(name = "card") String card, @WebParam(name = "name") String name, @WebParam(name = "birthDate") String birthDate, @WebParam(name = "address") String address, @WebParam(name = "mobile") String mobile, @WebParam(name = "email") String email) {
        
        
        try{
            //change based on the database you are connecting to
            String host = "jdbc:derby://localhost:1527/EBanking";
            String user1 = "w1583004";
            String pass1 = "123";
                  
            Connection conn = DriverManager.getConnection(host,user1,pass1);
                    
            Statement st = conn.createStatement();
            String sql = "UPDATE CUSTOMER SET accountNo ='"+newAccountNo+"',accountType='"+accountType+"',sortCode='"+sortCode+"',balance='"+balance+"',"
                    +"card='"+card+"',name='"+name+"',birthDate='"+birthDate+"',address='"+address+"',mobileNo='"+mobile+"',email='"+email+"' WHERE accountNo ='"+oldAccountNo+"'";
            st.executeUpdate(sql);
                    
                
            return "a";
        }catch(SQLException err){
            System.out.println(err.getMessage());
            return err.getMessage();
        }
        
        
        
    }




}
