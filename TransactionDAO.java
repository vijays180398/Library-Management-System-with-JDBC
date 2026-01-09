import java.sql.*;

public class TransactionDAO {

    public void borrowBook(int bookId, int userId) {

        String insertTransaction =
                "INSERT INTO transactions (book_id, user_id) VALUES (?, ?)";
        String updateBook =
                "UPDATE books SET available_copies = available_copies - 1 WHERE book_id=? AND available_copies > 0";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(updateBook);
                 PreparedStatement ps2 = con.prepareStatement(insertTransaction)) {

                ps1.setInt(1, bookId);
                int rows = ps1.executeUpdate();

                if (rows == 0) {
                    System.out.println("Book not available");
                    con.rollback();
                    return;
                }

                ps2.setInt(1, bookId);
                ps2.setInt(2, userId);
                ps2.executeUpdate();

                con.commit();
                System.out.println("Book borrowed successfully");

            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int transactionId, int bookId) {

        String updateTransaction =
                "UPDATE transactions SET return_date = CURRENT_TIMESTAMP WHERE transaction_id=?";
        String updateBook =
                "UPDATE books SET available_copies = available_copies + 1 WHERE book_id=?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(updateTransaction);
                 PreparedStatement ps2 = con.prepareStatement(updateBook)) {

                ps1.setInt(1, transactionId);
                ps2.setInt(1, bookId);

                ps1.executeUpdate();
                ps2.executeUpdate();

                con.commit();
                System.out.println("Book returned successfully");

            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
