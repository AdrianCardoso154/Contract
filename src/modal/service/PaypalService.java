package modal.service;

public class PaypalService implements OnlinePaymentService {

	public static final double feePayment = 0.02;
	public static final double ratepermoth = 0.01;

	@Override
	public double paymentFee(double amount) {

		return amount * feePayment;
	}

	
	@Override
	public double interest(double amount, int month) {
		return amount * ratepermoth * month;
	}

}
