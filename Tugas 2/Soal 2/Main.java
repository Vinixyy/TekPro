import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        Department d1 = new Department("IT");
        EmploymentType t1 = new EmploymentType("Full Time");

        Employee e1 = new Employee(1, "Andi", d1, t1, 5000000);
        Employee e2 = new Employee(2, "Budi", d1, t1, 6000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(e1);
        service.addEmployee(e2);

        System.out.println("Nama   : " + e1.getName());
        System.out.println("ID     : " + e1.getId());
        System.out.println("Dept   : " + e1.getDepartment().getName());
        System.out.println("Gaji   : " + e1.getSalary());
        System.out.println("Tipe   : " + e1.getType().getType());
        service.raiseSalary(e1.getId(), 10);
        System.out.println("Gaji setelah naik: " + e1.getSalary() + "\n");

        System.out.println("Nama   : " + e2.getName());
        System.out.println("ID     : " + e2.getId());
        System.out.println("Dept   : " + e2.getDepartment().getName());
        System.out.println("Gaji   : " + e2.getSalary());
        System.out.println("Tipe   : " + e2.getType().getType());
        service.raiseSalary(e2.getId(), 50);
        System.out.println("Gaji setelah naik: " + e2.getSalary());

        System.out.println("Total karyawan: " + Employee.getTotalEmployee());
    }
}
