package modal.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Intallments {
	private Date dueDate;
	private double amount;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Intallments() {
	}

	public Intallments(Date dueDate, double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return sdf.format(dueDate) +" "+ amount;
	}

}