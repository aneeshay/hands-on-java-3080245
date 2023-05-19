package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  public static Connection Connect(){

    String db_file = "jdbc:sqlite:resources/bank.db";

    Connection connection = null;

    try{

      connection = DriverManager.getConnection(db_file);
      System.out.println("Connected to db");
    }
    catch(SQLException exception){
      exception.printStackTrace();
    }
    

    return connection;

  }

  public static Customer getCustomer(String userName){

    String sql = "Select * from Customers where username = ?";
    Customer customer = null;

    try(Connection connection = Connect();
    PreparedStatement statement = connection.prepareStatement(sql)){
      statement.setString(1, userName);
      try(ResultSet resultSet = statement.executeQuery()){

        customer = new Customer(
        resultSet.getInt("id"), 
        resultSet.getString("name"),
        resultSet.getString("username"), 
        resultSet.getString("password"), 
        resultSet.getInt("account_id"));
      }
    }
    catch(SQLException e){
      e.printStackTrace();
    }

    return customer;
  }

  public static Account geAccount(int accountID){
    Account account = null;

    String sql = " Select * from Accounts where id = ?";

    try(Connection connection = Connect();
        PreparedStatement statement = connection.prepareStatement(sql)){

          statement.setInt(1, accountID);

          try(ResultSet resultSet = statement.executeQuery()){
            account = new Account(
              resultSet.getInt("id"), 
              resultSet.getString("type"),
              resultSet.getDouble("balance") );
          }

    }
    catch(SQLException e){
      e.printStackTrace();
    }


    return account;
  }
  public static void updateAccountBalance(int accountId,double balance){
    String sql = "Update Accounts Set balance = ? where id = ?";

    try(Connection connection = Connect();
        PreparedStatement statement = connection.prepareStatement(sql)){

          statement.setDouble(1, balance);
          statement.setInt(2, accountId);

          statement.executeUpdate();

        }
        catch(SQLException e){
          e.printStackTrace();
        }
  }


  
}
