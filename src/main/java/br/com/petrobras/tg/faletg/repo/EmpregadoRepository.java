package br.com.petrobras.tg.faletg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petrobras.tg.faletg.domain.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer>{

}
