package pkg;

import java.util.Scanner;

abstract class Library {
 int options = 0;
 void view_books()
 {
 Viewbooks.func();
 }
}
class Admin extends Library{
	Admin(Scanner sc)
	{
//Scanner sc = new Scanner(System.in);
S.sop("MENU \n1.View_books  2.Add new Student");
//options = sc.nextInt();
try {   options = Integer.parseInt(sc.nextLine()); } 
catch (NumberFormatException e) {  e.printStackTrace(); }
	}
}

class Student extends Library{
Scanner scc = new Scanner(System.in);
    String uname,pword;
    Student(String username,String password)
    {
    uname = username ; 
    pword = password ;
    S.sop("MENU \n1.View_books\n2.Issue\n3.Return\n4.View Issued Books");
    options = scc.nextInt();
    }
    String ir_book()
    {
    String bname = null;
    System.out.println("Enter book name");
    scc.nextLine();
    bname = scc.nextLine();
    //S.sop("Asd"+bname);
    scc.close();
    return bname;
    }
	// void return_book();
	// void books_taken();
	//String rno;
  //  void issue_book()
}

