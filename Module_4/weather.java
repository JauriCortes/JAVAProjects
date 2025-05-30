import java.io.File;

import org.apache.commons.csv.*;
import edu.duke.*;

public class weather {

    public static void main(String[] args){

        weather wtr = new weather();
        wtr.testColdestHourInFile();
    }

    public void testColdestHourInFile() {

        FileResource fr = new FileResource("nc_weather/2013/weather-2013-09-02.csv");
        CSVParser parser = fr.getCSVParser();

        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println(coldest.get("TemperatureF"));
        parser = fr.getCSVParser();

        fileWithColdestTemperature();

        CSVRecord lowest = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
        parser = fr.getCSVParser();
        
        lowestHumidityInManyFiles();

        double average = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + average);
        parser = fr.getCSVParser();

        Double averageHighHumidity = averageTemperatureWithHighHumidityinFile(parser, 80);
        if (averageHighHumidity == null) {

            System.out.println("No temperatures with that humidity");
        } else {

            System.out.println("Average temp when high humidity is " + averageHighHumidity);
        }
        parser = fr.getCSVParser();


    
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
            for(File test : years) {
                File year = new File("nc_weather/2013");
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

    public CSVRecord lowestHumidityInFile(CSVParser parser) {

        CSVRecord lowest_record = null;
        for (CSVRecord record: parser) {
            
            
            String humidity = record.get("Humidity");
            if( !humidity.equals("N/A")) {
                
                double humidity_double = Double.parseDouble(humidity);

                if (lowest_record == null) {
                    lowest_record = record;
                }
                else {
                    
                    double lowest_double = Double.parseDouble(lowest_record.get("Humidity"));
                    if (humidity_double < lowest_double) {
    
                        lowest_record = record;
                    }
                }
            }

        }
        return lowest_record;
    }

    public void lowestHumidityInManyFiles() {

        File folder = new File("nc_weather/2013");
        File[] files = folder.listFiles();
        if (files != null) {
            CSVRecord coldestRecordSoFar = null;
            File coldestFileSoFar = null;
            for(File file: files) {

                FileResource fr = new FileResource(file);
                CSVParser parser = fr.getCSVParser();

                CSVRecord currentColdestRecord = lowestHumidityInFile(parser);

                if (coldestRecordSoFar == null ) {
                    coldestRecordSoFar = currentColdestRecord;
                    coldestFileSoFar = file;
                }
                else {

                    if(currentColdestRecord.get("Humidity") != "N/A") {

                        double soFarDouble = Double.parseDouble(coldestRecordSoFar.get("Humidity"));
                        double currentDouble = Double.parseDouble(currentColdestRecord.get("Humidity"));
                        if (currentDouble < soFarDouble) {
                            coldestRecordSoFar = currentColdestRecord;
                            coldestFileSoFar = file;
                        }
                    }
                }
            }

            System.out.println("Lowest humidity was " + coldestRecordSoFar.get("Humidity") + " at " + coldestRecordSoFar.get("DateUTC"));

        }
    }

    public double averageTemperatureInFile(CSVParser parser) {

        double sum = 0;
        int rows = 0;
        for (CSVRecord record: parser) {
            
            String temperature = record.get("TemperatureF");
            double temperature_double = Double.parseDouble(temperature);

            sum += temperature_double;
            rows++;

        }
        return (sum/rows);
    }
    
    public Double averageTemperatureWithHighHumidityinFile(CSVParser parser, int value) {
        
        double sum = 0;
        int rows = 0;
        for (CSVRecord record: parser) {

            if(Integer.parseInt(record.get("Humidity")) >= value) {
                
                String temperature = record.get("TemperatureF");
                double temperature_double = Double.parseDouble(temperature);
        
                sum += temperature_double;
                rows++;
            }
            
    
        }

        if (rows == 0) {
            return null;
        }
        return (sum/rows);
        
    }
}