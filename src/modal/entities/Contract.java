package modal.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private int numContract;
	private Date date;
	private double totalValue;

	List<Intallments> listaParcelas = new ArrayList<>();

	public Contract() {
	}

	public Contract(int numContract, Date date, double totalValue) {
		super();
		this.numContract = numContract;
		this.date = date;
		this.totalValue = totalValue;
	}

	public int getNumContract() {
		return numContract;
	}

	public void setNumContract(int numContract) {
		this.numContract = numContract;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Intallments> getListaParcelas() {
		return listaParcelas;
	}

	public void addParcela(Intallments parcela) {
		listaParcelas.add(parcela);
	}
	
	public double totalParcela() {
		double total = 0.0;
		
		for(Intallments inta:listaParcelas) {
			total += inta.getAmount();
		}
		
		return total;
	}
}
