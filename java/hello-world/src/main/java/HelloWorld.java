public class HelloWorld {
    public static String hello(String name) {
        final String template = "Hello, %s!";
        return String.format( template, isBlank(name)? "World" : name );
    }

    private static boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}
