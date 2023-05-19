package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer login(String userName, String password) throws LoginException{

    Customer customer = DataSource.getCustomer(userName);

    if(customer == null){

      throw new LoginException("UserName not found");
    }
    if(password.equals(customer.getPassword())){

      customer.setAuthenticated(true);
      return customer;

    }
    else
        throw new LoginException("Password Incorrect");
    

    
  }

  public static void logout(Customer customer){

  }
  
}
