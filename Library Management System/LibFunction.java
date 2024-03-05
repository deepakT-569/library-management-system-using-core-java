import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibFunction {
    public static void callIssueBook () {
        System.out.println("Reached to issue book menu :");
        Scanner sc = new Scanner(System.in);
        Member member = new Member();
        Book book = new Book();
        int status = 0;
        while (status == 0) {
            try {
                System.out.println("Enter member id :");
                member.setMember_id(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter isbn code :");
                book.setIsbn_code(sc.nextLine().toString());
                issueBook(member, book);
                status = 1;
            } catch (SQLException e) {
                status = 0;
            }
        }
    }

    private static void issueBook (Member member, Book book) throws SQLException {
        Connection connection = null;
        try {
            connection = LibUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT m.member_id,b.isbn_code,mbr.rec_id FROM member m,books b,member_book_record mbr WHERE m.member_id = '" + member.getMember_id() + "' AND b.isbn_code = '" + book.getIsbn_code() + "' AND m.member_id = mbr.member_id AND b.isbn_code = mbr.isbn_code AND mbr.dor is null";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("Book is already issued! Please ");
            } else {
                int k = statement.executeUpdate("INSERT INTO member_book_record VALUES(1,'" + member.getMember_id() + "','" + book.getIsbn_code() + "','2023-03-03',null)");
                if (k > 0) {
                    k = statement.executeUpdate("UPDATE books b SET units_available = (units_available - 1) where isbn_code = '" + book.getIsbn_code() + "'");
                    System.out.println("Book issued successfully ! Happy Reading");
                } else {
                    connection.rollback();
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callReturnBook () {
        System.out.println("Reached to Return Menu");
        Scanner sc = new Scanner(System.in);
        Member member = new Member();
        Book book = new Book();
        int status = 0;
        while (status == 0) {
            try {
                System.out.println("Enter member Id :");
                member.setMember_id(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter isbn code :");
                book.setIsbn_code(sc.nextLine().toString());
                returnBook(member, book);
                status = 1;
            } catch (SQLException e) {
                status = 0;
            }
        }
    }

    private static void returnBook (Member member, Book book) throws SQLException {
        Connection connection = null;
        try {
            connection = LibUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT m.member_id,b.isbn_code,mbr.rec_id FROM member m,books b,member_book_record mbr WHERE m.member_id =" + member.getMember_id() + " AND b.isbn_code = " + book.getIsbn_code() + " AND m.member_id = mbr.member_id AND b.isbn_code = mbr.isbn_code AND mbr.dor is null";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int k = statement.executeUpdate("UPDATE member_book_record mbr SET mbr.dor = '2024-03-05' WHERE mbr.rec_id = "+resultSet.getInt(3)+"");
                if (k > 0) {
                    statement.executeUpdate("UPDATE books b SET b.units_available = (units_available + 1) WHERE b.isbn_code = " + book.getIsbn_code() + "");
                    System.out.println("Book has been returned successfully! Thank you for reading!");
                } else {
                    connection.rollback();
                }
            }else {
                System.out.println("Book is not issued!");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
