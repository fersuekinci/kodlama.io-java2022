public class MySqlCustomerDal implements ICustomerDal, IRepository{
    // hem extend hem implement olabilir
    @Override
    public void add() {
        System.out.println("Mysql eklendi");
    }
}
