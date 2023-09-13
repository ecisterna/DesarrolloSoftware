package com.utn.persistenciajpa.entidades;

import com.utn.persistenciajpa.enums.EstadoPedido;
import com.utn.persistenciajpa.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad {

    private EstadoPedido estadoPedido;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FK_Pedido")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Pedido")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetalle(DetallePedido det){
        detallePedidos.add(det);
    }

    public void mostrarDetalles(){
        System.out.println("Detalles del pedido :");
        for (DetallePedido detallePedido : detallePedidos){
            System.out.println("Cantidad: " + detallePedido.getCantidad() + ", Subtotal: " + detallePedido.getSubtotal());
        }
    }

}