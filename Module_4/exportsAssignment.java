import edu.duke.*;

import java.util.ArrayList;

import org.apache.commons.csv.*;

public class exportsAssignment {

    public static void main(String[] args) {
        
        exportsAssignment ea = new exportsAssignment();
        ea.tester();
    }

    public void tester() {

        FileResource fr = new FileResource("exports/exports_small.csv");
        CSVParser parser = fr.getCSVParser();

        String info = countryInfo(parser, "Namibia");
        System.out.println(info);

        String exporter = listExportersTwoProducts(parser, "gold", "diamonds");
        System.out.println(exporter);
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

    public String listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {

        ArrayList<String> exporters = new ArrayList<>();
        for(CSVRecord record: parser) {
            String exports = record.get("Exports");

            if(exports.contains(exportItem1) && exports.contains(exportItem2)) {

                String country = record.get("Country");
                exporters.add(country);
            }
        }
        String exportersString = String.join(", ", exporters);
        return(exportersString);

    }
}