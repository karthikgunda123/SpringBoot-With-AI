package gunda.karthik.spring.ai.email_reply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailReplyApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(EmailReplyApplication.class, args);
		System.out.println("Working...");
	}
}

// GEMINI_API_URL=https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=;GEMINI_API_KEY=AIzaSyBD7QKJVrWfSMxFbVuxDEanQzjddPE1Wyo