package com.utn.persistenciajpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nombre")
public class Cliente extends BaseEntidad {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Cliente")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }

    public void mostrarDomicilios(){
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios){
            System.out.println("Calle: " + domicilio.getCalle() + ", Numero: " + domicilio.getNumero() + ", Localidad: " + domicilio.getLocalidad());
        }
    }
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Cliente")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido ped){
        pedidos.add(ped);
    }

    public void mostrarPedidos(){
        System.out.println("Pedidos de: " + nombre + " " + apellido + ":");
        for (Pedido pedido : pedidos){
            System.out.println("Dia de Realizacion:" + pedido.getFecha() + ", Estado: " + pedido.getEstadoPedido() + ", Total: " + pedido.getTotal() + ", Tipo de Envio : " + pedido.getTipoEnvio());
        }
    }

}
