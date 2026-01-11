public class IncomeDetails {
    double salary = 0;
    double pension = 0;
    double interestIncome = 0;
    double rentalIncome =0;
    boolean capitalGains = false;
    boolean businessIncome = false;
    boolean presumptiveIncome = false;
    int houseProperties = 0;
    double homeLoanIntrest = 0;
    public double homeLoanInterest;
    public double getTotalIncome() {
        return salary + pension + interestIncome + rentalIncome;
    }
}
