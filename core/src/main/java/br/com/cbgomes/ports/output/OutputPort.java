package br.com.cbgomes.ports.output;

import br.com.cbgomes.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface OutputPort {
    public HospitalOutputPort save(HospitalOutputPort hospitalOutputPort);

    public List<HospitalOutputPort> listAll();
}
