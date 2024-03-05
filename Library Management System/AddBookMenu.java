import java.sql.*;
import java.util.Scanner;

public class AddBookMenu {

    public static void addBookMenu(){
        System.out.println("Reached to Book Menu");
        Book book = new Book();
        Scanner sc = new Scanner(System.in);
        int status = 0;
        while(status == 0)
        {
            try {
                System.out.println("Enter isbn code :");
                book.setIsbn_code(sc.nextLine().toString());
                System.out.println("Enter book_name :");
                book.setBook_name(sc.nextLine().toString());
                System.out.println("Enter book_desc:");
                book.setBook_desc(sc.nextLine().toString());
                System.out.println("Enter author_name :");
                book.setAuthor_name(sc.nextLine().toString());
                System.out.println("Enter subject_name :");
                book.setSubject_name(sc.nextLine().toString());
                System.out.println("Enter units_available :");
                book.setUnits_available(sc.nextInt());
                addBook(book);
                status = 1;
            } catch (SQLException e) {
                status = 0;
            }
        }
    }
    public static void addBook(Book book) throws SQLException {
        Connection connection = null;
        try {
            connection = LibUtils.getConnection();
            String sql = "INSERT INTO books(isbn_code,book_name,book_desc,author_name,subject_name,units_available) VALUES(?,?,?,?,?,?)";
            PreparedStatement pStmt = connection.prepareStatement(sql);
            pStmt.setString(1,book.getIsbn_code());
            pStmt.setString(2,book.getBook_name());
            pStmt.setString(3, book.getBook_desc());
            pStmt.setString(4, book.getAuthor_name());
            pStmt.setString(5, book.getSubject_name());
            pStmt.setInt(6,book.getUnits_available());
            int k = pStmt.executeUpdate();
            if(k>0)
            {
                System.out.println("Book add successfully");
            }else {
                connection.rollback();
            }
            connection.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
}
