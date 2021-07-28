package AlgoExpert.Easy;

public class CaesarCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        if (str == null || str.length() == 0) return key == 0 ? str : "";

        key %= 26;

        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            int newPos = key + (ch[i]);
            ch[i] = newPos > 122 ? (char) ('a' + (newPos % 122) - 1) : (char) (newPos);
        }

        return new String(ch);
    }

    public static StringBuffer caesarCypherEncryptor2(String text, int s)
    {
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)( ((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        String text = "ATTACKATONCE";
        int s = 4;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + caesarCypherEncryptor(text, s));
        System.out.println("Cipher: " + caesarCypherEncryptor2(text, s));
    }


}
