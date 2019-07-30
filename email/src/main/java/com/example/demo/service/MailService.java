package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * 发送简单邮件
     * @param receiver
     * @param subject
     * @param context
     */
    public void sendSimpleMail(String receiver, String subject, String context){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setText(context);
        message.setSubject(subject);

        try{
            mailSender.send(message);
            logger.info("简单邮件已发送");
        }catch(Exception e){
            logger.error("发送简单邮件时出错", e);
        }
    }

    /**
     * 发送富文本(Html)邮件
     * @param receiver
     * @param subject
     * @param content
     */
    public void sendHtmlMail(String receiver, String subject, String content){
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            logger.info("Html文件发送成功！");
        }catch(MessagingException e){
            logger.error("发送Html文件时出错！", e);
        }
    }

    /**
     * 发送带有附件的邮件
     * @param receiver
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachedMail(String receiver, String subject, String content, String filePath){
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            logger.error("附件邮件发送成功！");
        }catch (MessagingException e){
            logger.error("发送附件邮件失败！", e);
        }
    }

    /**
     * 发送静态资源邮件（插入图片等）
     * @param receiver
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    public void sendInlineResourceMail(String receiver, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            logger.info("静态资源邮件发送成功！");
        }catch (MessagingException e){
            logger.error("静态资源邮件发送失败！", e);
        }
    }
}
