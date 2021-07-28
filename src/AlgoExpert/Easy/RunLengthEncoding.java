package AlgoExpert.Easy;

public class RunLengthEncoding
{

    public static String runLengthEncoding(String string) {
        // Write your code here.
        if (string == null || string.length() == 0) return "";

        int count = 1;
        String rLEString = "";

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) != string.charAt(i) || count == 9) {
                rLEString += count + "" + string.charAt(i - 1);
                count = 0;
            }
            ++count;
        }

        System.out.println(count + "" + string.charAt(string.length() - 1));
        rLEString += count + "" + string.charAt(string.length() - 1);

        return rLEString;
    }


    public static void main(String[] args)
    {
        String text = "ATTACKATONCCE";

        System.out.println(runLengthEncoding(text));
    }
}
