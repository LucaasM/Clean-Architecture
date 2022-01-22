package br.com.cbgomes.ports.input;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface InputPort {

    HospitalOutputPort save(HospitalInputPort hospitalInputPort);

    List<HospitalOutputPort> listAll();

    Void remove(Long id);

    Void atualizacao(Long id, HospitalInputPort hospitalInputPort);
}
