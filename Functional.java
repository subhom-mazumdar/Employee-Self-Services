
import java.util.*;
public class Functional
{
    public static void main(String args[])
    {
        Scanner scin=new Scanner(System.in);
        Iad iad=new Iad();
        Supervisor sup=new Supervisor();
        ArrayList<Iad> emp=new ArrayList<>();
        ArrayList<Supervisor> supervisor=new ArrayList<>();
        ArrayList<Mail> mail=new ArrayList<>();
        Iad.addEmployeeAdmin(emp, supervisor, "1111");
        while(true)
        {
            System.out.println("its a cli tool");
            System.out.println("- login\n- exit");
            String entrycommad=scin.next();
                if(entrycommad.equalsIgnoreCase("login"))
                {
                    System.out.print("Username: ");
                    String userid=scin.next();
                    Iad current=iad.findEmployee(emp, userid);
                    if(current!=null)
                {
                    System.out.print("Password: ");
                    String pass=scin.next();
                    if(current.password.equals(pass))
                    {while(true){
                        String success="Login success\n";
                        if(userid.equals("1111"))
                        {
                            success=success+"- addsupervisor (ADMIN)\n- recruitnew (ADMIN)\n";
                        }
                        success=success+"- mysupervisor\n- enterprisesearch\n -imail\n";
                        System.err.print(success);
                        System.out.print("Your command: ");
                        String menu=scin.next();
                        if(!userid.equals("1111") && menu.equalsIgnoreCase("addsupervisor"))
                        {
                            System.out.println("You dont have this priviledge");
                        }
                        else if(!userid.equals("1111") && menu.equalsIgnoreCase("recruitnew"))
                        {
                            System.out.println("You dont have this priviledge");
                        }
                        else if(userid.equals("1111") && menu.equalsIgnoreCase("recruitnew"))
                        {
                            System.out.print("Enter employee Id: ");
                            String newemp=scin.next();
                            Iad.addEmployeeAdmin(emp, supervisor, newemp);
                            System.out.println("Session Ended");
                            break;
                        }
                        else if(userid.equals("1111") && menu.equalsIgnoreCase("addsupervisor"))
                        {
                            Supervisor.addSupervisorAdmin(emp, supervisor);
                            System.out.println("Session Ended");
                            break;
                        }
                        else if(menu.equalsIgnoreCase("mysupervisor"))
                        {
                            String supdet=Supervisor.searchSupervisor(supervisor,userid);
                            if(supdet!=null)
                            {
                                System.out.println("Supervisor ID: "+supdet+"\nSupervisor mail: "+supdet+"@mycompany");
                            }
                            System.out.println("Session Ended");
                            break;
                        }
                        else if(menu.equalsIgnoreCase("imail"))
                        {
                            Mail.fetchInbox(mail, userid);
                            System.out.println("type + to send mail\noutbox to view outbox\nexit");
                            String mailcommand=scin.next();
                            if(mailcommand.equalsIgnoreCase("+"))
                            {
                                System.out.print("Enter receiver(s) ID (put commas without any whitespace for multiple receivers)\nReceiver(s): ");
                                String rec=scin.next();
                                System.out.print("Message: ");
                                String parcel=scin.next();
                                if(rec.contains(",") && !parcel.equals(""))
                                {
                                    String recarr[]=rec.split(",");
                                    for(String r:recarr)
                                    {
                                        Mail.sendMail(mail, emp, userid, r, parcel);
                                    }
                                }
                                else if(!rec.equals("") && !rec.contains(",") && !parcel.equals(""))
                                    Mail.sendMail(mail, emp, userid, rec, parcel);
                                else if(rec.equals("") || parcel.equals(""))
                                    System.out.println("MAIL ERROR");
                            }
                            else if(mailcommand.equalsIgnoreCase("outbox"))
                                Mail.fetchOutbox(mail, userid);
                            else
                                System.out.println("Invalid command detected");
                            System.out.println("Session Ended");
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid command detected");
                            System.out.println("Session Ended");
                            break;
                        }
                    }
                    }else{System.out.println("Invalid login credentials"); break;}
                }
                else
                    System.out.println("Employee Not Found");
                }
                else if(entrycommad.equalsIgnoreCase("exit")){
                    break;}
                else
                    System.out.println("unable to finfd operations");
        }   
        
    }
}