package com.novmah.notificationservice.service;

import com.novmah.notificationservice.dto.EmailDetails;

public interface MailService {

    void sendEmail(EmailDetails emailDetails);

}
