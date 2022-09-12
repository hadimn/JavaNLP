import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileToString
{
    public static void main(String[] args)
    {
        String filePath = "c:/data.txt";

        System.out.println( usingBufferedReader( filePath ) );
    }
    public static String usingBufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}