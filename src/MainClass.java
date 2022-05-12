import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Roulette roulette = new Roulette();
        String option = "";

        do {
            LineColors.clearConsole();
            System.out.println();
            menu.showInit();
            menu.setAmount();
            menu.setOption();
            Pair pair = roulette.playRoulette(menu.getAmount(), menu.getOption(), menu.getNumber());
            if (pair.getValue() > 0) {
                System.out.println("*****************************");
                System.out.println("     CONGRATULATIONS !!!     ");
                System.out.println("*****************************");
                System.out.println("$" + pair.getValue() + " by " + pair.getLabel());
            } else {
                System.out.println("*****************************");
                System.out.println("        TRY AGAIN !!!        ");
                System.out.println("*****************************");
                System.out.println("$" + pair.getValue() + " -> " + pair.getLabel());
            }

            System.out.print("CONTINUE (1 = SI)?: ");
            option = scanner.nextLine();
        }while(option.equals("1"));
    }

}
