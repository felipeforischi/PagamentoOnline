package model.services;

public class PaypalService implements ServicoPagOnline{
	
	private static final double TAXA_PORCENTAGEM = 0.02;
	private static final double JUROS_MENSAIS = 0.01;
	

	@Override
	public double taxa(double qtde) {
		return qtde*TAXA_PORCENTAGEM;
		
	}
	
	@Override
		public double juros(double qtde, int meses) {
		return qtde*meses*JUROS_MENSAIS;
	}
}
