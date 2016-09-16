package com.rog.webshop.service.mail;

import com.rog.webshop.model.order.Order;

public interface MailService {

    void sendConfirmationEmail(final Order order);
}
