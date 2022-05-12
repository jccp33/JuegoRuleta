import java.util.Scanner;

public class Menu {
    private final String roulette = "          ROULETTE  GAME           ";
    private final String title = "            SELECT BET             ";
    private final String line = "-----------------------------------";
    private final String subtitle = "BET                             WIN";
    private final String option1 = "1) Zero (0)                     x15";
    private final String option2 = "2) Specific number              x15";
    private final String option3 = "3) 1 - 12                        x10";
    private final String option4 = "4) 13 - 24                       x10";
    private final String option5 = "5) 25 - 36                       x10";
    private final String option6 = "6) Red                           x5";
    private final String option7 = "7) Black                         x5";
    private final String option8 = "8) Pair                          x5";
    private final String option9 = "9) Odd                           x5";
    private Scanner scanner;
    private int amount;
    private int option;
    private int number;

    public int getAmount() {
        return amount;
    }

    public int getOption() {
        return option;
    }

    public int getNumber() {
        return number;
    }

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.amount = 0;
        this.option = 0;
        this.number = -1;
    }

    public void setAmount(){
        int _amount = 0;
        do{
            try{
                System.out.print("ENTER THE AMOUNT: ");
                _amount = Integer.parseInt(this.scanner.nextLine());
            }catch (NumberFormatException e){
                _amount = 0;
            }
        }while(_amount <= 0);
        this.amount = _amount;
    }

    public void setOption(){
        int _option = 0;
        this.number = 0;
        do{
            try{
                this.showMenu();
                System.out.print("ENTER YOU OPTION: ");
                _option = Integer.parseInt(this.scanner.nextLine());
                if(_option == 2){
                    do {
                        System.out.print("ENTER YOU NUMBER (0 - 36): ");
                        this.number = Integer.parseInt(this.scanner.nextLine());
                    }while(this.number<0 || this.number>36);
                }
            }catch (NumberFormatException e){
                _option = 0;
            }
        }while(_option<=0 || _option>=10);
        this.option = _option;
    }

    public void showInit(){
        System.out.println(line);
        System.out.println(roulette);
        System.out.println(line);
    }

    private void showMenu(){
        System.out.println(title);
        System.out.println(line);
        System.out.println(subtitle);
        System.out.println(line);
        System.out.println(LineColors.ANSI_GREEN + option1 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_GREEN + option2 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_PURPLE + option3 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_PURPLE + option4 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_PURPLE + option5 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_RED + option6 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_BLACK + option7 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_YELLOW + option8 + LineColors.ANSI_RESET);
        System.out.println(LineColors.ANSI_CYAN + option9 + LineColors.ANSI_RESET);
        for(int i=1; i<=36; i++){
            if(i%2 == 0){
                System.out.print(LineColors.ANSI_BLACK + i + "\t" + LineColors.ANSI_RESET);
            }else{
                System.out.print(LineColors.ANSI_RED + i + "\t" + LineColors.ANSI_RESET);
            }
            if(i%12 == 0){
                System.out.println();
            }
        }
    }
}
