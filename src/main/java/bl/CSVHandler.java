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
                System.out.println("Token 0:"+token[1]);
               pizzas.add(new Pizza(Integer.parseInt(token[0]), token[1],Float.valueOf(token[2]),token[3]));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return pizzas;
    }
}

