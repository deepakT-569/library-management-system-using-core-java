import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Scanner;

public class AddMemberMenu {
    public static void addMemberMenu () {
        System.out.println("Reached to member menu ");
        Member member = new Member();
        Scanner sc = new Scanner(System.in);
        int memberStatus = 0;
        while (memberStatus == 0) {
            try {
                System.out.println("Enter member id :");
                member.setMember_id(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter member name :");
                member.setMember_name(sc.nextLine().toString());
                addMember(member);
                memberStatus = 1;
            } catch (NumberFormatException e) {
                memberStatus = 0;
            }
        }
    }

    public static void addMember (Member member) {
        Connection connection = LibUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO member VALUES('"+member.getMember_id()+"','"+member.getMember_name()+"','2024-03-03')";
            int k = statement.executeUpdate(sql);
            if (k > 0) {
                System.out.println("Member added Successfully");
            } else {
                connection.rollback();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}