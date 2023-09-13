package com.utn.persistenciajpa.entidades;

import com.utn.persistenciajpa.enums.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factura")
public class Factura extends BaseEntidad {

    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;

}
