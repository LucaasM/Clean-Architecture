package br.com.covid.core.usecase;

import br.com.covid.core.adapters.input.HospitalInputAdapter;
import br.com.covid.core.ports.input.HospitalInputPort;
import br.com.covid.core.ports.output.HospitalOutputPort;
import org.springframework.stereotype.Service;


@Service
public class HospitalUseCaseImpl implements HospitalInputPort {

    private final HospitalOutputPort hospitalOutputPort;

    public HospitalUseCaseImpl(HospitalOutputPort hospitalOutputPort) {
        this.hospitalOutputPort = hospitalOutputPort;
    }

    @Override
    public void salvarHospital(HospitalInputAdapter hospitalInputAdapter){
        this.hospitalOutputPort.salvarHospital(hospitalInputAdapter.convert(hospitalInputAdapter));
    }

}
