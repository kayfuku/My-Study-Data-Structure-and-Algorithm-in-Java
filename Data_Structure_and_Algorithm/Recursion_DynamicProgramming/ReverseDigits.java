package cs111c;

public class ReverseDigits
{

    public static void main(String[] args)
    {
        int r = reverse(321);
        
        
        reverseDigits(321);

    }
    
    
    // (By myself) It was no need to return something! 
    private static int reverse(int n)
    {
        if (n < 10)
        {
            System.out.println(n);
            return n;
        } 
        else {
            System.out.print(n % 10);
            return reverse(n / 10);
        }
    }
    
    // Sample solution. (By CS111C)
    private static void reverseDigits(int n)
    {
        if (n > 0)
        {
            if (n < 10)
            {
                System.out.println(n);
            }
            else
            {
                System.out.print(n % 10);
                reverseDigits(n / 10);
                
            }
        }
        
    }

 

}
