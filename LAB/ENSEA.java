import java.io.BufferedReader;
import java.io.FileReader;
    import java.io.IOException;
import java.util.ArrayList;

public class ENSEA {
    //last name | first name | groups | promo
    private ArrayList<Promotion> promotions;
    
    public ENSEA(){
        this.promotions = new ArrayList<Promotion>();
    }
    public void __init__(String path){
        try{FileReader fileReader = new FileReader(path);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine())!= null){
                    String[] column_data = line.split(",");
                    
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            // Provide the path to your CSV file
            String csvFilePath = "LAB/liste2_2020_2021.csv";

            FileReader fileReader = new FileReader(csvFilePath);
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

