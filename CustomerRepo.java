package com;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private static CustomerRepo instance;
    private List<CustomerInfo> customerList = new ArrayList();

    private CustomerRepo(){

    }

    public static CustomerRepo getInstance() {
        if(instance == null)
            instance = new CustomerRepo();
        return instance;
    }

    void add(CustomerInfo customer){
            customerList.add(customer);
        }

    List getCustomerList(){
        return customerList;
    }


}
