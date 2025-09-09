//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        salom();
        salom2();
        qushish(2,3);
        bir();
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
