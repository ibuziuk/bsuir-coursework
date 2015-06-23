package bsuir.coursework.service.email.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailDemo {

	public static void main(String[] args) {
	    String[] to =  {"scarecroww@yandex.ru", "ilyabuziuk@gmail.com"};
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mail-context.xml");
		SendMailExample mm = (SendMailExample) context.getBean("sendMailExample");
		mm.sendMail("ilyabuziuk@gmail.com",  to, "Javacodegeeks email test",
				"Testing.. \n Hello Spring Email Sender");
		context.close();
	}
}