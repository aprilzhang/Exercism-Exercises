import java.util.stream.IntStream;

public class Hamming {

  public static int compute(final String word1, final String word2)
  {
    //Check length equal
    if(word1.length()!=word2.length())
    {
      throw new IllegalArgumentException();
    }

    final char[] chars1 = word1.toCharArray();
    final char[] chars2 = word2.toCharArray();
    //Compute hamming distance
    return (int)IntStream.range(0, word1.length())
             .filter(i->chars1[i]!=chars2[i])
             .count();
  }
}
