package br.com.cbgomes.controller;


import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.input.InputPort;
import br.com.cbgomes.request.HospitalRequest;
import br.com.cbgomes.response.HospitalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final InputPort inputPort;

    public HospitalController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public HospitalResponse save(@RequestBody HospitalRequest hospitalRequest) {
        HospitalOutputPort response = inputPort.save(HospitalRequest.convertHospitalInputPort(hospitalRequest));
        return HospitalResponse.convertHospitalResponse(response);
    }

    @GetMapping
    public List<HospitalOutputPort> listAll() {
        return inputPort.listAll();
    }
}
