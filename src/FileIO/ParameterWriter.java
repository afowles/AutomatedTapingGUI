package FileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Adam Fowles on 1/10/2016.
 */
public class ParameterWriter
{
    private double[] params;

    public ParameterWriter(double[] params)
    {
        this.params = params;
    }

    public void writeFile(String filename)
    {
        BufferedWriter writer = null;
        try
        {
            File f = new File(filename);
            if (!f.exists()) {f.createNewFile();}
            FileWriter fileWriter = new FileWriter(filename);
            writer = new BufferedWriter(fileWriter);


            writer.write("c Parameter file\n");
            writer.write("c <x increment> <x speed> <y increment> <y speed> <max part RPM>\n");
            writer.write("p ");
            for (double d: params)
            {
                writer.write(d + " ");
            }
            writer.close();
        }

        catch(IOException e)
        {
            System.out.println("Couldnt write file");
        }
    }


}