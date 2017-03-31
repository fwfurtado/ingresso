package br.com.caelum.ingresso.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nando on 26/03/17.
 */
@Component
@SessionScope
public class Carrinho {

    private List<Ingresso> ingressos = new ArrayList<>();

    public Carrinho() {
    }

    public Carrinho(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public void add(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public BigDecimal getTotal(){
        return ingressos.stream().map(Ingresso::getPrecoComDesconto).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public boolean isSelecionado(Lugar lugar){
        return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "ingressos=" + ingressos +
                '}';
    }

    public void remove(Integer id) {
        Ingresso ingresso = ingressos.get(id);
        ingressos.remove(ingresso);
    }


    public Compra toCompra(){
        return  new Compra(ingressos);
    }
}
