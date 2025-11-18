// package ActiveDirectory;

import java.util.*;
public class Iad
{
    public String empId;
    public String password;
    public Iad(String empId)
    {
        this.empId=empId;
        password="mycompany";
    }
    public Iad()
    {
        
    }
    public static void addEmployeeAdmin(ArrayList<Iad> employees,ArrayList<Supervisor> sup,String emp)
    {
        if(Iad.findEmployee(employees, emp)!=null)
            System.out.println("EID exists, cannot be reused");
        else
        {
            employees.add(new Iad(emp));
            sup.add(new Supervisor("1111",emp));
            System.out.println(emp+" have been recruited");
        }
    }
    public static Iad findEmployee(ArrayList<Iad> employees,String emp)
    {
        Iad flag=null;
        for(Iad id:employees)
        {
            if(id.empId.equals(emp))
            {
                flag=id;
                break;
            }
        }
        return flag;
    }
}