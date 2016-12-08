import java.text.Normalizer;

public final class Pangrams
{
    public static boolean isPangram(String sentence)
    {
        final String lowCaseCharString = Normalizer.normalize(sentence, Normalizer.Form.NFD)
                                                    .replaceAll("[^\\p{ASCII}]", "") //Remove non ascii chars
                                                    .toLowerCase()
                                                    .replace("[^a-z]","");
        boolean isPangram = true;
        for(char c = 'a'; isPangram && c <= 'z';c++)
        {
            //If char c exists in the sentence
            isPangram &= (lowCaseCharString.indexOf(c)>=0);
        }
        return isPangram;
    }
}
