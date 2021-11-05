package fit.core;

public class IrpfCalculator {
    public static Double calculateBaseSalary(double totalSalary) {
        return totalSalary *  (100-11)/100;
    }

    public static Double calculateExemption() {
        return 1903.98;
    }

    public static Double calculateDiscount(double baseSalary) {
        return baseSalary - calculateExemption();
    }

    public static Double calculateTaxLayer(double baseSalary) {
        var result  = 0.0;
        if(baseSalary >= 1903.99 && baseSalary <= 2826.65){
            result = 7.5;
        }else if(baseSalary >= 2826.66 && baseSalary <= 3751.05){
            result = 15.0;
        }else if(baseSalary >= 3751.06 && baseSalary <= 4664.68){
            result = 22.5;
        }else if(baseSalary > 4664.68){
            result = 27.5;
        }
        return result/100;
    }

    public static Double calculateIrpf(double totalSalary) {
        var baseSalary = calculateBaseSalary(totalSalary);
        return calculateDiscount(baseSalary) * calculateTaxLayer(baseSalary);
    }

}
