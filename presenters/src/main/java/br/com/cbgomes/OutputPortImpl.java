package br.com.cbgomes;

import br.com.cbgomes.domain.HospitalEntity;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.output.OutputPort;
import br.com.cbgomes.repository.RepositoryPresenter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OutputPortImpl implements OutputPort {

    private final RepositoryPresenter repositoryPresenter;

    public OutputPortImpl(RepositoryPresenter repositoryPresenter) {
        this.repositoryPresenter = repositoryPresenter;
    }

    @Override
    public HospitalOutputPort save(HospitalOutputPort hospitalOutputPort) {
        HospitalEntity responseHospital =  this.repositoryPresenter.save(HospitalEntity.converteHospitalEntity(hospitalOutputPort));
        return HospitalEntity.convertHospitalOutputPort(responseHospital);
    }

    @Override
    public List<HospitalOutputPort> listAll(){
        List<HospitalEntity> responseHospital = this.repositoryPresenter.findAll();
        return responseHospital.stream().map(HospitalEntity::convertHospitalOutputPort).collect(Collectors.toList());
    }

    @Override
    public Void remove(Long id) {
        Optional<HospitalEntity> response = this.repositoryPresenter.findById(id);

        this.repositoryPresenter.delete(response);
        return null;
    }

    @Override
    public Void atualizacao(Long id, HospitalOutputPort hospitalOutputPort) {
        Optional<HospitalEntity> response = this.repositoryPresenter.findById(id);
        if(response.isPresent()) {
            this.repositoryPresenter.save(HospitalEntity.converteHospitalEntity(hospitalOutputPort));
        }
        return null;
    }

}
