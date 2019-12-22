package com.fzy.boke.utils;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;

public class MailUtils {
    //email：邮件发给谁
    //emailMSG：邮件内容
    public static void sendMail(String email, String content, String title)
            throws AddressException, MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");    //发邮件的协议
        props.setProperty("mail.host", "smtp.qq.com");        //发送邮件的服务器地址
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true

        // 创建验证器
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1579106394@qq.com", "blanuwwjrydoijgd");    //发邮件的账号的验证：账号密码
            }
        };

        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("1579106394@qq.com")); // 设置发送者

        message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

        message.setSubject(title);    //主题

        message.setContent(content, "text/html;charset=utf-8");

        // 3.创建 Transport用于将邮件发送

        Transport.send(message);
    }
}
