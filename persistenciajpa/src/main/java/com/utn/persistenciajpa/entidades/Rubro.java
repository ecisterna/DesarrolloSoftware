package com.utn.persistenciajpa.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rubro")
public class Rubro extends BaseEntidad {

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Rubro")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod){
        productos.add(prod);
    }

    public void mostrarProducto(){
        for (Producto producto: productos){
            System.out.println("Denominacion:" + producto.getDenominacion() + " Tipo de Producto: " + producto.getTipoProducto() + " Receta: " + producto.getReceta() );
        }
    }
}
