package com.book.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.book.dao.BookDaoImpl;
import com.book.pojo.Book;

public class BookTest {

	public static void main(String[] args) {
          
		Scanner sc=new Scanner(System.in);
		BookDaoImpl bimpl=new BookDaoImpl();
		Book b;
		List<Book> blist;
		
		 int bookid;
		 String bookname;
		 String author;
		 double bookprice;
		 String publisher;
		 int noOfCopies;
		
		
		boolean exit=false,flag;
		int choice;
		
		do {
			 
			System.out.println("Enter your choice");
			System.out.println("1. Add book details");
			System.out.println("2. Update book details");
			System.out.println("3. Delete book");
			System.out.println("4. show all book");
			System.out.println("5. show book by Author");
			System.out.println("6. show book by Publisher");
			System.out.println("7. Exit");
		    choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter book name");
				bookname=sc.nextLine();
				
				System.out.println("Enter authoe of book");
				author=sc.nextLine();
				
				System.out.println("Enter book price");
				bookprice=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter publisher name");
				publisher=sc.nextLine();
				
				System.out.println("Enter number of copie");
				noOfCopies=sc.nextInt();
				sc.nextLine();
				
				b=new Book();
				b.setAuthor(author);
				b.setBookname(bookname);
				b.setBookprice(bookprice);
				b.setNoOfCopies(noOfCopies);
				b.setPublisher(publisher);
				
				flag=bimpl.addBooks(b);
				
				if(flag==true) {
					
					System.out.println("Your book has been successfully added to database");
				}
				else {
					System.out.println("Error has occurred");
				}
				
				break;
				
			     case 2:
			    	 System.out.println("Enter the id of book to be updated");
			    	 bookid=sc.nextInt();
			    	 sc.nextLine();
			    	 
			    	 b=bimpl.showBookById(bookid);
			    	 
			    	 if(b!=null) {
			    		 System.out.println(b);
			    	     
			    		 System.out.println("Do you want to update this? ans in y or n");
			    		 char c=sc.next().charAt(0);
			    		 sc.nextLine();
			    		 if(c=='y') {
			    			 
			    			 System.out.println("Enter book name");
				 				bookname=sc.nextLine();
				 				
				 				System.out.println("Enter authoe of book");
				 				author=sc.nextLine();
				 				
				 				System.out.println("Enter book price");
				 				bookprice=sc.nextDouble();
				 				sc.nextLine();
				 				
				 				System.out.println("Enter publisher name");
				 				publisher=sc.nextLine();
				 				
				 				System.out.println("Enter number of copie");
				 				noOfCopies=sc.nextInt();
				 				sc.nextLine();
				 				
				 				b.setAuthor(author);
								b.setBookname(bookname);
								b.setBookprice(bookprice);
								b.setNoOfCopies(noOfCopies);
								b.setPublisher(publisher);
								
			    			flag= bimpl.updateBook(b);
			    			if(flag)
			    				System.out.println("Book updated successfully!!");
			    			else
			    				System.out.println("Error while updating");
			    		 }
			    		 else 
				    		 System.out.println("No problem!!!!");
				    	
			    	 }
			    	  
			    	 else 
			    		 System.out.println("no such book found by this id");
			    	 break;
			    	 
			     case 3:
			    	 System.out.println("Enter the id of book to be deleted");
			    	 bookid=sc.nextInt();
			    	 sc.nextLine();
			    	 
			    	 b=bimpl.showBookById(bookid);
			    	 System.out.println(b);
			    	 
			    	 if(b!=null) {
			    		 
			    	     
			    		 System.out.println("Do you want to update this? ans in y or n");
			    		 char c=sc.next().charAt(0);
			    		 sc.nextLine();
			    		 if(c=='y') {
			    		
			    			 flag=bimpl.deleteBook(bookid);
			    		    
			    			 
				    			if(flag)
				    				System.out.println("Book deleted successfully!!");
				    			else
				    				System.out.println("Error while deleting");
				    		 }
				    		 else 
					    		 System.out.println("No problem!!!!");
					    	
				    	 }
				    	  
				    	 else 
				    		 System.out.println("no such book found by this id");
				    	 
			    	 break;
			        
			     case 4:
			    	   
			    	    blist=bimpl.showAllBooks();
			    	    
			    	    if(blist.isEmpty())
			    	    	System.out.println("There are no books in our database!!!");
			    	    else
			    	    {
			    	    	Iterator<Book> it=blist.iterator();
			    	    	 while(it.hasNext()) {
			    	    		 
			    	    		 System.out.println("\n"+it.next());
			    	    		 System.out.println("--------------------------------------------");
			    	    	 }
			    	    }
			    	    break;
			    	    
			     
			     case 5:
			    	     System.out.println("Enter author name");
			    	      author=sc.nextLine();
			    	      //sc.nextLine();
			    	     
			    	      blist=bimpl.showBookByAuthor(author);
			    	       
			    	         
			    	       if(blist.isEmpty()) 
			    	       {
			    	       System.out.println("There are no author in our database!!!");
			    	       }
			    	            
			    	        else {
			    	        	Iterator<Book> it=blist.iterator();
			    	        	while(it.hasNext()) {
			    	        		
			    	        		System.out.println("\n"+it.next());
			    	        		System.out.println("-----------------------------------------");
			    	        	}
			    	        }
			    	        break;
			    	        
			             case 6:
			    	        System.out.println("Enter publisher name");
			    	        publisher=sc.nextLine();
				    	      //sc.nextLine();
				    	     
				    	      blist=bimpl.showBookByPublisher(publisher);
				    	       
				    	         
				    	       if(blist.isEmpty()) 
				    	       {
				    	       System.out.println("There are no book in our database!!!");
				    	       }
				    	            
				    	        else {
				    	        	Iterator<Book> it=blist.iterator();
				    	        	while(it.hasNext()) {
				    	        		
				    	        		System.out.println("\n"+it.next());
				    	        		System.out.println("-----------------------------------------");
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
