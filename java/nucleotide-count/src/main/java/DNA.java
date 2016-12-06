import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;

public class DNA {

    private final Map< Character, Integer > counts = new HashMap<>(
     Stream.of( 'A', 'C', 'G', 'T' ).collect( Collectors.toMap( key -> key, key -> 0 ) ) );

    public DNA(final String DnaString)
    {
        DnaString.chars()
            .mapToObj( i -> (char) i )
            .filter( c -> counts.keySet().contains( c ) )
            .forEach( c -> counts.put( c, counts.get( c ) + 1 ) );
    }

    public Map<Character, Integer> nucleotideCounts()
    {
        return Collections.unmodifiableMap(counts);
    }

    public int count(char c)
    {
        if (!counts.keySet().contains(c)) {
          throw new IllegalArgumentException();
        }
        return counts.get(c);
    }
}
