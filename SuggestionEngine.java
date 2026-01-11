public class SuggestionEngine {

    public String generateSuggestions(IncomeDetails income, Deductions ded) {
        StringBuilder sb = new StringBuilder();

        if (ded.sec80C < 150000) sb.append("- You can invest ₹").append(150000 - (int)ded.sec80C)
                .append(" more in 80C to save tax.\n");

        if (ded.nps < 50000) sb.append("- You can contribute ₹").append(50000 - (int)ded.nps)
                .append(" more in NPS to save additional tax.\n");

        if (ded.sec80D_self < 25000) sb.append("- Consider paying additional ₹").append(25000 - (int)ded.sec80D_self)
                .append(" for self/family health insurance (80D).\n");

        if (ded.sec80D_parents < 50000) sb.append("- Consider paying additional ₹").append(50000 - (int)ded.sec80D_parents)
                .append(" for parents' health insurance (80D).\n");

        if (income.homeLoanInterest < 200000 && income.houseProperties > 0) sb.append("- You can claim more home loan interest under Section 24.\n");

        return sb.length() == 0 ? "All possible deductions claimed." : sb.toString();
    }
}
