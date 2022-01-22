package br.com.cbgomes.controller;

import br.com.cbgomes.ports.input.InputPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Resource {

    private final InputPort inputPort;

    public Resource(InputPort inputPort) {
        this.inputPort = inputPort;
    }


}
