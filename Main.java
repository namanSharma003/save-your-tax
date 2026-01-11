import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SMART INCOME TAX ESTIMATOR ===");

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        IncomeDetails income = new IncomeDetails();

        System.out.print("Enter annual salary income: ");
        income.salary = sc.nextDouble();

        System.out.print("Enter annual pension income: ");
        income.pension = sc.nextDouble();

        System.out.print("Enter interest income: ");
        income.interestIncome = sc.nextDouble();

        System.out.print("Enter rental income: ");
        income.rentalIncome = sc.nextDouble();

        System.out.print("Enter home loan interest paid: ");
        income.homeLoanInterest = sc.nextDouble();

        System.out.print("Do you have business income (true/false): ");
        income.businessIncome = sc.nextBoolean();

        System.out.print("Are you under presumptive taxation (true/false): ");
        income.presumptiveIncome = sc.nextBoolean();

        System.out.print("Number of house properties: ");
        income.houseProperties = sc.nextInt();

        // Deductions
        Deductions ded = new Deductions();

        System.out.print("80C investment: ");
        ded.sec80C = sc.nextDouble();

        System.out.print("80D self/family: ");
        ded.sec80D_self = sc.nextDouble();

        System.out.print("80D parents: ");
        ded.sec80D_parents = sc.nextDouble();

        System.out.print("NPS contribution: ");
        ded.nps = sc.nextDouble();

        System.out.print("Education loan interest: ");
        ded.eduLoan = sc.nextDouble();

        System.out.print("Donations: ");
        ded.donations = sc.nextDouble();

        // Calculations
        TaxableIncomeCalculator tic = new TaxableIncomeCalculator();
        double taxableIncome = tic.calculateTaxableIncome(income, ded);

        TaxCalculator tc = new TaxCalculator();
        double taxOld = tc.calculateTaxOldRegime(taxableIncome, age);
        double taxNew = tc.calculateTaxNewRegime(income, age);

        String bestRegime = taxOld <= taxNew ? "Old Regime" : "New Regime";

        SuggestionEngine sugg = new SuggestionEngine();
        String suggestions = sugg.generateSuggestions(income, ded);

        ITRSelector itrSel = new ITRSelector();
        String itrForm = itrSel.selectITR(income);

        // Output
        System.out.println("\n=== TAX SUMMARY ===");
        System.out.println("Total Income: ₹" + income.getTotalIncome());
        System.out.println("Total Deductions: ₹" + (income.getTotalIncome() - taxableIncome));
        System.out.println("Taxable Income: ₹" + taxableIncome);
        System.out.println("Tax (Old Regime): ₹" + taxOld);
        System.out.println("Tax (New Regime): ₹" + taxNew);
        System.out.println("Best Regime: " + bestRegime);
        System.out.println("ITR Form: " + itrForm);

        System.out.println("\n--- Tax Saving Suggestions ---");
        System.out.println(suggestions);

        sc.close();
    }
}
