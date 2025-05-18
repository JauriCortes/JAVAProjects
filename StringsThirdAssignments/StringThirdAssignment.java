package StringsThirdAssignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import edu.duke.*;

public class StringThirdAssignment {
    
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

        public StorageResource getAllGenes(String dna) {
            StorageResource sr = new StorageResource();
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
                //System.out.println(dna.substring(index, minIndex+3));
                sr.add(dna.substring(index, minIndex+3));
            }
            return sr;
        }
    }

    public class Part2 {
        public float cgRatio(String dna) {

            float count = 0;
            for(Character c : dna.toCharArray()) {
                if (c == 'C' || c == 'G') {
                    count++;
                }
            }
            float ratio = count/(dna.length());
            return ratio;
        }
        
        public int countCTG(String dna) {
            
            int count = 0;
            int index = 0;
            while ((index = dna.indexOf("CTG", index)) != -1) {
                
                count++;
                index += 3;
            }
        
            return count;
        }
    }
    public static void main(String args[]) {

        StringThirdAssignment.Part1 pr = new StringThirdAssignment().new Part1();
        StringThirdAssignment.Part2 cgr = new StringThirdAssignment().new Part2();
        StringThirdAssignment.Part2 ctg = new StringThirdAssignment().new Part2();

        try (BufferedReader reader = new BufferedReader(new FileReader("dnaString.txt"))) {
            
            StringBuilder dnaString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                dnaString.append(line);
            }

            StorageResource data = pr.getAllGenes(dnaString.toString());
            float cgRatio = cgr.cgRatio(dnaString.toString());
            System.out.println(cgRatio);
            
            int ctgCount = ctg.countCTG(dnaString.toString());
            System.out.println(ctgCount);

            for (String gene : data.data()) {
                //System.out.println(gene);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        
    }
}
