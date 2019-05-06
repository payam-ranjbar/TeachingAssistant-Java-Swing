package DragonManager.FileManagers;

import DragonManager.Models.Dragon;

import java.io.*;
import java.util.ArrayList;

public class DragonManager {

    public static void SaveDragon(Dragon dragon) throws Exception {
        File sourceFile = new File(DBProperties.DRAGONS_FILE_PATH);

        if (!sourceFile.exists()) {
            sourceFile.createNewFile();
        }

        // creating a FileWriter object
        // the second passed parameter represent the appending mode of writing into the file
        FileWriter writer = new FileWriter(sourceFile, true);

        // writing the string value of serialized object in JSON
        writer.write(dragon.serialize().toString() + "\n");

        writer.close();
    }



    public static ArrayList<Dragon> LoadDragons() throws Exception {
        File sourceFile = new File(DBProperties.DRAGONS_FILE_PATH);



        // a string variable for holding each line of the file
        String line = "";

        // the return array list
        ArrayList<Dragon> dragons = new ArrayList<>();

        // a variable to storing read data from file
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(sourceFile));
            line = reader.readLine();
            while (line != null) {
                Dragon dragon = new Dragon();
                dragon.deserialize(line);

                // adding created object to the result array list
                dragons.add(dragon);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dragons;
    }
}
