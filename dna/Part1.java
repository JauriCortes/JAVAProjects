package dna;

public class Part1 {

    public String findSimpleGene(String dna) {

        String StartCodon = "ATG";
        String EndCodon = "TAA";

        int StartIndex = dna.indexOf(StartCodon);
        int EndIndex = dna.indexOf(EndCodon, StartIndex+3);

        if (StartIndex == -1) {
            return "";
        }
        if (EndIndex == -1) {
            return "";
        }

        if ((EndIndex - StartIndex) % 3 != 0) {
            return "";
        }

        return dna.substring(StartIndex, EndIndex+3);
    }
    
    public void testSimpleGene() {

        String[] testCases = {  
            "ATGGTATGGGGTAGAA", 
            "TAGGGTAGGTTAGTAA", 
            "AGGTAGGTGGGTAGGT",
            "ATGAGTTGAAAGTAA", 
            "ATGGTAGGTGATAA"
        };

        for (String dna : testCases) {

            System.out.println("dna test case is: " + dna);
            System.out.println("Found dna tring is: "  + findSimpleGene(dna));
        }
    }

    public static void main(String[] args) {
        Part1 pr = new Part1();
        pr.testSimpleGene();
    }
}