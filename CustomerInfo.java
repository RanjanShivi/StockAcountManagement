package com;

class CustomerInfo {
    public String time;
    public String operation;
    public String customerName;
    public String companyName;
    public int noOfShare;

    CustomerInfo(String customerName,String operation, String companyName, int noOfShare, String time) {
        this.customerName = customerName;
        this.noOfShare = noOfShare;
        this.companyName = companyName;
        this.operation = operation;
        this.time = time;
    }

    @Override
    public String toString() {
        return "CustomerInfo:-" +
                "time=" + time + "\n" +
                "operation=" + operation + "\n" +
                "traderName=" + customerName + "\n" +
                "companyName=" + companyName + "\n" +
                "noOfShare=" + noOfShare ;
    }
}
