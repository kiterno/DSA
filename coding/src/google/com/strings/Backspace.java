package google.com.strings;

public class Backspace {
    public static void main(String[] args) {
        Backspace backspace = new Backspace();
        System.out.println(backspace.backspaceCompare("ab#c", "ad#c"));
    }
    public boolean backspaceCompare(String s, String t) {
        StringBuilder stringBuilder1 = new StringBuilder();

        extracted(s, stringBuilder1);

        StringBuilder stringBuilder2 = new StringBuilder();
        extracted(t, stringBuilder2);
//        System.out.println(stringBuilder1 +": " +stringBuilder2);
        return stringBuilder1.compareTo(stringBuilder2) == 0;
    }

    private static void extracted(String s, StringBuilder stringBuilder1) {
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '#')
                count++;
            else {
                if(count>0) {
                    count--;
                    continue;
                }
                stringBuilder1.append(s.charAt(i));
            }
        }
    }
}
