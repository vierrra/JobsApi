package br.edu.cesmac.jobsapi.repository;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
}
