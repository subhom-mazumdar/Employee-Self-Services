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
    public static void addEmployee(ArrayList<Iad> employees,String emp)
    {
        employees.add(new Iad(emp));
    }
    public static boolean findEmployee(ArrayList<Iad> employees,String emp)
    {
        boolean flag=false;
        for(Iad id:employees)
        {
            if(id.empId.equals(emp))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
}