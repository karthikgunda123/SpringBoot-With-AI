package gunda.karthik.spring.ai.email_reply;

import lombok.Data;

@Data
public class EmailRequest
{
    private String emailContent;
    private String tone;
}
