package com.novmah.notificationservice.service.impl;

import com.novmah.notificationservice.dto.EmailDetails;
import com.novmah.notificationservice.exception.ResourceNotFoundException;
import com.novmah.notificationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmail(EmailDetails emailDetails) {
        MimeMessagePreparator message = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(senderEmail);
            messageHelper.setTo(emailDetails.getRecipient());
            messageHelper.setSubject(emailDetails.getSubject());
            messageHelper.setText(emailDetails.getMessageBody());
        };
        try {
            mailSender.send(message);
            log.info("Mail send successfully");
        } catch (MailException e) {
            log.error("Failed to send mail: ", e);
            throw new ResourceNotFoundException("Exception occurred when sending mail to " + emailDetails.getRecipient());
        }
    }

}
