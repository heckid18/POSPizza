package bl;

import data.Pizza;
import lombok.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

@Data
public class csvHaendler {



    private List<Pizza> data;
    /*

    private String filepath;
    private String rawdata;

    Scanner sc= new Scanner(filepath);
    */

    public void writeCSV(String filename, List<Pizza> data) {
        try {
            File myObj = new File("filename.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Pizza p : data) {

        }
    }


    public void readCSV(){
        String line = "";
        final String delimiter = ",";
        try
        {
            String filePath = "/test/example.csv";
            FileReader fileReader = new FileReader(filePath);

            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
                String[] token = line.split(delimiter);    // separate every token by comma
                System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

