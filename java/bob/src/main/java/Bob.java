public final class Bob
{
  private static enum SentenceType
  {
    SAY,
    SHOUTING,
    ASKING;

  static SentenceType findSentenceType(final String sentence)
    {
      final char lastChar = sentence.charAt(sentence.length() - 1);
      return lastChar=='!'
                      ?SHOUTING
                      :lastChar=='?'
                        ?ASKING
                        :SAY;
    }
  }

  public String hey(final String sentence)
  {
    //If silence
    if(sentence.replaceAll("\\s+","").isEmpty())
    {
      return "Fine. Be that way!";
    }

    final boolean containNumber = sentence.matches(".*\\d+.*");
    final SentenceType type =SentenceType.findSentenceType(sentence);
    final boolean isForcefully = sentence.startsWith("Let's");
    final boolean isAllUpperCase = isAllUpperCase(sentence);
    System.out.println(sentence.replaceAll("\\s+","").replaceAll("/[^A-Za-z]/", "") + "   is all uppercase "+isAllUpperCase);
    final boolean isUmlauts = false;

    if ((type == SentenceType.SHOUTING || isAllUpperCase)&&!isForcefully)
    {
      return "Whoa, chill out!";
    }
    else if (type == SentenceType.ASKING)
    {
      return "Sure.";
    }
    else
    {
      return "Whatever.";
    }
  }

  private static boolean isAllUpperCase(final String sentence)
  {
    for(char c : sentence.replaceAll("\\s+","").replaceAll("/[^A-Za-z]/", "").toCharArray())
    {
      if(!Character.isUpperCase(c))
      {
        System.out.println( c+ " is not upper");
      }
    }
    return sentence.replaceAll("\\s+","").replaceAll("/[^A-Za-z]/", "").chars()
                  .map(i -> (char) i)
                  .allMatch(Character::isUpperCase);
  }
}
