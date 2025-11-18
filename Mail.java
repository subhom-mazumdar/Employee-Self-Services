import java.util.*;

public class Mail 
{
    public String from;
    public String to;
    public String body;
    Mail(String from,String to,String body)
    {
        this.from=from;
        this.to=to;
        this.body=body;
    }
    public static void sendMail(ArrayList<Mail> mail,ArrayList<Iad> iad,String sender,String receiver,String body)
    {
        Iad run=null;
        run=Iad.findEmployee(iad,receiver);
        if(run!=null)
        {
            mail.add(new Mail(sender,receiver,body));
            System.out.println("Mail received by "+receiver);
        }
        else if(run==null)
        {
            System.out.println("Failed to send mail to "+receiver);
        }
    }
    public static void fetchInbox(ArrayList<Mail> mail,String got)
    {
        boolean exist=false;
        for(Mail m:mail)
        {
            if(m.to.equals(got))
            {
                Mail temp=m;
                System.out.println("From: "+temp.from);
                System.out.println("To :"+got);
                System.out.println(m.body);
                System.out.println("---------------------");
                exist=true;
            }

        }
        if(!exist)
            System.out.println("Empty inbox");
    }
    public static void fetchOutbox(ArrayList<Mail> mail,String outflow)
    {
        boolean exist=false;
        for(Mail m:mail)
        {
            if(m.from.equals(outflow))
            {
                Mail temp=m;
                System.out.println("From: "+outflow);
                System.out.println("To :"+m.to);
                System.out.println(m.body);
                System.out.println("---------------------");
                exist=true;
            }

        }
        if(!exist)
            System.out.println("Empty outbox");
    }
}
