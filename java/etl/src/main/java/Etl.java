import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        final HashMap<String,Integer> transformedMap = new HashMap<>();
        old.entrySet().forEach( entry -> entry.getValue()
            .forEach( value -> transformedMap.put( value.toLowerCase(), entry.getKey() ) ) );
        return transformedMap;
    }
}
