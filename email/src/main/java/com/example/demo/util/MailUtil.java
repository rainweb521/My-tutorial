package com.example.demo.util;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailUtil {
    public static JavaMailSenderImpl createMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.mxhichina.com");
        sender.setPort(25);
        sender.setUsername("admin@52itstyle.com");
        sender.setPassword("");
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout",1000+"");
        p.setProperty("mail.smtp.auth","true");
        sender.setJavaMailProperties(p);
        return sender;
    }


}
