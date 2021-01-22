package com.arcor.bookingrestaurantapi.services.impl;

import javax.mail.internet.MimeMessage;

import com.arcor.bookingrestaurantapi.dtos.EmailTemplateDto;
import com.arcor.bookingrestaurantapi.entities.Notification;
import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.arcor.bookingrestaurantapi.exceptions.NotFoundException;
import com.arcor.bookingrestaurantapi.repositories.NotificationRepository;
import com.arcor.bookingrestaurantapi.services.EmailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public String processedSendEmail(String receiver, String templateCode, String currentName) throws BookingException {

        final EmailTemplateDto emailTemplateDto = findTemplateAndReplace(templateCode, currentName);

        // this.sendEmail(receiver, emailTemplateDto.getSubject(),
        // emailTemplateDto.getTemplate());
        this.sendEmail(receiver, emailTemplateDto.getTemplate());

        return "EMAIL_SEND";
    }

    // metodo para enviar mail

    private void sendEmail(final String receiver, final String template) throws BookingException {
        final MimeMessage email = javaMailSender.createMimeMessage();
        final MimeMessageHelper content;

        try {
            content = new MimeMessageHelper(email, true);
            content.setTo(receiver);
            content.setText(template, true);
        } catch (Exception e) {
            LOGGER.error("INTEERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        javaMailSender.send(email);
    }

    private EmailTemplateDto findTemplateAndReplace(final String templateCode, final String currentName)
            throws BookingException {

        final Notification notificationTemplate = notificationRepository.findByTemplateCode(templateCode)
                .orElseThrow(() -> new NotFoundException("TEMPLATE_NOT_FOUND", "CODE_TEMPLATE_NOT_FOUND" + templateCode));

        final EmailTemplateDto emailTemplateDto = new EmailTemplateDto();
        emailTemplateDto.setSubject(notificationTemplate.getTemplate());
        emailTemplateDto
                .setTemplate(notificationTemplate.getTemplate().replaceAll("\\{" + "name" + "\\}", currentName));

        return emailTemplateDto;
    }
}
