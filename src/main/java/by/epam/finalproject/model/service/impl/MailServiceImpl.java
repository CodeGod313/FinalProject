package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.MailService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailServiceImpl implements MailService {
    public static final String FROM = "CleverEx";
    public static final String MAIL_SUBJECT = "Account verification";
    public static final String EMAIL_TEXT = "Hi, thank you for registration. Confirm you account:\n";
    public static final String VERIFICATION_ADDRESS = "http://localhost:8080/controller?command=account_confirmation&verificationId=";
    public static final String PASSWORD_PROPERTY_NAME = "password";
    static Logger logger = LogManager.getLogger(MailServiceImpl.class);
    public static final String MAIL_PROPERTIES_FILE_NAME = "src/test/resources/mail.properties";
    Properties properties;

    public MailServiceImpl() throws ServiceException {
        properties = new Properties();
        try (InputStream fileStream = new FileInputStream(MAIL_PROPERTIES_FILE_NAME);) {
            properties.load(fileStream);
        } catch (IOException e) {
            logger.error("Can not load properties", e);
            throw new ServiceException("Can not load properties", e);
        }
    }

    @Override
    public void sendAccountVerificationEmail(String emailAddress, String verificationId) throws ServiceException {
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(FROM);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            message.setSubject(MAIL_SUBJECT);
            StringBuilder messageText = new StringBuilder();
            messageText.append(EMAIL_TEXT);
            messageText.append(VERIFICATION_ADDRESS);
            messageText.append(verificationId);
            message.setText(messageText.toString());
            Transport transport = session.getTransport();
            transport.connect(null, "cdykllgwvfamvcfv");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            logger.error("Can not initialize message", e);
            throw new ServiceException("Can not initialize message", e);
        }

    }
}
