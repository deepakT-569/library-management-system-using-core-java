import java.util.Scanner;

public class UserMenu {

    public static void main (String[] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        while (input != "5")
        {
            System.out.println("------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------");
            System.out.println("Select the option for service :");
            System.out.println("Enter 1 to add Book");
            System.out.println("Enter 2 to add Member");
            System.out.println("Enter 3 to issue a Book ");
            System.out.println("Enter 4 to return a Book");
            System.out.println("Enter 5 to Exit");
            input = sc.nextLine().toString();
            processingUserInput(input);
       }
    }

    public static String processingUserInput(String in)
    {
        String retVal = "5";
        switch (in)
        {
            case "1" :
                System.out.println("------------------------------------------------------------------");
                System.out.println("You have selected option 1 to add book ");
                AddBookMenu.addBookMenu();
                return "1";
            case "2" :
                System.out.println("------------------------------------------------------------------");
                System.out.println("You have selected option 2 to add member");
                AddMemberMenu.addMemberMenu();
                return "2";
            case "3" :
                System.out.println("------------------------------------------------------------------");
                System.out.println("You have selected option 3 to issue book");
                LibFunction.callIssueBook();
                return "3";
            case "4" :
                System.out.println("------------------------------------------------------------------");
                System.out.println("You have selected option 4 to return book");
                LibFunction.callReturnBook();
                return "4";
            default  :
                System.out.println("------------------------------------------------------------------");
                System.out.println("You selected to Exit!");
        }
        return retVal;
    }
}
