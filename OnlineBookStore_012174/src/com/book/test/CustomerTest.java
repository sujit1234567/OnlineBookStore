package com.book.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.book.dao.CustomerDaoImpl;
import com.book.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
		CustomerDaoImpl cimpl=new CustomerDaoImpl();
		Customer c=null;
		List<Customer> blist;
		
		 int choice;
		 int cid;
		 String fname;
		 String lname;
		 String caddress;
		 String cemail;
		 String contact;
		 String password;
		 boolean exit=false,flag;
		 do {
			 
			 System.out.println("1. Add Customer");
			 System.out.println("2. Update Book");
			 System.out.println("3. Delete Customer By Id");
			 System.out.println("4. Search Customer by Email");
			 System.out.println("5. Search customer by ID");
			 System.out.println("6. Show customer");
			 System.out.println("7. Exit");
			 System.out.println("Enter your choice ");
			 choice=sc.nextInt();
			 sc.nextLine();
			 
			 switch(choice) {
			 
			 case 1:
				 
				 System.out.println("Enter fname: ");
				 fname=sc.nextLine();
				 
				 System.out.println("Enter lname: ");
				 lname=sc.nextLine();
				 
				 System.out.println("Enter address: ");
				 caddress=sc.nextLine();
				 
				 System.out.println("Enter email: ");
				 cemail=sc.nextLine();
				
				 System.out.println("Enter contact: ");
				 contact=sc.nextLine();
				 
				 System.out.println("Enter password: ");
				 password=sc.nextLine();
				 
				 c=new Customer();
				 c.setFname(fname);
				 c.setLname(lname);
				 c.setCaddress(caddress);
				 c.setCemail(cemail);
				 c.setContact(contact);
				 c.setPassword(password);
				 
				 flag=cimpl.addCustomer(c);
				 if(flag==true)
					 System.out.println("Customer added successfully");
				 else
					 System.out.println("Error while adding customer");
				 break;
				 
			 case 2:
				 System.out.println("Enter id which you want to update");
				 cid=sc.nextInt();
				 sc.nextLine();
				 
				 
				 c=cimpl.searchCustomer(cid);
				 if(c!=null) {
					 System.out.println(c);
				 
				 System.out.println("Do you want update customer details? Ans y or n");
				 char ch1=sc.next().charAt(0);
				 sc.nextLine();
				 if(ch1=='y') {
				 System.out.println("Enter Fname: ");
				 fname=sc.nextLine();
				 
				 System.out.println("Enter Lname: ");
				 lname=sc.nextLine();
				 
				 System.out.println("Enter Address: ");
				 caddress=sc.nextLine();
				 
				 System.out.println("Enter Email: ");
				 cemail=sc.nextLine();
				 
				 System.out.println("Enter Contact: ");
				 contact=sc.nextLine();
				 
				 System.out.println("Enter Password: ");
				 password=sc.nextLine();
				 
				 
				 c.setFname(fname);
				 c.setLname(lname);
				 c.setCaddress(caddress);
				 c.setCemail(cemail);
				 c.setContact(contact);
				 c.setPassword(password);
				 
				 flag=cimpl.updateCustomer(c);
				 if(flag)
					 System.out.println("Data Updated Successfully!!!!");
				 else
					 System.out.println("Error while updating");
			 }
				 else
					 System.out.println("No problem!!!!");
			 }
				 else
					 System.out.println("No data found in database");
				 break;
				 
			 case 3:
				 
				 System.out.println("Enter id which you want to delete");
				 cid=sc.nextInt();
				 sc.nextLine();
				 
				 c=cimpl.searchCustomer(cid);
				 if(c!=null) {
					 
					 System.out.println(c);
					 
					 System.out.println("Do you want to delete?Ans y or n");
					 char ch1=sc.next().charAt(0);
					 sc.nextLine();
					 if(ch1=='y') {
						 
						 flag=cimpl.deleteCustomer(cid);
						 if(flag)
							 System.out.println("Deleted successfully!!!");
						 else
							 System.out.println("Error while deleting");
					 }
					 else
					    System.out.println("No problem");
				 }
				 else
				    System.out.println("No such data found in database");
				 break;
				 
			 case 4:
				 
				 System.out.println("Enter Email which you want to search");
				 cemail=sc.nextLine();
				 
				 
				 c=cimpl.searchCustomer(cemail);
				 if(c!=null)
					 System.out.println(c);
				 
				 else
					 System.out.println("No such data found");
				  
				 break;
				 
			 case 5:
				 
				 System.out.println("Enter ID which you want to search");
				 cid=sc.nextInt();
				 sc.nextLine();
				 
				 c=cimpl.searchCustomer(cid);
				 if(c!=null)
					 System.out.println(c);
				 
				 else
					 System.out.println("No such data found");
				  
				 break;
				 
				 
				 
			 case 6:
				 blist=cimpl.showCustomer();
				 
				 if(blist.isEmpty())
					 System.out.println("No such data found");
				 else {
					 
					 Iterator<Customer> i=blist.iterator();
					 while(i.hasNext())
					 {
						 System.out.println(i.next());
						 System.out.println("\n----------------------------------------------");
					 }
				 }
				 break;
				 
			 case 7:
				 exit=true;
				 System.out.println("Thank you");
				 break;
				 
				 default:
					 System.out.println("Please give valid input");
			 }
		 }while(exit==false);
		
	}

}
