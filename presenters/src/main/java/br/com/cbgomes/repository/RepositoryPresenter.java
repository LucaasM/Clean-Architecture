package br.com.cbgomes.repository;

import br.com.cbgomes.domain.HospitalEntity;
import br.com.cbgomes.domain.PersistentObject;
import br.com.cbgomes.ports.output.OutputPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPresenter extends JpaRepository<HospitalEntity, Long> {
}
