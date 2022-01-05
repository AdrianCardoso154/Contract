package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modal.entities.Contract;
import modal.entities.Intallments;
import modal.service.ContractService; 
import modal.service.PaypalService;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe o numero do contrato: ");
		int numContract = sc.nextInt();
		
		System.out.println("Inform a data de abertura do contrato: (dd/MM/yyyy) ");
		String data = sc.next();
		Date dateContract = sdf.parse(data);
		
		System.out.println("Informe o valor de contrato: ");
		double valueContract = sc.nextDouble();
		
		System.out.println("Informe a quantidade de parcelas desejadas: ");
		int intallments = sc.nextInt();
		
		Contract contract = new Contract(numContract, dateContract,valueContract);
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, intallments);
		
		
		System.out.println("--------------------Parcelas--------------------");
		for(Intallments intallment: contract.getListaParcelas()) {
			System.out.println(intallment+"\n");
		}
		System.out.println("Total do valor parcelado: "+String.format("%.2f", contract.totalParcela()));
		
		sc.close();
		
	}

}
