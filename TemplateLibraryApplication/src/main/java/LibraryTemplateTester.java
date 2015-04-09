import java.util.Date;

import org.hibernate.dialect.function.TemplateRenderer;

import EntityClasses.*;
import EntityOperations.*;
import Interfaces.*;

public class LibraryTemplateTester {

	public static void main(String[] args) {
		
		//LibraryTemplate template = new LibraryTemplate();
		
		//Book book = new Book();
		//book.setIsbn("1B");
		//book.setTitle("Databases");		
		//new LibraryTemplate(new MagazineOperations()).ListEntity(); 
		
		/*
		Magazine magazine = new Magazine();
		magazine.setIssn("2B");
		magazine.setTitle("TAA");
		new LibraryTemplate(new MagazineOperations()).RegisterEntity(magazine);
		*/
		
		/*
		Book book = new Book();
		book.setIsbn("1B");
		book.setTitle("Databases");
		template.executeOperation(new RegisterPublication(book)); */
		/*
		Member member = new Member();
		member.setName("aleks");
		member.setEmail("aleks@yahoo.com");
		new LibraryTemplate(new MemberOperations()).RegisterEntity(member);
		
		Membership membership = new Membership();
		membership.setStartDate(new Date());
		membership.setEndDate(new Date());
		membership.setMembershiptype("vip");
		membership.setMember(member);
		new LibraryTemplate(new MembershipOperations()).RegisterEntity(membership); */
		
		//new LibraryTemplate(new MembershipOperations()).ListEntity();

		/*
		Member member = new Member();
		member.setName("didi");
		member.setEmail("didi@yahoo.com");
		new LibraryTemplate(new MemberOperations()).RegisterEntity(member);
		
		Book book = new Book();
		book.setIsbn("1D");
		book.setTitle("Algorhytms");
		new LibraryTemplate(new BookOperations()).RegisterEntity(book);
			
		Loan loan = new Loan();
		loan.setStartDate(new Date());
		loan.setEndDate(new Date());
		loan.setMember(member);
		loan.setPublication(book);
		new LibraryTemplate(new LoanOperations()).RegisterEntity(loan); */
		
		new LibraryTemplate(new LoanOperations()).ListEntity();
		
	}

}
