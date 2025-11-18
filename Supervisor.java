import java.util.*;
public class Supervisor
{
    public String supervise;
    public String reportee;
    public Supervisor(String supervise,String reportee)
    {
        this.supervise=supervise;
        this.reportee=reportee;
    }
    public Supervisor()
    {

    }
    public static void addSupervisorAdmin(ArrayList<Iad> emp,ArrayList<Supervisor> supdir)
    {
        Scanner scin=new Scanner(System.in);
        String repoid,supeid;
        while(true)
        {
            System.out.print("you can type exit go out from supervisor id\nEnter Supervisor employee ID: ");
            supeid=scin.next();
            if(Iad.findEmployee(emp, supeid)!=null)
                break;
            else if(supeid.equalsIgnoreCase("exit"))
                break;
            else
                System.out.println("Employee not found");
        }
        while (true)
        {
            System.out.print("you can type exit go out from reportee id\nEnter Reportee employee ID: ");
            repoid=scin.next();
            if(Iad.findEmployee(emp, repoid)!=null)
                break;
            else if(repoid.equalsIgnoreCase("exit"))
                break;
            else
                System.out.println("Employee not found");
        }
        if(!supeid.equals("") && !repoid.equals(""))
        {
            for(Supervisor s:supdir)
            {
                if(s.reportee.equals(repoid))
                {
                    Supervisor temp=s;
                    s.supervise=supeid;
                    break;
                }
            }
        }

    }
    public static String searchSupervisor(ArrayList<Supervisor> sup,String repoId)
    {
        String flag=null;
        for(Supervisor s:sup)
        {
            if(s.reportee.equals(repoId))
            {
                flag=s.supervise;
                break;
            }
        }
        return flag;
    }
}