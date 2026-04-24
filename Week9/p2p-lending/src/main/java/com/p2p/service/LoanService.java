package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        validateBorrower(borrower);
        validateAmount(amount);
        Loan loan = new Loan();

        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }
        return loan;
    }

    private void validateBorrower(Borrower borrower) {

        if (!borrower.canApplyLoan()) {

            logger.error("Validasi Gagal: Borrower belum terverifikasi (KYC)");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Validasi Gagal: Nominal pinjaman tidak valid ({})", amount);
            throw new IllegalArgumentException("Amount Harus > 0");
        }
    }
}