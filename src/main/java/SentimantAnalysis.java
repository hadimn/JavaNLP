
import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;


public class SentimantAnalysis {
    public static void main(String [] args){
        // -2,-1,0,1,+1
        // 0-1 => 0,0.1,0.2,...,1.0
        StanfordCoreNLP stanfordcoreNLP = Pipeline.getPipeline();

        String text = "kill him."
                + "I love programming. "
                + "I study Java";

        CoreDocument coreDocument = new CoreDocument(text);

        stanfordcoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sentence : sentences){
            String sentiment = sentence.sentiment();
            System.out.println(sentiment + " => " + sentence);
        }

    }
}
