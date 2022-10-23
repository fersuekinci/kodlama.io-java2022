public class Main {
    public static void main(String[] args) {
        //interfaceler de abstract lar gibi new lenemezler

        CustomerManager customerManager = new CustomerManager(new OracleCustomerDal());
        customerManager.add();
    }
}