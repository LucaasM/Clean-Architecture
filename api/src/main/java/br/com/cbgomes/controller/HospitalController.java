package br.com.cbgomes.controller;


import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.input.InputPort;
import br.com.cbgomes.request.HospitalRequest;
import br.com.cbgomes.response.HospitalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<HospitalResponse> listAll() {
        return inputPort.listAll().stream().map(HospitalResponse::convertHospitalResponse).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    public Void remove(@PathVariable Long id){
        this.inputPort.remove(id);
        return null;
    }

    @PostMapping(path = "/atualizacao/{id}")
    public Void atualizacao(@PathVariable Long id, @RequestBody HospitalRequest request){
        this.inputPort.atualizacao(id, HospitalRequest.convertHospitalInputPort(request));
        return null;
    }

}
