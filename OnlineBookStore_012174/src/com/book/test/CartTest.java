package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.BookDaoImpl;
import com.book.dao.CartDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Cart;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		int cartId;
		 int bookid;
		 String cemail;
		 int quantity;
		 boolean exit=false,flag;
		 int choice;
		
		Scanner sc=new Scanner(System.in);
		BookDaoImpl bimpl=new BookDaoImpl();
		List<Book> blist=bimpl.showAllBooks();
		CartDaoImpl cimpl=new CartDaoImpl();
		Cart c;
		List<Cart> clist;
		
		for(Book b:blist)
			System.out.println(b);
		
		do {
			    System.out.println("Enter your choice");
		        System.out.println("1. Add to cart");
		        System.out.println("2. Show my cart");
		        System.out.println("3. Revome an item from cartId");
		        System.out.println("4. Clear cart by email id");
		        System.out.println("5. Update Cart");
		        System.out.println("6. Exit");
		        choice=sc.nextInt();
		        sc.nextLine();
		        
		        switch(choice) {
		          
		        case 1:
		        	
		        	System.out.println("Enter the id of book you want to buy");
		        	bookid=sc.nextInt();
		        	sc.nextLine();
		        	
		        	System.out.println("Enter your email id");
		        	cemail=sc.nextLine();
		        	
		        	System.out.println("How many copies of this book do you want?");
		        	quantity=sc.nextInt();
		        	sc.nextLine();
		        	
		        	c=new Cart();
		        	c.setBookid(bookid);
		        	c.setCemail(cemail);
		        	c.setQuantity(quantity);
		        	
		            flag=cimpl.addToCart(c);
		            if(flag)
		            	System.out.println("Book added to cart successfully");
		            else
		            	System.out.println("Error while adding to cart");
		            break;
		            
		        case 2:
		        	
		        	System.out.println("Enter your email id");
		        	cemail=sc.nextLine();
		        	
		        	
		        	 clist=cimpl.showMyCart(cemail);
		        	
		        	if(clist.isEmpty())
		        		System.out.println("Please add books to your cart first");
		        	{
		        	System.out.println("Items in your cart...................");
		        	for(Cart cart:clist) {
		        		
		        		System.out.println(cart);
		        	}
		        	}
		        	break;
		        	
		        case 3:
		        	
		        	System.out.println("Enter your email id");
		        	cemail=sc.nextLine();
		        	
		        	clist=cimpl.showMyCart(cemail);
		        	
		        	if(clist.isEmpty())
		        		System.out.println("There are no items in your cart yet");
		        	
		        	else
		        	{
		        		for(Cart cart:clist) {
		        			
		        			System.out.println("\n"+cart);
		        		}
		        		
		        		System.out.println("Enter the cartid of the item you want to remove");
		        		cartId=sc.nextInt();
		        		sc.nextLine();
		        		
		        		System.out.println("Are you sure you want to delete the item at cartid= "+cartId);
		        		System.out.println("Presss y for yes");
		        		char c1=sc.next().charAt(0);
		        		
		        		if(c1=='y')
		        		{
		        			flag=cimpl.removeFromCart(cartId);
		        			if(flag)
		        				System.out.println("Item remove from cart successfully");
		        			
		        		}
		        		else
		        			System.out.println("No problem!!!!");
		        	}
		        	break;
		        	
		        case 4:
		             
                     System.out.println("Enter your email id");
                     cemail=sc.nextLine();
                     
                     flag=cimpl.clearCart(cemail);
                     
                     if(flag)
                    	 System.out.println("Your cart has been cleard!!!!");
                     else
                    	 System.out.println("Error while clearing cart");
                     break;
                     
                     case 5:
                    	
                    	 System.out.println("Enter email id");
                    	 cemail=sc.nextLine();
                    	 
                    	 clist=cimpl.showMyCart(cemail);
                    	 if(clist.isEmpty()) 
                    		System.out.println("There are no data");
                    		else {
                    			for(Cart cart:clist)
                    			
                    	              System.out.println("\n"+cart);			
                    			
                    		}
                    	 
                    		System.out.println("Enter cartId to increse quantity");
                    		cartId=sc.nextInt();
                    		sc.nextLine();
                    		
                    		System.out.println("Are you sure you want to increas your qunatity?Ans y or n");
                    		char ch1=sc.next().charAt(0);
                    		sc.nextLine();
                    		
                    		if(ch1=='y')
                    		{
                    			
                    			System.out.println("Enter quantity");
                    			quantity=sc.nextInt();
                    			sc.nextLine();
                    			
                    			flag=cimpl.updateQuantity(cartId, quantity);
                    			if(flag)
                    				System.out.println("Quantity updated successfully");
                    			else
                    				System.out.println("Error while updating quantity");
                    		
                    		}
                    	 
		        
                    		break;
                    	 
                    	 
                     case 6:
                    	 exit=true;
                    	 System.out.println("Thank you");
		                break;
		                
		                default:
		                	System.out.println("Enter valid input");
		                	
		        }
		}while(exit==false);
		 
	}

}
