public class Palindrome {
    public boolean isPalindrome(String string) {
        if(string == null || string.isEmpty()) {
            return false;
        }
        
        return string.replaceAll("\\W","")
                   .equalsIgnoreCase(new StringBuilder(string.replaceAll("\\W",""))
                   .reverse()
                   .toString());
    }
}
