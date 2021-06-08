package br.com.gusto.ms.couse.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.gusto.ms.couse.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Jorge", 200.0, days);
	}

}
