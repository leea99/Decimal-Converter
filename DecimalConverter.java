import java.util.*; 

public class DecimalConverter
{  
   public static void main(String[] args)
   {
      System.out.println("Please enter a positive number");
      Scanner input = new Scanner(System.in);
      int number = input.nextInt();
      while (!(number > 0))
      {
         System.out.println("Enter a positive number");
         number = input.nextInt();
      }
      binaryConvert(number);
      hexConvert(number);
   } 
   
   public static void binaryConvert(int number)
   {
      int temp;
      String binaryAnswer = "";
      
      LinkedList<Integer> stack = new LinkedList<Integer>();   //Used to reverse the order of characters so the binary is correct
      while (number != 0)
      {
         temp = number % 2;                                    //Holds the modulo temporarily 
         stack.push(temp);                                     //Pushes the modulo into the linked list
         number = (number / 2);
      }
      while (!stack.isEmpty()) 
      {
         binaryAnswer += Integer.toString(stack.pop());        //Combines the individual integers into one string
      }
      System.out.println("Binary: " + binaryAnswer);
   }
   
   public static void hexConvert(int number)
   {
      String temp;
      String binaryAnswer = "";
      
      LinkedList<String> stack = new LinkedList<String>();     //Used to reverse the order of characters so the hexadecimal is correct
      while (number != 0)
      {
         temp = Integer.toHexString(number % 16);              //Converts the modulo into hex
         stack.push(temp);                                     //Pushes the temporary variable into the linked list
         number = (number / 16);                               
      }
      while (!stack.isEmpty()) 
      {
         binaryAnswer += stack.pop().toUpperCase();            //Combines the individual strings into one string and makes the letters uppercase
      }
      System.out.println("Hexadecimal: " + binaryAnswer);
   } 
}