import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import static java.time.LocalTime.MAX;


public class AnalyseMyTxt {
    public static void main(String [] args){

        ReadFileToString readFileToString = new ReadFileToString();

        String file_path = "C:\\Users\\user\\Desktop\\parag.txt";

        String Data = readFileToString.usingBufferedReader(file_path);

        StanfordCoreNLP stanfordcoreNLP = Pipeline.getPipeline();


        CoreDocument coreDocument = new CoreDocument(Data);

        stanfordcoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        int count=0;
        int countP=0;
        int countN=0;
        int countG=0;
        for(CoreSentence sentence : sentences)
        {
            String sentiment = sentence.sentiment();
            System.out.println(sentiment + " => " + sentence);
            if (sentiment.equals("Positive"))
            {
                countP++;
            }
            else if (sentiment.equals("Negative") )
            {
                countN++;
            }
            else
            {
                countG++;
            }

            count++;
        }
        System.out.println("\n\n Positive, Negative and Neutral Numbers:");
        System.out.println("negative number: "+ countN);
        System.out.println("positive number: "+countP);
        System.out.println("Neutral number: "+countG);

        double a = Double.valueOf(countP)/Double.valueOf(count);
        double b = Double.valueOf(countN)/Double.valueOf(count);
        double c = Double.valueOf(countG)/Double.valueOf(count);
        System.out.println("polarity_Averages: ");
        System.out.println("positive polarity = "+a) ;
        System.out.println("Negative polarity = "+b);
        System.out.println("neutral polarity = "+c);

        double max_polarity = Math.max(a,Math.max(b,c));
        System.out.println("the Max polarity has the value");
        System.out.println(max_polarity);
        String result;
        if (max_polarity == b)
        {
            result="Negative";
        }
        else if (max_polarity == a)
        {
            result="positive";
        }
        else
        {
            result="neutral";
        }

        System.out.println("the paragraph i used is a "+result+" paragraph");
    }


}
