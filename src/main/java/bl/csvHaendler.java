package bl;

import com.sun.java.swing.action.AlignRightAction;
import data.Pizza;
import lombok.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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


    public List<Pizza> readCSV(){
        List<Pizza> pizzas = new ArrayList<>();
        String line = "";
        final String delimiter = ",";
        try
        {
            String filePath = "res/data.txt";
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

