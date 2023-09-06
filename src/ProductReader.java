import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Product> productRecords = new ArrayList<>();


        final int FIELDS_LENGTH = 4;

        String ID = "";
        String Name = "";
        String Description = "";
        double Cost = 0;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
                    System.out.printf("\nLine %4d %-60s ", line, rec);
                }
                reader.close();

                InputStream in1 =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader1 =
                        new BufferedReader(new InputStreamReader(in1));

                while(reader1.ready()) {
                    rec = reader1.readLine();
                    Object[] productArray = rec.split(",");
                    Product prod = new Product(productArray[0].toString(), productArray[1].toString(), productArray[2].toString(), Double.valueOf(productArray[3].toString().trim()));
                    productRecords.add(prod);
                }
                reader1.close();

                System.out.println("\n\nData file read!");

                String[] fields;
                for(String l:lines)
                {
                    fields = l.split(",");

                    if(fields.length == FIELDS_LENGTH)
                    {
                        ID = fields[0].trim();
                        Name = fields[1].trim();
                        Description = fields[2].trim();
                        Cost = Double.parseDouble(fields[3].trim());
                        System.out.printf("\n%-8s%-25s%-25s%,.2f", ID, Name, Description, Cost);
                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }

            }
            else
            {
                System.out.println("Failed to choose a file to process.");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
