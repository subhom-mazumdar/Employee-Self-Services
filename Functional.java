
import java.util.*;
public class Functional
{
    public static void main(String args[])
    {
        Scanner scin=new Scanner(System.in);
        Iad iad=new Iad();
        ArrayList<Iad> emp=new ArrayList<>();
        emp.add(new Iad("1111"));
        while(true)
        {
            System.out.print("Username: ");
            String userid=scin.next();
            if(iad.findEmployee(emp,userid))
            {
                System.out.print("Password: ");
                String pass=scin.next();
                for(Iad id:emp)
                {
                    if(id.empId.equals(userid))
                    {
                        Iad i=id;
                        if(i.password.equals(pass))
                            System.out.println("Login success");
                    }
                }
            }
            else
                System.out.println("Employee Not Found");
        }
    }
}