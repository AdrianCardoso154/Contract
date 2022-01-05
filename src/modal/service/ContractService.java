package modal.service;

import java.util.Calendar;
import java.util.Date;

import modal.entities.Contract;
import modal.entities.Intallments;

public class ContractService {
	
	private OnlinePaymentService ops;
	//injeção de dependencia por inject contruct
	public ContractService (OnlinePaymentService onlinePaymentService){
		this.ops = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int month) {
		double basicQuota = contract.getTotalValue()/month;
		for(int i = 1; i<=month; i++) {
			Date ds = selectDate(contract.getDate(), i);
			double updatequota =basicQuota + ops.interest(basicQuota, i);
			double fullQuota = updatequota + ops.paymentFee(updatequota);
			contract.addParcela(new Intallments(ds, fullQuota));
		}
	}
	
	private Date selectDate(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		return cal.getTime();
	}
	
}
