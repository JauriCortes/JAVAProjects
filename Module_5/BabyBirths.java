package Module_5;
import edu.duke.*;

import java.io.File;

import org.apache.commons.csv.*;

public class BabyBirths {
    
    public static void main(String[] args) {

        BabyBirths Babybirths = new BabyBirths();

        //String route = Babybirths.getRoute("1905");
        //FileResource fr = new FileResource(route);
        //Babybirths.totalBirths(fr);

        //int rank = Babybirths.getRank("1971", "Frank", "M");
        //System.out.println("rank: " + rank);

        //String name = Babybirths.getName("1982", 450, "M");
        //System.out.println("name: " + name);
        
        //Babybirths.whatIsNameInYear("Owen", "1974", "2014", "M");
        
        //int highestRank = Babybirths.yearOfHighestRank("Mich", "M");
        //System.out.println("highestRank: " + highestRank);
        
        //double averageRank = Babybirths.getAverageRank("Robert", "M");
        //System.out.println("average Rank: " + averageRank);
        
        int higherRankedBirths = Babybirths.getTotalBirthsRankedHigher("1990", "Drew", "M");
        System.out.println("higher ranked births: " + higherRankedBirths);
    }

    public String getRoute(String year) {

        String route = "./us_babynames/us_babynames_by_year/yob"+year+".csv";
        return route;
    }
    
    public void totalBirths(FileResource fr) {
        
        int m_count = 0;
        int f_count = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {

            String gender = rec.get(1);
            if(gender.equals("M")) {m_count++; }
            else{f_count++;}

            
        }

        System.out.println("Male count: " + m_count);
        System.out.println("Female count: " + f_count);

        int total_count = f_count + m_count;
        System.out.println("Total count: " + total_count);
    }

    public int getRank(String year,String name, String gender) {

        FileResource fr = new FileResource(getRoute(year));
        int rank = 0;
        for(CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)) {
                rank++;
                if(rec.get(0).equals(name)) {
                    return(rank);
                }
            }
        }
        return(-1);
    }
    
    public String getName(String year, int rank, String gender){
        
        
        FileResource fr = new FileResource(getRoute(year));
        int count = 0;
        for(CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)) {
                count++;
                if(count == rank) {
                    String name = rec.get(0);
                    return(name);
                }
            }
        }
        return("NO NAME");
        
    }
    
    public void whatIsNameInYear(String name, String year, String newYear, String gender) {
        
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
    }
    
    public int yearOfHighestRank(String name, String gender) {
        
        Integer max = null;
        int max_year = 0;
        for (int i = 1880; i <= 2014; i++) {
            
            String year = String.valueOf(i); 
            int rank = getRank(year, name, gender);

            if (max == null){

                max = rank;
                max_year = i;
            }

            if(rank < max) {
                max = rank;
                max_year = i;
            }
            
        }

        if(max == null) {
            return -1;
        }

        return max_year;
    }

    public double getAverageRank(String name, String gender){

        DirectoryResource dr = new DirectoryResource();
        double rank_sum = 0;
        int count = 0;
        for (File f: dr.selectedFiles()){
            String f_name = f.getName();
            String year = f_name.replaceAll("\\D+", "");
            
            int rank = getRank(year, name, gender);
            if(rank != -1.0) { 
                count++;
                rank_sum += rank;
            }
        } 

        if (count != 0) {
            
            return rank_sum/count;
        } 
        else {
            return -1;
        }
    }

    public int getTotalBirthsRankedHigher(String year, String name, String gender) {

        int rank = getRank(year, name, gender);
        int birthsCount = 0;

        for (int i = rank-1; i > 0; i--) {

            String higherName = getName(year, i, gender);
            System.out.println("Higher name: " + higherName);
            
            int births = getBirths(year, higherName, gender);
            System.out.println(higherName +" born " + births + " times");
            birthsCount += births;

        }

        return birthsCount;
    }

    public int getBirths(String year, String name, String gender) {
        FileResource fr = new FileResource(getRoute(year));
        for(CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender) && rec.get(0).equals(name)) {
                return(Integer.parseInt(rec.get(2)));
            }
        }
        return(-1);
    }
}
