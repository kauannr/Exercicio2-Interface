package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate data;
    private Double valorParcela;

    public Parcela(LocalDate data, Double valorParcela) {
        this.data = data;
        this.valorParcela = valorParcela;
    }

    public Parcela() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String toString() {
        return getData().format(formato) + " - " + String.format("%.2f", getValorParcela());
    }

}
