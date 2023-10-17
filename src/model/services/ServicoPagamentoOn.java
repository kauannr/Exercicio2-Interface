package model.services;

public interface ServicoPagamentoOn {
    public Double juros(Double valor, Integer meses);

    public Double taxaPagamento(Double valor);
}
