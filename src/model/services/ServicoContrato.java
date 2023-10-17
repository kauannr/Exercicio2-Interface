package model.services;

import java.time.LocalDate;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {

    private ServicoPagamentoOn servicoPagamentoOn;

    public ServicoContrato(ServicoPagamentoOn servicoPagamentoOn) {
        this.servicoPagamentoOn = servicoPagamentoOn;
    }

    public void processarContrato(Contrato contrato, Integer meses) {
        Double parcelaBasica = contrato.getValor() / meses;

        for (int i = 1; i <= meses; i++) {
            // adiciona um mes pra começar a contar as parcelas:
            LocalDate data = contrato.getData().plusMonths(i);

            Double juros = servicoPagamentoOn.juros(parcelaBasica, i); // 2% a cada mes
            Double taxa = servicoPagamentoOn.taxaPagamento(parcelaBasica + juros); // 2% em cima do valor da parcela já
                                                                                   // com juros
            Double parcelaTotal = parcelaBasica + juros + taxa;

            // adicionar as parcelas na lista
            contrato.getparcelas().add(new Parcela(data, parcelaTotal));
        }

    }

}
