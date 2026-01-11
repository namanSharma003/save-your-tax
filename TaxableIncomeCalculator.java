public class TaxableIncomeCalculator {
    public double calculateTaxableIncome(IncomeDetails income, Deductions ded) {

        double sec80C = Math.min(ded.sec80C, 150000);
        double sec80D_self = Math.min(ded.sec80D_self, 25000);
        double sec80D_parents = Math.min(ded.sec80D_parents, 50000);
        double nps = Math.min(ded.nps, 50000);
        double homeLoanIntrest = Math.min(income.homeLoanIntrest, 200000);

        double standardDedection = 50000;
        double totalDeductions = sec80C + sec80D_self + sec80D_parents + nps + ded.eduloan +
                ded.donation + homeLoanIntrest + standardDedection;
        double taxable = income.getTotalIncome() - totalDeductions;
        return Math.max(taxable, 0);

    }
}
