import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Arrays;
import java.util.List;


public class MyTxtNER {
    public static void main(String[] args)
    {
        ReadFileToString readFileToString = new ReadFileToString();

        String file_path = "C:\\Users\\user\\Desktop\\parag.txt";

        String Data = readFileToString.usingBufferedReader(file_path);

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        CoreDocument coreDocument = new CoreDocument(Data);

        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabels = coreDocument.tokens();


        String [] words = new String[coreLabels.size()];
        int k =0;
        for(CoreLabel coreLabel : coreLabels) {

            String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            System.out.println(coreLabel.originalText() + " = "+ ner);
            if (!ner.equals(0)){
                words[k] = ner;
                k++;
            }

        }
        System.out.println(Arrays.toString(words));
        int wrc=1;    //Variable for getting Repeated word count

        for(int i=0;i<words.length;i++) //Outer loop for Comparison
        {
            for(int j=i+1;j<words.length;j++) //Inner loop for Comparison
            {

                if(words[i].equals(words[j]))  //Checking for both strings are equal
                {
                    wrc=wrc+1;    //if equal increment the count
                    words[j]="0"; //Replace repeated words by zero
                }
            }
            if(words[i]!="0")
                System.out.println(words[i]+"--"+wrc); //Printing the word along with count
            wrc=1;

        }





      /*  for (int i=0;i<coreLabels.size();i++){
            int count=1;
            for (int j=i+1 ; j<coreLabels.size()-1;j++){
                if(coreLabels.get(i).originalText().equals(coreLabels.get(j).originalText()))
                {
                    count++;
                }
                }
            System.out.println(coreLabels.get(i).originalText() + " is repeated :" + count + "times");
        }*/

    }
}
