public class ITRSelector {

    public String selectITR(IncomeDetails income) {
        if (income.businessIncome) return "ITR-3";
        if (income.presumptiveIncome) return "ITR-4";
        if (income.capitalGains || income.houseProperties > 1) return "ITR-2";
        return "ITR-1";
    }
}
