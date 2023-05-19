package bank;

public class Customer {
  private int id;
  private String name;
  private String userName;
  private String password;
  private int accountID;

  public Customer(int id, String name, String userName, String password, int accountID){
    this.id = id;
    this.name = name;
    this.userName = userName;
    this.password = password;
    this.accountID = accountID;

  }


  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountID() {
    return this.accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

}
