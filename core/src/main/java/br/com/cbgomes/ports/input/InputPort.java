package br.com.cbgomes.ports.input;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface InputPort {

    public HospitalOutputPort save(HospitalInputPort hospitalInputPort);

    public List<HospitalOutputPort> listAll();

}
