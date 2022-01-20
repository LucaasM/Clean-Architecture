package br.com.covid.api.controller;


import br.com.covid.api.request.HospitalRequest;
import br.com.covid.core.ports.input.HospitalInputPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/hospitais")
public class HospitalController {


    private final HospitalInputPort hospitalInputPort;

    public HospitalController(HospitalInputPort hospitalInputPort) {
        this.hospitalInputPort = hospitalInputPort;
    }

    @PostMapping()
    public void criarHospital(@RequestBody HospitalRequest hospitalRequest){
        hospitalInputPort.salvarHospital(hospitalRequest.convert(hospitalRequest));
    }



}
