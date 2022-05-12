import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roulette {
    static final int SQUARES = 36;
    private int[] rouletteNumbers;
    private int[] rouletteColors;

    public Roulette() {
        this.rouletteNumbers = new int[SQUARES+1];
        this.rouletteColors = new int[SQUARES+1];

        for(int i=0; i<=SQUARES; i++){
            this.rouletteNumbers[i] = i;
            if(i%2 == 0){
                this.rouletteColors[i] = 0;
            }else{
                this.rouletteColors[i] = 1;
            }
        }
    }

    private int spinRoulette(){
        Random random = new Random();
        return random.nextInt(SQUARES);
    }

    public Pair playRoulette(int amount, int option, int number){
        Pair pair;
        int random = spinRoulette();
        if(option==1 && random==0){
            pair = new Pair(amount*15, "Roulette: " + random + ", Your number: 0");
        }else if(option==2 && random==number){
            pair = new Pair(amount*15, "Roulette: " + random + ", Your number: " + number);
        }else if(option==3 && (random>=1 && random<=12)){
            pair = new Pair(amount*10, "Roulette: " + random + " [1 - 12]");
        }else if(option==4 && (random>=13 && random<=24)){
            pair = new Pair(amount*10, "Roulette: " + random + " [13 - 24]");
        }else if(option==5 && (random>=25 && random<=36)){
            pair = new Pair(amount*10, "Roulette: " + random + " [25 - 36]");
        }else if(option==6 && random!=0 && this.rouletteColors[random]==1){
            pair = new Pair(amount*5, "Roulette: " + random + LineColors.ANSI_RED + " [Red]" + LineColors.ANSI_RESET);
        }else if(option==7 && random!=0 && this.rouletteColors[random]==0){
            pair = new Pair(amount*5, "Roulette: " + random + LineColors.ANSI_BLACK + " [Black]" + LineColors.ANSI_RESET);
        }else if(option==8 && random!=0 && random%2==0){
            pair = new Pair(amount*5, "Roulette: " + random + " [Pair]");
        }else if(option==8 && random!=0 && random%2!=0){
            pair = new Pair(amount*5, "Roulette: " + random + " [Odd]");
        }else{
            pair = new Pair(0, "Roulette: " + random + ", Your option: " + option + ", Your number: " + number);
        }
        return pair;
    }
}
