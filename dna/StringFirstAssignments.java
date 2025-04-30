package dna;

import java.util.concurrent.BlockingQueue;

public class StringFirstAssignments {

    public class part1 {
    
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
    }

    

    public static void main(String[] args) {
        StringFirstAssignments.part1 pr = new StringFirstAssignments().new part1();
        pr.testSimpleGene();

        StringFirstAssignments.part2 pr2 = new StringFirstAssignments().new part2();
        pr2.testSimpleGene();

        StringFirstAssignments.part3 pr3 = new StringFirstAssignments().new part3();
        pr3.testing();
    }

    public class  part2 {
        
        public String findSimpleGene(String raw_dna, String StartCodon, String EndCodon) {
            
            String dna = raw_dna.toUpperCase();

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
            
            Character first_Character = raw_dna.charAt(0);
            if(Character.isUpperCase(first_Character)) {
                return dna.substring(StartIndex, EndIndex+3);
            } else {
                return dna.substring(StartIndex, EndIndex+3).toLowerCase();
            }

        }

        public void testSimpleGene() {

            String[] testCases = {  
                "ATGGTATGGGGTAGAA", 
                "TAGGGTAGGTTAGTAA", 
                "AGGTAGGTGGGTAGGT",
                "ATGAGTTGAAAGTAA", 
                "ATGGTAGGTGATAA",
                "atggtatggggtagaa",
                "tagggtaggttagtaa",
                "aggtaggtgggtaggt",
                "atgagttgaaagtaa",
                "atggtaggtgataa"
            };
    
            for (String dna : testCases) {
    
                System.out.println("dna test case is: " + dna);
                System.out.println("Found dna tring is: "  + findSimpleGene(dna,"ATG", "TAA"));
                
            }
        }
        
    }

    public class  part3 {
    
        public Boolean twoOcurrences(String stringa, String stringb) {

            int ocurrences = 0;
            int index = 0;

            while ((index = stringa.indexOf(stringb, index)) != -1) {     
                ocurrences++;
                index++;
            }
            
            if (2 > ocurrences) {
                return false;
            }
            return true;
        }

        public void testing () {
            String[][] testCases = {
                {"by", "A story by Abby Long"},
                {"a", "banana"},
                {"atg", "ctgtatgta"}
            };
    
            for (String[] testCase  : testCases) {
    
                String stringa = testCase[1];
                String stringb = testCase[0];
                System.out.println("String a: " + stringa);
                System.out.println("String b: " + stringb);
    
                boolean areTheretwoOcurrences = twoOcurrences(stringa, stringb);
                
                System.out.println("Are there 2 ocurrences? : " + areTheretwoOcurrences);
    
            }
        }
    }

}
