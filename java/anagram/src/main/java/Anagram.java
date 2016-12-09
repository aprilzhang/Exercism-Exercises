import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    private final String word;
    private final Map< Integer, Long > counts;

    public Anagram( final String word )
    {
      this.word = word;
      this.counts = createCountMap( word );
    }

    public List< String > match( final List< String > possibleMatches )
    {
      return possibleMatches.stream()
        .filter( possibleMatch -> !possibleMatch.equalsIgnoreCase( word )
            && counts.equals( createCountMap( possibleMatch ) ) )
        .collect( Collectors.toList() );
    }

    private static Map< Integer, Long > createCountMap( final String word )
    {
      return word.toLowerCase()
        .chars()
        .boxed()
        .collect( Collectors.groupingBy( c -> c, Collectors.counting() ) );
    }
}
