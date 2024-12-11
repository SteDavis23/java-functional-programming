package src.chapter3StringsComparatorsFiles;

public class Chapter3StringsComparatorsFiles {
    final String DEMO_STRING = "helloWorld!";

    public static void main(String[] args) {
        new Chapter3StringsComparatorsFiles().printStringThroughStream();
        new Chapter3StringsComparatorsFiles().printStringAsCharactersThroughStream();
        new Chapter3StringsComparatorsFiles().iterateThroughStringWithCharacterStream();
    }

    public void printStringThroughStream() {
        DEMO_STRING.chars()
                .forEach(System.out::println);
    }

    public void printStringAsCharactersThroughStream() {
        DEMO_STRING.chars()
                .forEach(letter -> System.out.println((char) letter));
    }

    public void iterateThroughStringWithCharacterStream() {
        DEMO_STRING.chars()
                .mapToObj(letter -> (char) letter)
                .forEach(System.out::println);
    }

}
