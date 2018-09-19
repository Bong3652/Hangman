import java.util.ArrayList;
import java.util.Scanner;
public class HangMan {
    public static void main(String[] args) {
        //Setup
        Scanner sc=new Scanner(System.in);
        System.out.print("Let's play a round of hangman!"+"\n"+"=============================="+"\n"+"Type a Word: ");
        String word=sc.nextLine();
        int loop=0;
        while(loop<10) {
            System.out.println();
            loop++;
        }
        System.out.println("The secret word has entered!"+"\n"+"Let the game began...");


        //Player var
        int PlayerHealth = 5;
        String PlayerGuess;
        ArrayList OldLetters= new ArrayList();

        //Enemy var
        int EnemyHealth = word.length();
        ArrayList enemy=new ArrayList();

        //Board
        while (EnemyHealth>0) {
            enemy.add("_");
            EnemyHealth -= 1;
        }
        while (true) {
            System.out.print("\n" + enemy + "\n" + "Lives: " + PlayerHealth + "\n" + "Guess a letter: ");
            PlayerGuess = sc.nextLine();
            if (PlayerGuess.length()==0 || PlayerGuess.length()>1){
                System.out.println("Try typing one letter next time as punishment you'll have to completely start over");
                break;
            }
            OldLetters.add(PlayerGuess);
            System.out.println("Letters graveyard: "+OldLetters+"\n"+"-----------------------------");
            int index = word.indexOf(PlayerGuess);
            if (index >= 0) {
                while (index >= 0) {
                    enemy.set(index, PlayerGuess);
                    index = word.indexOf(PlayerGuess, index + 1);
                }
            }else{
                PlayerHealth-=1;
            }
            String listString = String.join("", enemy);
            if (PlayerHealth==0) {
                System.out.println("-----------------------------");
                System.out.println("Game Over.... The man is hanged");
                break;

            }else if (listString.equals(word)) {
                System.out.println("-----------------------------");
                System.out.println("Congrats you win the secret word was: "+word);
                break;

            }

        }

    }
}
/*while (index >= 0) {
                enemy.set(index, PlayerGuess);
                index = word.indexOf(PlayerGuess, index + 1);
            }*/
