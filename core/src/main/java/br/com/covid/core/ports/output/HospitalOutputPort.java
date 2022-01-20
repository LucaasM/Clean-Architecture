package br.com.covid.core.ports.output;

import br.com.covid.core.adapters.output.HospitalOutputAdapter;

public interface HospitalOutputPort {

    void salvarHospital(HospitalOutputAdapter hospitalOutputPort);
}
