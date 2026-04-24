package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    @Test
    public void shouldRejectLoanWhenBorrowerNotVerified() {
        logger.info("--> Menjalankan TC-01.");
        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================
        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);
        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);
        // =========================
        // Act (Action)
        // =========================
        // Borrower mencoba mengajukan loan
        // Sistem harus menolak dengan melempar exception
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        logger.info("--> TC-01 Berhasil: Sistem menolak borrower yang belum diverifikasi.");
    }

    @Test
    public void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        logger.info("--> Menjalankan TC-02");

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal invalidAmount = BigDecimal.valueOf(0);

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, invalidAmount);
        });

        logger.info("--> TC-02 Berhasil: Sistem menolak nominal pinjaman <= 0.");
    }

    @Test
    public void shouldApproveLoanWhenCreditScoreHigh() {
        logger.info("--> Menjalankan TC-03");

        Borrower borrower = new Borrower(true, 750);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED, loan.getStatus());

        logger.info("--> TC-03 Berhasil: Pinjaman disetujui.");
    }

    @Test
    public void shouldRejectLoanWhenCreditScoreLow() {
        logger.info("--> Menjalankan TC-04");

        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED, loan.getStatus());

        logger.info("--> TC-04 Berhasil: Pinjaman ditolak.");
    }
}