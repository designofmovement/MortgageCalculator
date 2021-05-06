package com.practice.mortgagecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageTest {

    @Test
    void calculatePayment() {

        Mortgage m = new Mortgage("300000", "10", "1.2", "30", "1800", "10.0");

        double result = m.calculatePayment();
        assertEquals(result, 2819.0);
    }

    @Test
    void setPrincipal() {

                Mortgage m = new Mortgage("300000", "10.00", "1.2", "30", "1800.00", "10.00" );
        assertEquals(m.getAnnualInterest(), .1);

    }

    @Test
    void getMonthlyInterest() {
        Mortgage m = new Mortgage("300000", "10.00", "1.2", "30", "1800.00", "10.00" );


        assertEquals(m.getMonthlyInterest()*12, .10);

    }

    @Test
    void getMonthlyTaxes() {

        Mortgage m = new Mortgage("300000", "10.00", "1.2", "30", "1800.00", "10.00" );
        assertEquals(m.getMonthlyTaxes(), 300.00);

    }

    @Test
    void getMonthlyInsurance() {

        Mortgage m = new Mortgage("300000", "10.00", "1.2", "30", "1800.00", "10.00" );
        assertEquals(m.getMonthlyInsurance(), 150.00);
    }

    @Test
    void setAnnualInterest() {

        Mortgage m = new Mortgage("300000", "10.00", "1.2", "30", "1800.00", "10.00" );
        assertEquals(m.getAnnualInterest(), .1);
    }

}