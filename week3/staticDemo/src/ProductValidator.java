public class ProductValidator {

    // constructor lar sadece new lenince çalışır.
    public ProductValidator() {
        System.out.println("Yapıcı blok çalıştı");
    }

    // new lenmese de çalışır.
    static {
        System.out.println("Static yapıcı blok çalıştı");
    }

    public static boolean isValid(Product product){
        if(product.price>0 && !product.name.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    // inner class yapısı.
    // static fonk için class da static olmalı
    // outer class gibi değil
    /*public static class innerClass{
        public static void Sil() {

        }
    }
     */
}
