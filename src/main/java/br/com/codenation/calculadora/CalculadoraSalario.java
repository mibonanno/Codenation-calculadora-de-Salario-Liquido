package br.com.codenation.calculadora;


public class CalculadoraSalario {
	private static final double SALARIO_MINIMO = 1039.00;

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		}
		double salarioBrutoMenosInss = calcularInss(salarioBase);
		double salarioLiquido = calcularIrrf(salarioBrutoMenosInss);
		return Math.round(salarioLiquido);
	}

	private double calcularInss(double salarioBase) {
		double valorDesconto = salarioBase * obterTaxaDescontoInss(salarioBase);
		return salarioBase - valorDesconto;
	}

	private double obterTaxaDescontoInss(double salarioBase) {
		if (salarioBase <= 1500) {
			return 0.08;
		} else if (salarioBase <= 4000) {
			return 0.09;
		} else {
			return 0.11;
		}
	}

	private double calcularIrrf(double salarioBasePosInss) {
		double valorDesconto = salarioBasePosInss * obtertaxaDescontoIrrf(salarioBasePosInss);
		return salarioBasePosInss - valorDesconto;
	}

	private double obtertaxaDescontoIrrf(double salarioBasePosInss) {
		if (salarioBasePosInss <= 3000) {
			return 0.00;
		} else if (salarioBasePosInss <= 6000) {
			return 0.075;
		} else {
			return 0.15;
		}
	}
}