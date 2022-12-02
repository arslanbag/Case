import java.text.NumberFormat;
import java.text.DecimalFormat;
public class Employee
{
    String name;
    double salary;
    int workHours;
    short hireYear;
    public Employee(String name, double salary, int workHours, short hireYear)
    {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public double tax()
    {
        double taxPercent = (salary < 1000) ? 0 : 3;
        return (salary*taxPercent)/100;
    }
    public  double bonus()
    {
        int bonusHourPrice = (workHours > 40) ? 30 : 0;
        int weekBonusPrice = (workHours-40) * bonusHourPrice;
        return weekBonusPrice * 4;
    }
    public double raiseSalary()
    {
        int workYear = Math.max((2021 - hireYear), 0);
        int raisePercent = (workYear > 9 && workYear < 20) ? 10 : (workYear > 19) ? 15 : 5;
        return ((salary-tax()+bonus()) * raisePercent)/100;
    }
    public String toString()
    {
        //Turkish Price Format
        NumberFormat currency = new DecimalFormat("#,##0.00"+"₺");

        //Variables
        double tax =  tax();
        int    taxPercent = (tax == 0) ? 0 : 3;
        double bonus =  bonus();
        double raiseSalary = raiseSalary();
        int    raisePercent = (int)((100*raiseSalary)/(salary-tax+bonus));
        double sumSalaryBonusTax = salary-tax+bonus;
        double sumSalaryRaiseBonusTax = salary+raiseSalary+bonus-tax;
        String br = "\n";
        String returnString;

        //Out
        returnString =  " || Adı ve Soyadı :: "                   +name+br;
        returnString += " || Maaşı :: "                           +currency.format(salary)+br;
        returnString += " || Haftalık Çalışma Saati :: "          +workHours+"s"+br;
        returnString += " || İşe Başlangıç Yılı :: "              +hireYear+br;
        returnString += " || Vergi(%"+taxPercent+") :: "          +currency.format(tax)+br;
        returnString += " || Bonus(ayılık) :: "                   +currency.format(bonus)+br;
        returnString += " || Maaş Artışı (%"+raisePercent+") :: " +currency.format(raiseSalary)+br;
        returnString += " || Maaş + Bonus - Vergi  :: "           +currency.format(sumSalaryBonusTax)+br;
        returnString += " || Toplam Maaş :: "                     +currency.format(sumSalaryRaiseBonusTax)+br;

        return returnString;
    }
}
