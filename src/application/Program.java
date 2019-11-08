package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.PaypalService;
import model.services.ServicoContrato;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.println("Digite os dados do contrato");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do Contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Digite a quantidade de parcelas: ");
		int n = sc.nextInt();
		
		ServicoContrato servicoContrato = new ServicoContrato(new PaypalService());
		
		servicoContrato.processoContato(contrato, n);
		
		System.out.println("Parcelas: ");
		for(Parcela x : contrato.getParcelas()) {
			System.out.println(x);
		}
		
		sc.close();
	}
}
