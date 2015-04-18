package testPackage;
import java.util.ArrayList;
import java.util.Date;

import EntityClasses.*;
import DaoImplementations.*;

public class libraryappTest {

	public static void main(String[] args) {

		//only for the purpose of testing / should be a menu
		Book book = new Book();
		book.setIsbn("1D");
		book.setTitle("Design Patterns");
		BookDaoImplementation bookImpl = new BookDaoImplementation(book);
		bookImpl.registerPublication();
		
		Member member = new Member();
		member.setName("Gordana");
		member.setEmail("gordanalazarova@yahoo.com");
		MemberDaoImplementation memberImpl = new MemberDaoImplementation(member);
		memberImpl.registerPublication();
		
		Loan loan = new Loan();
		loan.setStartDate(new Date());
		loan.setEndDate(new Date());
		loan.setMember(member);
		loan.setPublication(book);
		LoanDaoimplementation loand = new LoanDaoimplementation(loan);
		loand.registerPublication();
		
		LoanDaoimplementation loandao = new LoanDaoimplementation();
		ArrayList results = loandao.listItems();
		loandao.Print(results);
		
		
	}

}
