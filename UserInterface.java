package com;

import java.util.Scanner;

public class UserInterface {
    int showMainMenu(){
        System.out.println("Enter option \n1. For Buy \n2. For Sell \n3. Print report \n4. Exit ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
    }
}
