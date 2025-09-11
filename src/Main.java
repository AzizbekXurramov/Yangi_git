//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long katta = 45689;
        long teskari=0;
        while (katta!=0){
            teskari=teskari*10+(katta%10);
            katta=katta/10;
        }
        System.out.println(teskari);


    }

    private static void bir() {
        System.out.println("birinchi");
    }


    
    private static void qushish(int a, int b) {
        System.out.println("a+b="+(a+b));
    }

    private static void salom2() {
        System.out.println("Yangi branchda");
    }

    private static void salom() {
        System.out.println("salom");
    }
}
