package com.utn.persistenciajpa.repositorios;

import com.utn.persistenciajpa.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository <Factura,Long> {
}
