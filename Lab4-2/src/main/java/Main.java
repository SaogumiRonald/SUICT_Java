public class Main {
    public static void main(String[] args) {
        Decoder decoder = new Decoder();

        System.out.println(decoder.decodeVowel("t2st"));
        System.out.println(decoder.decodeConsonant("sers"));
        System.out.println(decoder.decodeConsonant(""));
        System.out.println(decoder.decodeConsonant("123456789"));
    }
}