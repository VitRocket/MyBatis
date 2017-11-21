package com.github.vitrocket.mybatis.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Vit Rocket on 21.11.2017.
 * @version 1.0
 * @since on 21.11.2017
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    public void sendEmail(EmailMessage emailMessage) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");

        message.setFrom(new InternetAddress("example@example.com", "NoReply"));
        message.setReplyTo(InternetAddress.parse("example@example.com", false));
        message.setSubject(emailMessage.getSubject(), "UTF-8");
        message.setSentDate(new Date());
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo(), false));

        Multipart multipart = new MimeMultipart();

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailMessage.getContent(), "text/html; charset=UTF-8");
        multipart.addBodyPart(messageBodyPart);
        if (emailMessage.getAttachment() != null) {
            messageBodyPart = new MimeBodyPart();
            File file = new File(emailMessage.getAttachment());
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);
        }
        message.setContent(multipart);
        emailSender.send(message);
        log.info("Message sent!");
    }
}
