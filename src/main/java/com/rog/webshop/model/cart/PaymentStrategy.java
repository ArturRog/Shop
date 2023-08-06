package com.rog.webshop.model.cart;

import java.math.BigDecimal;

public interface PaymentStrategy {
	void pay(BigDecimal amount);
}
