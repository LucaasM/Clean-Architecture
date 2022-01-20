package br.com.covid.presenters;

import br.com.covid.core.adapters.output.HospitalOutputAdapter;
import br.com.covid.core.ports.output.HospitalOutputPort;
import br.com.covid.presenters.entity.HospitalEntity;
import br.com.covid.presenters.repository.HospitalRepository;
import org.springframework.stereotype.Component;

@Component
public class HospitalRepositoryImpl implements HospitalOutputPort {


    private final HospitalRepository hospitalRepository;

    public HospitalRepositoryImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public void salvarHospital(HospitalOutputAdapter hospitalOutputAdapter) {
        this.hospitalRepository.save(HospitalEntity.convert(hospitalOutputAdapter));
    }

}
