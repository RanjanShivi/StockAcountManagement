package com;

import java.util.ArrayList;
import java.util.List;

public class StockRepo {
    public static StockRepo instance;

    StockRepo() {
    }

    public static StockRepo getInstance() {
        if (instance == null) {
            instance = new StockRepo();
        }
        return instance;
    }

    private List<CompanyShares> list;

    {
        list = new ArrayList<>();
        list.add(new CompanyShares(1, "Bridgelabz", 5, 100));
        list.add(new CompanyShares(2, "Amazon", 8, 80));
        list.add(new CompanyShares(3, "Reliance", 10, 50));
        list.add(new CompanyShares(3, "Tata", 25, 50));
    }

    public boolean isCompanyAvailable(String companyName, int noOfShare) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).companyName.equals(companyName)) {
                if (noOfShare <= list.get(i).noOfShare)
                    return true;
            }
        }
        return false;
    }

    void displayCompanyName() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).companyName);
        }
    }
}
