package cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    
}
