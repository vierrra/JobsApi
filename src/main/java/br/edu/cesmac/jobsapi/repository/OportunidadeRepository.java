package br.edu.cesmac.jobsapi.repository;

import br.edu.cesmac.jobsapi.domain.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}
