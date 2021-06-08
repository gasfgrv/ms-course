package br.com.gusto.ms.couse.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gusto.ms.couse.hrpayroll.entities.Payment;
import br.com.gusto.ms.couse.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	private final WorkerFeignClient client;

	@Autowired
	public PaymentService(WorkerFeignClient client) {
		this.client = client;
	}

	public Payment getPayment(long workerId, int days) {
		var worker = client.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
