import edu.duke.*;

import java.util.ArrayList;

import org.apache.commons.csv.*;

public class exportsAssignment {

    public static void main(String[] args) {
        
        exportsAssignment ea = new exportsAssignment();
        ea.tester();
    }

    public void tester() {

        FileResource fr = new FileResource("exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();

        String info = countryInfo(parser, "Nauru");
        System.out.println(info);
        parser = fr.getCSVParser();
        
        String exporter = listExportersTwoProducts(parser, "cotton", "flowers");
        System.out.println(exporter);
        parser = fr.getCSVParser();
        
        int number_exporters = numberOfExporters(parser,"cocoa");
        System.out.println(number_exporters);
        parser = fr.getCSVParser();

        bigExporters(parser,"$999,999,999,999");
        parser = fr.getCSVParser();
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

    public int numberOfExporters(CSVParser parser, String exportItem) {

        int counter = 0;
        for(CSVRecord record: parser) {

            String exports = record.get("Exports");

            if(exports.contains(exportItem)) {

                counter++;
            }
        }

        return counter;
    } 
    
    public void bigExporters(CSVParser parser, String amount) {

        int longer = amount.length();
        for (CSVRecord record: parser) {

            String value = record.get("Value (dollars)");
            int record_longer = value.length();

            if(record_longer>longer) {
                String name = record.get("Country");
                System.out.println(name + " " + value);
            }
        }
    }
}