import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class dnaMaker {

    public static void main(String[] args) {

        dnaMaker dna = new dnaMaker();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("dnaString.txt"))) {

            for(int i = 0; i < 1000; i++) {
                dna.writeCodons(writer);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }

    public void writeCodons(BufferedWriter writer) throws IOException{

        String codons[] = {"ATG", "TAA", "TGA", "TAG"};
        
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        
        if (randomNumber < 25) {
            int randomCodon = random.nextInt(4);
            writer.write(codons[randomCodon]);
        } 
        else {
            writer.write("a");;
        }
    }
}

