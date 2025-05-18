import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;

import edu.duke.FileResource;

public class  StringsSecondAssignments {

    public static void main(String args[]) {

        StringsSecondAssignments.Part3 countGenes = new StringsSecondAssignments(). new Part3();
        countGenes.testCountGenes();
        
    }

    public class Part1 {

        public int findStopCodon(String dna, int StartIndex, String stopCodon) {

            int index = dna.indexOf(stopCodon, StartIndex);
            while (index != -1) {

                if((index - StartIndex)% 3 == 0) {

                        return(index);
                }

                index = dna.indexOf(stopCodon, index+1);
            }
            return(-1);
        }

        public String findGene(String dna) {

            int index = dna.indexOf("ATG");
            if (index == -1) {
                return "";
            }

            String[] stopCodons = {"TAA","TAG","TGA"};
            ArrayList<Integer> stopIndexes = new ArrayList<>();

            for (String stopCodon : stopCodons) {

                int stopCodonIndex = findStopCodon(dna, index, stopCodon);
                if (stopCodonIndex != -1) {
                    stopIndexes.add(stopCodonIndex);
                } 
            }

            if (stopIndexes.isEmpty()) {
                return("");
            }

            int minIndex = Collections.min(stopIndexes);
            return dna.substring(index, minIndex+3);



        }

        public void testFindStopCodon() {

            String[] testCases = {
                "ahdjskTAA",
                "ahdjskfTAA",
                "ahdfTAAjskfgTAAsdaacac",
            };

            for ( String test : testCases) {

                System.out.println(findStopCodon(test, 0, "TAA"));
            }
        }

        public void testFindGene() {

            String[] testCases = {
                "ahdjskTAA",
                "ATGahdjsfTAA",
                "ATGahTAGdjskfhgTAAasdTGA",
                "ATGahdfsdaacac",
            };

            for ( String test : testCases) {

                System.out.println("The dna string is: " + test);
                System.out.println(findGene(test));
            }
        
        }

        public void printAllGenes(String dna) {
         int lastIndex = 0;
         while(true) {

             int index = dna.indexOf("ATG", lastIndex);
                if (index == -1) {
                    System.out.println("dna done");
                    break;
                }
    
                String[] stopCodons = {"TAA","TAG","TGA"};
                ArrayList<Integer> stopIndexes = new ArrayList<>();
    
                for (String stopCodon : stopCodons) {
    
                    int stopCodonIndex = findStopCodon(dna, index, stopCodon);
                    if (stopCodonIndex != -1) {
                        stopIndexes.add(stopCodonIndex);
                    } 
                }
    
                if (stopIndexes.isEmpty()) {
                    System.out.println("dna done");
                    break;
                }
    
                int minIndex = Collections.min(stopIndexes);
                lastIndex = minIndex;
                System.out.println(dna.substring(index, minIndex+3));
         }   
        }
    }

    public class Part2 {
        
        public int howMany(String stringa, String stringb) {

            int ocurrences = 0;
            int index = 0;

            while ((index = stringa.indexOf(stringb, index)) != -1) {
                ocurrences++;
                index += stringb.length(); ;
            }

            return ocurrences;
        }

        public void testHowMany() {
            System.out.println(howMany("ATGAACGAATTGAATC", "GAA"));
            System.out.println(howMany("ATAAAA", "AA")); 
        }
    }

    public class Part3 {

        StringsSecondAssignments.Part1 pr = new StringsSecondAssignments().new Part1();

        public int countGenes(String dna) {
            int codons = 0;
            int lastIndex = 0;
            while(true) {

                int index = dna.indexOf("ATG", lastIndex);
                if (index == -1) {
                    System.out.println("dna done");
                    break;
                }

                String[] stopCodons = {"TAA","TAG","TGA"};
                ArrayList<Integer> stopIndexes = new ArrayList<>();

                for (String stopCodon : stopCodons) {

                    int stopCodonIndex = pr.findStopCodon(dna, index, stopCodon);
                    if (stopCodonIndex != -1) {
                        stopIndexes.add(stopCodonIndex);
                    } 
                }

                if (stopIndexes.isEmpty()) {
                    System.out.println("dna done");
                    break;
                }

                int minIndex = Collections.min(stopIndexes);
                lastIndex = minIndex;
                System.out.println(dna.substring(index, minIndex+3));
                codons++;
            }
            return codons;
        }

        public void testCountGenes() {

            FileResource fr = new FileResource("dnaDir/GRch38dnapart.fa");
            String lastdna = fr.asString();
            int n_genes = countGenes(lastdna);

            System.out.println(n_genes + " genes in file");
            
        }
    }
}   
