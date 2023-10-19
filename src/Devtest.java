import java.util.Scanner;

public class Devtest
{
    public static Scanner tester = new Scanner(System.in);

    public static void main(String[] args)
    {
        String firstName = "";
        String lastName = "";
        int age = 0;
        double salary = 0.0;
        int favNum = 0;
        boolean question = false;
        String repeat = "";


        firstName = getNonZeroLenString(tester, "Enter your first name");
        System.out.println("Name is : " + firstName);

        lastName = SafeInput.getNonZeroLenString(tester, "Enter your last name");
        System.out.println("Name is : " + lastName);

        age = getInt(tester, "Enter your age");
        System.out.println("Age is " + age);

        salary = getDouble(tester, "Enter your salary");
        System.out.println("Salary is " + salary);

        favNum = getRangedInt(tester, "Enter your favorite number", 1, 10 );
        System.out.println("Favorite number is " + favNum);

        salary = getRangedDouble(tester, "Enter your salary", 1, 100000);
        System.out.println("Salary is " + salary);

        question = getYNConfirm(tester, "Would you like to continue?");
        System.out.println("Your answer is " + question);

        repeat = getRegExString(tester, "What string should be repeated?", "here");
        System.out.println("Your answer is " + repeat);
    }
    //all of the methods go here


    //as we test them, wewill copy them into SafeInput

    /**
     *
     *returns a string from the user that has at least one character
     * Returns a string from the user that has at least one character
     * @param pipe scanner to use to read the string
     * @param prompt string that tells the user what to input
     * @return string obtained by the user that is at least length 1
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        boolean done = false;
        String response = " ";
        do {
            // display the prompt
            System.out.print(prompt + ": ");
            // get the input
            response = pipe.nextLine();
            //check if it is valid and end the loop if it is
            if(response.length() > 0)
            {
                done = true;
            }
            else
            {
                System.out.println("\nYou must enter at least on character!\n");
            }
        }while(!done);
        return response;
    }

    /**
     * get an int form the user with no constatints on its range
     * @param pipe scanner to use for input
     * @param prompt msg for user
     * @return
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        String trash = "";
        boolean done = false;
        int val = 0;
        do {
            // display the prompt
            System.out.print(prompt + ": ");
            // get the input
            if(pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                done = true;
            }

            else // don't have an int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid int!");
            }
        }while(!done);
        return val;
    }

    /**
     * gets an unconstrained double value from the user using scanner
     * @param pipe scanner to use for the input
     * @param prompt msg to user tellin them what to input
     * @return a unconstrained double value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        String trash = "";
        boolean done = false;
        double val = 0;
        do {
            // display the prompt
            System.out.print(prompt + ": ");
            // get the input
            if(pipe.hasNextInt())
            {
                val = pipe.nextDouble();
                pipe.nextLine(); // clear buffer
                done = true;
            }

            else // don't have an int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid double!");
            }
        }while(!done);
        return val;
    }

    /**
     *
     * @param pipe
     * @param prompt
     * @param low
     * @param high
     * @return
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        String trash = "";
        boolean done = false;
        int val = 0;
        do {
            // display the prompt
            System.out.print(prompt + "["+ low + " - " + high + "]: ");
            // get the input
            if(pipe.hasNextInt()) {
                val = pipe.nextInt();
                pipe.nextLine(); // clear buffer

                if (val >= low && val <= high)
                {
                    done = true;
                } else
                {
                    System.out.println("" + val + " is not in the range [" + low + " - " + high + "]");
                }
            }
            else // don't have an int

            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid int!");
            }
        }while(!done);
        return val;
    }

    /**
     *
     * @param pipe scanner for inpuit
     * @param prompt msg for user
     * @param low low boundary for inclusive range
     * @param high high boundary for inclusive range
     * @return
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        String trash = "";
        boolean done = false;
        double val = 0;
        do {
            // display the prompt
            System.out.print(prompt + "["+ low + " - " + high + "]: ");
            // get the input
            if(pipe.hasNextDouble()) {
                val = pipe.nextDouble();
                pipe.nextLine(); // clear buffer

                if (val >= low && val <= high)
                {
                    done = true;
                } else
                {
                    System.out.println("" + val + " is not in the range [" + low + " - " + high + "]");
                }
            }

            else // don't have an int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid int!");
            }
        }while(!done);
        return val;
    }

    /**
     *
     * @param pipe scanner object that you created in main in console
     * @param prompt message to display as the prompt for the input
     * @return
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String respYN = "";
        boolean done = false;

        do {
            System.out.println(prompt + "[Y/N]: ");
            respYN = pipe.nextLine();
            if (respYN.equalsIgnoreCase("Y")) {
                done = true;
            } else if (respYN.equalsIgnoreCase("N")) {
                done = true;
            } else {
                System.out.println("You must enter [Y/N]: ");
            }
        } while (!done);
        return done;
    }

    /**
     *
     * @param pipe Scanner object that you created in main in the usual way i.e. in or console
     * @param prompt message to display as the prompt for the input.
     * @param regEx regEx pattern in java String format to use for matching
     * @return
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.println(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("What you entered does not match the pattern " + regEx);
            }
        } while (!done);
        return retVal;
    }
}//overall close