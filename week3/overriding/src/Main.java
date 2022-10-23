public class Main {
    public static void main(String[] args) {
        BaseKrediManager[] krediManages = new BaseKrediManager[]
                {new OgretmenKrediManager(), new TarimKrediManager(), new OgrenciKrediManager()};

        for(BaseKrediManager krediManager: krediManages) {
            System.out.println(krediManager.hesapla(1000));
        }
    }
}