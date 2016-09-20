package com.rog.webshop.service.mail;

import com.rog.webshop.model.order.Order;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service("mailService")
public class MailServiceImpl implements  MailService
{
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;


    public void sendConfirmationEmail(final Order order) {

        MimeMessagePreparator preparator = new MimeMessagePreparator()
        {
            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper message = new MimeMessageHelper(mimeMessage,false);

                message.setTo(order.getUser().getEmail());
                message.setSubject("Your order has been dispatched.");

                Map model = new HashMap();

                model.put("order", order);

                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "mailTemplate.txt", model);
                message.setText(text, true);
            }
        };


        try {
            this.mailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}