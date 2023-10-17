package model.entities;

import model.services.ServicoPagamentoOn;

public class Paypal implements ServicoPagamentoOn {

    @Override
    public Double juros(Double valor, Integer meses) {
        return ((0.01 * valor) * meses);
    }

    @Override
    public Double taxaPagamento(Double valor) {
        return 0.02 * valor;
    }

}
