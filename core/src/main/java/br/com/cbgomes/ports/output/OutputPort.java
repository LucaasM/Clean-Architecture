package br.com.cbgomes.ports.output;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface OutputPort {
    HospitalOutputPort save(HospitalOutputPort hospitalOutputPort);

    List<HospitalOutputPort> listAll();

    Void remove(Long id);

    Void atualizacao(Long id, HospitalOutputPort hospitalOutputPort);
}
