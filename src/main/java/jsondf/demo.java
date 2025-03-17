package jsondf;




import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class demo {
    public static void main(String[] args) {
       
        String jsonFilePath = "./Data/PasswordChangeEvent.json";

 
        String arrayName = "da-DK";
        String searchString = "Sørg for at indtaste den korrekte adgangskode.";

        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            
            if (rootNode.has(arrayName) && rootNode.get(arrayName).isArray()) {
               
                JsonNode arrayNode = rootNode.get(arrayName);
                for (JsonNode element : arrayNode) {
                    if (element.isTextual() && element.asText().equals(searchString)) 
                    {
                        System.out.println("String '" + searchString + "' found in array '" + arrayName + "'");
                        return; 
                    }
                }
                System.out.println("String '" + searchString + "' not found in array '" + arrayName + "'");
            } 
            
            else 
            {
                System.out.println("Array '" + arrayName + "' not found in the JSON file.");
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }
}

