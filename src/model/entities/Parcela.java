package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataVencimento;
	private Double qtde;
	
	public Parcela(Date dataVencimento, Double qtde) {
		this.dataVencimento = dataVencimento;
		this.qtde = qtde;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getQtde() {
		return qtde;
	}

	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}
	
	@Override
	public String toString() {
		return sdf.format(dataVencimento) + " - " + String.format("%.2f", qtde);		
	}
}
