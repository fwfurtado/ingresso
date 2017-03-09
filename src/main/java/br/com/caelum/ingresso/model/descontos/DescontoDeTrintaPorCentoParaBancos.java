package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

/**
 * Created by nando on 07/03/17.
 */
public class DescontoDeTrintaPorCentoParaBancos implements Desconto {

    private BigDecimal percentualDeDesconto = new BigDecimal("0.3");

    @Override
    public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
        return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
    }

    private BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal) {
        return precoOriginal.multiply(percentualDeDesconto);
    }
}