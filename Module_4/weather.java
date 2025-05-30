import java.io.File;

import org.apache.commons.csv.*;
import edu.duke.*;

public class weather {

    public static void main(String[] args){

        weather wtr = new weather();
        wtr.testColdestHourInFile();
    }

    public void testColdestHourInFile() {

        FileResource fr = new FileResource("nc_weather/2012/weather-2012-01-01.csv");
        CSVParser parser = fr.getCSVParser();

        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println(coldest.get("TemperatureF"));

        fileWithColdestTemperature();
    
    }

    public CSVRecord coldestHourInFile(CSVParser parser){

        CSVRecord coldest_record = null;
        for (CSVRecord record: parser) {
            
            String temperature = record.get("TemperatureF");
            double temperature_double = Double.parseDouble(temperature);

            if (coldest_record == null) {
                coldest_record = record;
            }
            else {
                
                double coldest_double = Double.parseDouble(coldest_record.get("TemperatureF"));
                if (temperature_double < coldest_double && temperature_double != -9999) {

                    coldest_record = record;
                }
            }

        }
        return coldest_record;
    }

    public void fileWithColdestTemperature(){

        File folder = new File("nc_weather");
        File[] years = folder.listFiles();
        if (years != null) {
            CSVRecord coldestRecordSoFar = null;
            File coldestFileSoFar = null;
            for(File year : years) {
                File[] files = year.listFiles();
                for(File file: files) {

                    FileResource fr = new FileResource(file);
                    CSVParser parser = fr.getCSVParser();

                    CSVRecord currentColdestRecord = coldestHourInFile(parser);

                    if (coldestRecordSoFar == null) {
                        coldestRecordSoFar = currentColdestRecord;
                        coldestFileSoFar = file;
                    }
                    else {

                        double soFarDouble = Double.parseDouble(coldestRecordSoFar.get("TemperatureF"));
                        double currentDouble = Double.parseDouble(currentColdestRecord.get("TemperatureF"));
                        if (currentDouble < soFarDouble) {
                            coldestRecordSoFar = currentColdestRecord;
                            coldestFileSoFar = file;
                        }
                    }
                }
            }

            System.out.println("Coldest day was in file " + coldestFileSoFar.getName());
            System.out.println("Coldest temperature on that day was " + coldestRecordSoFar.get("TemperatureF"));
            System.out.println("All the temperatures on the coldest day were: ");

            FileResource fr = new FileResource(coldestFileSoFar);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord record: parser) {
                System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
            }

        }
    }
}