public class Main {
    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        bookDAO.addBook("Clean Code", "Robert Martin", 5);
        userDAO.addUser("Vijay", "vj@email.com");

        transactionDAO.borrowBook(1, 1);
        transactionDAO.returnBook(1, 1);
    }
}
