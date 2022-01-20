package br.com.covid.core.ports.input;

import br.com.covid.core.adapters.input.HospitalInputAdapter;

public interface HospitalInputPort {

    void salvarHospital(HospitalInputAdapter HospitalInputAdapter);
}
