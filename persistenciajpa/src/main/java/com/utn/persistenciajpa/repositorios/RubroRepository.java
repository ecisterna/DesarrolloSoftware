package com.utn.persistenciajpa.repositorios;

import com.utn.persistenciajpa.entidades.Producto;
import com.utn.persistenciajpa.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository  extends JpaRepository <Rubro,Long>{
}
