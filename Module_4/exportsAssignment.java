import edu.duke.*;
import org.apache.commons.csv.*;

class exportsAssignment {

    public static void main(String[] args) {
        
        exportsAssignment ea = new exportsAssignment();
        ea.tester();
    }

    public void tester() {

        FileResource fr = new FileResource("exports/exports_small.csv");
        CSVParser parser = fr.getCSVParser();

        String info = countryInfo(parser, "Namibia");
        System.out.println(info);
    }

    public String countryInfo(CSVParser parser, String country) {

        for(CSVRecord record : parser) {
            String country_col = record.get("Country");

            if (country_col.contains(country)) {
                
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");

                String result = country_col + ": " +  exports + ": " +  value + ": ";
                return result;
            }
        }

        return("NOT FOUND");
        
    }
}