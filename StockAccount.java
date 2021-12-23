package com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StockAccount {
    StockRepo stockRepo = StockRepo.getInstance();
    CustomerRepo customerRepo = CustomerRepo.getInstance();

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        StockAccount stockAccount = new StockAccount();
        int option = 0;
        do {
            option = userInterface.showMainMenu();
            stockAccount.handleUserSelection(option);
        } while (option != 4);
    }

    void handleUserSelection(int option){
        StockAccount stockAccount = new StockAccount();
        Scanner scanner = new Scanner(System.in);

        switch (option){
                case 1://BUY
                    System.out.println("Enter your name");
                    String customerName = scanner.nextLine();

                    System.out.println("Enter how much money u want to invest ");
                    double customerAmount = scanner.nextInt();

                    System.out.println("Enter which company share u want buy ");
                    stockRepo.displayCompanyName();
                    String companyName = scanner.next();

                    System.out.println("How many share u want to buy");
                    int noOfShares = scanner.nextInt();

                    stockAccount.buy(customerName, companyName, noOfShares, customerAmount);
                    break;
                case 2://SELL
                    System.out.println("Enter your name");
                    String sellorName = scanner.nextLine();

                    System.out.println("Enter how money you have before selling ");
                    double customerAmount1 = scanner.nextInt();

                    System.out.println("Enter which company share u want to sell ");
                    stockRepo.displayCompanyName();
                    String companyName1 = scanner.next();

                    System.out.println("How many share u want to sell");
                    int noOfShares1 = scanner.nextInt();

                    stockAccount.sell(sellorName, companyName1, noOfShares1, customerAmount1);
                    break;
                case 3://Print Report
                    List customerList = customerRepo.getCustomerList();
                    stockAccount.printReport(customerList);
                    break;
                case 4: break;
                default:
                    System.out.println(" Wrong option entered ");
            }
    }

    void buy(String customerName, String companyName, int noOfShares, double customerAmount) {
        if(stockRepo.isCompanyAvailable(companyName, noOfShares)){
            double sharePrice = CompanyShares.getSharePrice();
            double amount = sharePrice * noOfShares;

            if(customerAmount >= amount) {
                customerAmount -= amount;
                System.out.println("The Share price of " + companyName + " company is INR " + sharePrice );
                System.out.println("You buy "+ noOfShares + " shares of " + companyName + " company & ur available balance is " + customerAmount);
                String operation = "Buy";
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String time = dateTimeFormatter.format(now);
                CustomerInfo info = new CustomerInfo(customerName, operation, companyName, noOfShares, time);
                customerRepo.add(info);
            }
            else {
                System.out.println("You do not have sufficient balance to buy the share.");
            }
        }
        else {
            System.out.println("Stock not available ");
        }
    }

    public void sell(String sellorName, String companyName, int noOfShare, double customerAmount){

        if(stockRepo.isCompanyAvailable(companyName, noOfShare)){
            double sharePrice = CompanyShares.getSharePrice();
            customerAmount += sharePrice * noOfShare;
            System.out.println("The Share price of " + companyName + " company is " + sharePrice + "rupees" );
            System.out.println("You sell "+ noOfShare+ " shares of " + companyName + " company & your balance becomes " + customerAmount);
            String operation = "Sell";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dateTimeFormatter.format(now);
            CustomerInfo info = new CustomerInfo(sellorName, operation, companyName, noOfShare, time);
            customerRepo.add(info);
        }
        else {
            System.out.println("Stock not available ");
        }
    }

    public void printReport(List customerList){
        for (int i = 0; i < customerList.size(); i++ ){
            System.out.println(customerList.get(i));
            }
        }
    }


