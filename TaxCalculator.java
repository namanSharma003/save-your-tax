public class TaxCalculator {

    public double calculateTaxOldRegime(double income, int age) {

        double tax = 0;
        double slab1 = 250000;
        double slab2 = 500000;
        double slab3 = 1000000;

        if (age >= 60 && age < 80) slab1 = 300000;
        if (age >= 80) slab1 = 500000;

        if (income <= slab1) {
            tax = 0;
        } else if (income <= slab2) {
            tax = (income - slab1) * 0.05;
        } else if (income <= slab3) {
            tax = (slab2 - slab1) * 0.05
                + (income - slab2) * 0.20;
        } else {
            tax = (slab2 - slab1) * 0.05
                + (slab3 - slab2) * 0.20
                + (income - slab3) * 0.30;
        }

        return tax;
    }

    public double calculateTaxNewRegime(IncomeDetails income, int age) {

        double totalIncome = income.getTotalIncome();
        double tax = 0;

        if (totalIncome <= 300000) tax = 0;
        else if (totalIncome <= 600000)
            tax = (totalIncome - 300000) * 0.05;
        else if (totalIncome <= 900000)
            tax = (600000 - 300000) * 0.05
                + (totalIncome - 600000) * 0.10;
        else if (totalIncome <= 1200000)
            tax = (600000 - 300000) * 0.05
                + (900000 - 600000) * 0.10
                + (totalIncome - 900000) * 0.15;
        else if (totalIncome <= 1500000)
            tax = (600000 - 300000) * 0.05
                + (900000 - 600000) * 0.10
                + (1200000 - 900000) * 0.15
                + (totalIncome - 1200000) * 0.20;
        else
            tax = (600000 - 300000) * 0.05
                + (900000 - 600000) * 0.10
                + (1200000 - 900000) * 0.15
                + (1500000 - 1200000) * 0.20
                + (totalIncome - 1500000) * 0.30;

        return tax;
    }
}

