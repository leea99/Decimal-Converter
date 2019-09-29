import java.util.*; 

public class DecimalConverter
{  
   public static void main(String[] args)
   {
      System.out.println("Please enter a number between -32,768 and 32,767");
      Scanner input = new Scanner(System.in);
      int number = input.nextInt();
      while (number < -32768 || number > 32767)
      {
         System.out.println("Enter a positive number");
         number = input.nextInt();
      }
      binaryConvert(number);
      if (number >= 0)
         hexConvert(number);
   } 
   
   private static void binaryConvert(int number)
   {
      int temp;
      boolean isNegative = false;
      String binaryAnswer = "";
      int carry = 1;
      int bits;
      
      if (number >= -8 && number <= 7)                         //Sets the appropriate number of bits
         bits = 4;
      else if (number >= -128 && number <= 127)
         bits = 8;
      else if (number >= -2048 && number <= 2047)
         bits = 12;
      else
         bits = 16;
     
      LinkedList<Integer> stack = new LinkedList<Integer>();  //Used to reverse the order of characters so the binary is correct
      ArrayList<Integer> stack2 = new ArrayList<Integer>();   //Used to reverse the order of characters so the binary is correct
      ArrayList<Integer> twosComp = new ArrayList<Integer>();
      
      if (number < 0)
         isNegative = true;
      
      while (number != 0)
      {
         temp = number % 2;                                    //Holds the modulo temporarily
         if (isNegative == true)
         {  
            if (temp != 0)
               temp += 2;
         }
         stack.push(temp);                                     //Pushes the modulo into the linked list
         number = (number / 2);
      }

      for (int i = stack.size(); i < bits; i++)                //Adds the necessary number of bits
      {
         stack.add(0, 0);
      }
      
      if (isNegative == true)                               
      {
         while (!stack.isEmpty())
         {
            if (stack.pop() == 0)                              //Flips the bits for 1's comp
            {
               temp = 1;
            }
            else
               temp = 0;
               
               twosComp.add(temp);
        }  
        for (int i = twosComp.size() - 1; i >= 0; i--)        //Adds +1 to the binary number to get the 2's comp
        {     
            temp = twosComp.get(i);
            if ((temp + carry) == 0)
            {
               temp = 0;
               carry = 0;  
            }
            else if ((temp + carry) == 1)
            {
               temp = 1;
               carry = 0;
            }
            else if ((temp + carry) == 2)
            {
               temp = 0;
               carry = 1;
            }
            else
            {
               temp = 1;
               carry = 1;
            }
               stack2.add(temp);
         } 

      }
      else
      {
         while (!stack.isEmpty()) 
         {
               binaryAnswer += Integer.toString(stack.pop());     //Combines the individual integers into one string
         }
      }
      
      for (int i = stack2.size() - 1; i >= 0; i--)
      {   
          binaryAnswer += stack2.get(i);
      }     
      
      System.out.println("2's Complement Binary: " + binaryAnswer);   
   }
   
   private static void hexConvert(int number)
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
