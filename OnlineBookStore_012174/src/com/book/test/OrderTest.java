package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.OrderDaoImpl;
import com.book.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int orderId;
		 String orderStatus;
		 String orderDate;
		 String cemail;
		 double totalBill;
		 boolean exit=false;
		 int choice;
		 
		 Scanner sc=new Scanner(System.in);
		 OrderDaoImpl oimpl=new OrderDaoImpl();
		 Order o;
		 List<Order> olist;
		 do {
			 
			 System.out.println("1. Place order");
			 System.out.println("2. Show my order history");
			 System.out.println("3. Show all order");
			 System.out.println("Enter youe choice");
			 choice=sc.nextInt();
			 sc.nextLine();
			 
			 switch(choice) {
			   
			 case 1:
				 
				 System.out.println("Enter your email id");
				 cemail=sc.nextLine();
				 
				 o=oimpl.placeOrder(cemail);
				 
				 if(o!=null) {
				 System.out.println("your order has been placed");
				 System.out.println("Your order summary is as follows.......");
				 
				 System.out.println(o);
				 }
				 else
					 System.out.println("Error while placing order.");
				 break;
				 
			 case 2:
				 
				 System.out.println("Enter email id");
				 cemail=sc.nextLine();
				 
				 olist=oimpl.showMyOrderHistory(cemail);
				 if(!(olist.isEmpty())) {
					 
				 for(Order o1:olist)
					 System.out.println(o1);
				 }
				 else
					 System.out.println("You have not placed orders yet");
				 break;
				 
			 case 3:
				 
				 olist=oimpl.showAllOrders();
			 
				 if(!(olist.isEmpty())) {
					 
					 for(Order o1:olist)
						 System.out.println(o1);
					 }
					 else
						 System.out.println("You have not placed orders yet");
					 break;
					
					 default:
						 System.out.println("Please enter valid input");
			 }
			 
			 
		 }while(exit==false);
	}

}
