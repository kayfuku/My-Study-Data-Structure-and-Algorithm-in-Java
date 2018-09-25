package cs111c;

public class MinChar
{

    public static void main(String[] args)
    {

        char r = minChar("grieooebwoihocwi");
        System.out.println(r);

        r = minCharR("grieooebwoihocwi");
        System.out.println(r);

    }

    // (By myself)
    private static char minChar(String s)
    {
        char min = s.charAt(0);
        for (int i = 0; i < s.length(); i++)
        {
            if (min > s.charAt(i))
            {
                min = s.charAt(i);
            }
        }
        return min;
    }

    // Recursive solution. (By CS111C)
    private static char minCharR(String s)
    {
        // Pre: 's' is not empty String.
        char first = s.charAt(0);
        if (s.length() == 1)
        {
            return first;
        }
        char minOfRest = minChar(s.substring(1));
        if (first < minOfRest)
        {
            return first;
        }
        else
        {
            return minOfRest;
        }
    }

}
