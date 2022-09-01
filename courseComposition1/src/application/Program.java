package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        /*os parametros do new Worker é: o nome que eu digitar + uma instancia de WorkerLevel no valor
         que digitei + salario base que eu digitei + assossiado a ele tem um novo departamento e nome desse
         departamento sera o nome que eu digitei*/
        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel),
                        baseSalary, new Department(departmentName));

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date: ");
            //o parse eh necessario para converter de SimpleDateFormat para String (se nao n leva)
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            //instanciei os contratos
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            //associei os contratos inciados ao trabalhador
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        //isolei mes e ano em variveis distintas a partir do metodo substring para fazer um recorte da
        //string retirando as informacoes que preciso
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": "
                            + String.format("%.2f", worker.income(year, month)));



        sc.close();
    }

}
