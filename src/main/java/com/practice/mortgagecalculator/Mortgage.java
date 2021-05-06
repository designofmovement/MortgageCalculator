package com.practice.mortgagecalculator;

import org.apache.commons.math3.util.Precision;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Mortgage {

    public double principal;

    public double annualInterest;

    public double years;

    public double taxRate;

    public double downPayment;

    public double insuranceCostYearly;

    public double salesPrice;


    public Mortgage(String salesPrice, String annualInterest, String taxRate, String years, String insuranceCostYearly, String downPayment){


        this.salesPrice=stringToDouble(salesPrice);
        this.downPayment=stringToDouble(downPayment);
        this.principal=setPrincipal(this.salesPrice, this.downPayment);
        this.annualInterest = setAnnualInterest(stringToDouble(annualInterest));
        this.years=stringToDouble(years);
        this.insuranceCostYearly=stringToDouble(insuranceCostYearly);
        this.taxRate=setTaxRate(stringToDouble(taxRate));


    }


    public double calculatePayment(){
        double monthlyInterest = getMonthlyInterest();
        double totalMonths = this.years*12;
        double  monthlyPayment= roundToDollar((this.principal*getMonthlyInterest()) / (1-Math.pow(1+getMonthlyInterest(), -totalMonths)));
        //start rounding doubles.
        //monthlyPayment= Precision.round(monthlyPayment, 0);
        double taxes = roundToDollar(getMonthlyTaxes());
        double insurance = roundToDollar(getMonthlyInsurance());
        return monthlyPayment+ taxes + insurance;




//        double principalAndInterest = principal * (monthlyInterest * Math.pow(1+monthlyInterest,years)
//                / (Math.pow(1+monthlyInterest,years) -1));
//        double taxes = getMonthlyTaxes();
//        double insurance = getMonthlyInsurance();
//        return principalAndInterest+ taxes + insurance;
    }





public double setPrincipal(double price, double downPayment){
    double totalDownPayment = price*(downPayment*.01);
    return price - totalDownPayment;
}

private double setAnnualInterest(double rate){
//do not allow zero interest, as this is not a reverse mortgage.
    double result;

        if(rate==0.00){
            result=.001;
        }
        else{
             result = rate*.01;

        }
        return result;

}

private double setTaxRate(double rate){
        double result = rate*.01;
        return result;
}

    public double getMonthlyInterest() {
        return annualInterest / 12 ;
    }

    public double getMonthlyTaxes(){

       double result = salesPrice *taxRate;
        return result / 12;
    }

    public double getMonthlyInsurance(){
        return insuranceCostYearly /12;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public double getYears() {
        return years;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public double getInsuranceCostYearly() {
        return insuranceCostYearly;
    }

    private double roundToDollar(double number){

        return Precision.round(number, 0);

    }

    private double stringToDouble(String text){

        return Double.parseDouble(text);

    }

}
