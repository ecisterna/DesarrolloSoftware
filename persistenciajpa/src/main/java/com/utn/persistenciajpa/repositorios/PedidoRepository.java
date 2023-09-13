package com.utn.persistenciajpa.repositorios;

import com.utn.persistenciajpa.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido,Long> {
}
