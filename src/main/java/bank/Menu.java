package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exception.AmountException;

public class Menu {

  Scanner sc = new Scanner(System.in);

  public static void main(String[] args){
    System.out.println("Welcome to Globe bank International");

    Menu menu = new Menu();

    Customer customer = menu.autheticateUser();

    if(customer != null){
      Account account = DataSource.geAccount(customer.getAccountID());
      menu.showMenu(customer,account);
    }

    menu.sc.close();

  }

  private void showMenu(Customer customer, Account account) {
    int selection = 0;

    while(selection != 4 && customer.isAuthenticated()){
      System.out.println("============================");
      System.out.println("Please select one of the following options");
      System.out.println("1 : Deposit");
      System.out.println("2 : Withdraw");
      System.out.println("3 : Check Balance");
      System.out.println("4 : Exit");
      System.out.println("============================");

      selection = sc.nextInt();
      double amount =0.0;

      switch(selection){
        case 1 :  System.out.println("How much do you want to deposit: ");
                   amount = sc.nextDouble();
                  try {
                      account.deposit(amount);
                      } catch (AmountException e) {
                      System.out.println(e.getMessage());
                      System.out.println("Please try again");
                      }
                    break;
        case 2 :  System.out.println("How much do you want to withdraw: ");
                   amount = sc.nextDouble();
                  try {
                     account.withdraw(amount);
                      } catch (AmountException e) {
                     System.out.println(e.getMessage());
                     System.out.println("Please try againclillea8@nasa.gov");
                      }
                  break;
        case 3  : System.out.println("Checking Balance...");
                  System.out.println("Current Balance: "+account.getBalance());
                  break;
        case 4  : System.out.println("Exiting, Thank you for Banking with us");
                  break;
        default : System.out.println("Invalid Option");
                  break;

      }
    }
  }

  private Customer autheticateUser(){

    Customer customer = null;

    System.out.println("Please enter your username: ");
    String userName = sc.nextLine();
    System.out.println("Please enter your password: ");
    String password = sc.nextLine();

    try {
      customer = Authenticator.login(userName, password);
    } catch (LoginException e) {
      e.printStackTrace();
      System.out.println("Invalid Credetials "+e.getMessage());
    }
    return customer;
  }
  
}
