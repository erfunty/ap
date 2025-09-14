package exercises.finalExam;

public class BorrowingHistoryReport {
    private int totalBorrowings;
    private int booksNotReturned;
    private int lateReturns;

    public BorrowingHistoryReport(int totalBorrowings, int booksNotReturned, int lateReturns) {
        this.totalBorrowings = totalBorrowings;
        this.booksNotReturned = booksNotReturned;
        this.lateReturns = lateReturns;
    }

    public int getTotalBorrowings() {
        return totalBorrowings;
    }

    public int getBooksNotReturned() {
        return booksNotReturned;
    }

    public int getLateReturns() {
        return lateReturns;
    }
}
