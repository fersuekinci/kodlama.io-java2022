public class ProductManager {
    public void add(Product product) {
        //ProductValidator validator = new ProductValidator();
        //üsttekinin fonksiyonunu statik yaparsak aşağıdaki gibi kullanabiliriz
        if(ProductValidator.isValid(product)){
            System.out.println("Eklendi");
        }
        else {
            System.out.println("Ürün bilgileri geçersiz");
        }
    }
}
