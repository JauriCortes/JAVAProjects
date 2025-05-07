package dna;

import java.net.URLPermission;
import java.util.concurrent.BlockingQueue;

import edu.duke.*;

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
                "AAATGCCCTAACTAGATTAAGAAACC"
            };
    
            for (String dna : testCases) {
    
                System.out.println("dna test case is: " + dna);
                System.out.println("Found dna tring is: "  + findSimpleGene(dna));
            }
        }
    }

    

    public static void main(String[] args) {
        StringFirstAssignments.part1 pr = new StringFirstAssignments().new part1();
        //pr.testSimpleGene();

        StringFirstAssignments.part2 pr2 = new StringFirstAssignments().new part2();
        //pr2.testSimpleGene();

        StringFirstAssignments.part3 pr3 = new StringFirstAssignments().new part3();
        //pr3.testing();

        StringFirstAssignments.part4 pr4 = new StringFirstAssignments().new part4();
        pr4.printLinks();
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

            //busca cuando la substring "stringb" aparece en la string "stringa"
            while ((index = stringa.indexOf(stringb, index)) != -1) {     
                ocurrences++;
                index++;
            }
            
            if (2 > ocurrences) {
                return false;
            }
            return true;
        }

        public String lastPart(String stringa, String stringb) {

            int index = stringa.indexOf(stringb);
            if (index == -1) {
                return stringa;
            }
            else {
                return stringa.substring(index+stringb.length(), stringa.length());
            }
        }


        public void testing () {
            String[][] testCases = {
                {"A story by Abby Long", "by"},
                {"banana", "a"},
                {"ctgtatgta", "atg"}
            };
    
            for (String[] testCase  : testCases) {
    
                String stringa = testCase[0];
                String stringb = testCase[1];
                System.out.println("String a: " + stringa);
                System.out.println("String b: " + stringb);
    
                boolean areTheretwoOcurrences = twoOcurrences(stringa, stringb);
                
                System.out.println("Are there 2 ocurrences? : " + areTheretwoOcurrences);
                

                System.out.println("The part of the string after " + stringb + " in " + stringa + " is " + lastPart(stringa, stringb));
            }
        }
    }

    public class part4 {

        public void printLinks() {

            URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
            for (String str : url.lines()) {
    
                String lowercaseLine = str.toLowerCase();
                int index = 0;
                if ((index = lowercaseLine.indexOf("youtube.com", index)) != -1) {

                    int linkStartindex = str.lastIndexOf("\"", index)+1;
                    int linkEndindex = str.indexOf("\"", index);

                    String link = str.substring(linkStartindex, linkEndindex);
                    System.out.println(link);

                    index += link.length();
                }

                index++;
            }

        }
    }
}
