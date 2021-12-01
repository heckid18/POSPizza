package bl;

import data.Pizza;
import lombok.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Data
public class CSVHandler {



    private List<Pizza> data;
    /*

    private String filepath;
    private String rawdata;

    Scanner sc= new Scanner(filepath);
    */


    public List<Pizza> readCSV(String filePath){
        List<Pizza> pizzas = new ArrayList<>();
        String line = "";
        final String delimiter = ",";
        try
        {
            FileReader fileReader = new FileReader(filePath);

            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)
            {
                String[] token = line.split(delimiter);
               pizzas.add(new Pizza(token[0],(float) Integer.parseInt(token[1]),token[2]));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return pizzas;
    }
}

