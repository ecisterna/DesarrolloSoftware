package com.utn.persistenciajpa.repositorios;

import com.utn.persistenciajpa.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto,Long> {
}
