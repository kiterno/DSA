package google.com.strings;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String s = "-yD-tuI-wm-9sCUp5";
        int k=13;
        System.out.println(ReFormatString(s, k));

        s = "2-5g-3-J"; k=2;
        System.out.println(ReFormatString(s, k));
    }

    static String ReFormatString(String s, int k){
        StringBuilder stringBuilder=new StringBuilder();
        int start = 0;
        while(start < s.length() && s.charAt(start) == '-')
            start++;
        int count = k;
        for(int i=s.length()-1; i>=start; i--){
            char ch = s.charAt(i);
            if(ch == '-') {
                continue;
            }
            else{
                stringBuilder.append(Character.toUpperCase(ch));
                count --;
            }
            if(count == 0){
                if(i!=start) stringBuilder.append('-');
                count = k;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
