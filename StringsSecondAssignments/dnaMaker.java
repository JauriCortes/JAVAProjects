 import java.util.Random;

public class dnaMaker {

    public static void main(Strings args[]) {


    }

    public void printCodons() {
            String codons[] = {"ATG", "TAA", "TGA", "TAG"};
        
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        
        if (randomNumber < 25) {
            int randomCodon = random.nextInt(4);
            System.out.print(codons[randomCodon]);
        } 
        else {
            
            System.out.print("a");
        }
    }
}

