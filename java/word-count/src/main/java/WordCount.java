import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public final class WordCount {
    public static Map<String, Integer> phrase(String sentence)
    {
        final String[] words = sentence.replaceAll( "[\\W&&[\\S]]", "" ).split( " " );
        final Map< String, Integer > wordCount = new HashMap<>();
        Arrays.stream( words ).filter( word -> !word.isEmpty() )
            .map( String::toLowerCase )
            .forEach( word -> wordCount.put( word, wordCount.keySet().contains( word )
                ? wordCount.get( word ) + 1
                : 1 ) );
        return wordCount;
    }
}
