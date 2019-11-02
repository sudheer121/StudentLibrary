package pkg;
import java.util.concurrent.TimeUnit;
import java.util.*;
public class Main {
	public static void main(String args[])
	{
String s1 = "12345",s2 ;int option,flag=0;
Scanner sc = new Scanner(System.in);
System.out.println("Welcome to Library");
System.out.println("1.ADMIN LOGIN \n2.STUDENT LOGIN");
option = sc.nextInt();
sc.nextLine();
String password=null,username=null;
switch(option){
case 1:S.sop("Enter password : ");
       //sc.nextByte();
       s2 = sc.nextLine();
       //sc.nextLine();
       if(s2.equals(s1))
       {
       S.sop("Login Successful");
       }
       else
       {
       S.sop("Invalid Password");
       sc.close();
       return;
       }
       
       break;
case 2:  S.sop("Enter username(roll no): ");
         //sc.nextLine();
         username = sc.nextLine();
         S.sop("Enter password :");
         password = sc.nextLine();
         flag = Auth.func(username,password);
         if(flag == 0) { S.sop("Authorization Unsuccesful");sc.close(); return;}
         break;
default: S.sop("Invalid option chosen");
         sc.close();
         return;
}

if(option == 1)
{
	Admin a = new Admin(sc);
	//sc.nextLine();
	Adminwork x;
	switch(a.options)
	{
	case 1: a.view_books();
	        sc.close();
	        return;
	case 2:x = new Adminwork();
	       //sc.nextLine();
	       S.sop("Hit Enter");
	       S.sop("Enter new username:(roll no)");
	       String uname = sc.nextLine();
           S.sop("Enter new password: ");
	       String pass  = sc.nextLine();
	       S.sop("Enter first name");
	       String fname = sc.nextLine();
	       S.sop("Enter last name");
	       String lname = sc.nextLine();
		   x.newStudent(uname,pass,fname,lname);
		   S.sop("Successfully completed...");
		   break;
	}
}
else if(option == 2)
{   String bk;Studentwork m;
	Student a = new Student(username,password);
	switch(a.options)
	{
	case 1: a.view_books();
	        break;
	case 2: m = new Studentwork(username);
	        bk = a.ir_book();
	        int f = m.issue(bk);
	        if(f==1)
	        {S.sop("Issued");}
	        break;
	case 3: m = new Studentwork(username);
            bk = a.ir_book();
            m.Returnbook(bk);
            break;
	case 4: m = new Studentwork(username);
            m.Issuedbks();
            break;
    default: S.sop("Invalid entry");
             break;
	}
	sc.close();
}
	
	}

}

class S
{
	public static void sop(String s)
	{
		System.out.println(s);
	}
	public static void sopp(String s)
	{
		System.out.print(s);
	}
}
