public class Main {
    public static void main(String[] args) {
        WomanGameCalculator womanGameCalculator = new WomanGameCalculator();
        womanGameCalculator.hesapla();
        womanGameCalculator.gameOver();

        //abstract class lar genelde new lenmez

        GameCalculator gameCalculator = new WomanGameCalculator();

    }
}