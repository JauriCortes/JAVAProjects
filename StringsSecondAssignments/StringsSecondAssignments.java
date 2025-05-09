import java.util.Collections;
import java.util.ArrayList;

public class  StringsSecondAssignments {

    public static void main(String args[]) {

        StringsSecondAssignments.Part1 pr = new StringsSecondAssignments().new Part1();
        pr.testFindGene();
        
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
                "ATGahdjskfTAA",
                "ATGahTAGdjskfTAAasdTGA",
                "ATGahdfsdaacac",
            };

            for ( String test : testCases) {

                System.out.println(findGene(test));
            }
        
        }
    }
}   
