package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {

	private ServicoPagOnline servicoPagOnline;

	public ServicoContrato(ServicoPagOnline servicoPagOnline) {
		this.servicoPagOnline = servicoPagOnline;
	}

	public void processoContato(Contrato contrato, int meses) {
		double quotaBase = contrato.getValorTotal() / meses;
		for (int i = 1; i <= meses; i++) {
			Date data = addMeses(contrato.getData(), i);
			double quotaAtualizada = quotaBase + servicoPagOnline.juros(quotaBase, i);
			double quotaCheia = quotaAtualizada + servicoPagOnline.taxa(quotaAtualizada);
			contrato.addParcela(new Parcela(data, quotaCheia));

		}

	}

	private Date addMeses(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
