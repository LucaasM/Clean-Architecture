package br.com.cbgomes.ports.data.input;

import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.data.output.LocalizacaoOutputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalInputPort {

    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoInputPort localizacao;


    public static HospitalOutputPort convertHospitalOutputPort(HospitalInputPort hospitalInputPort) {

        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .latitude(hospitalInputPort.localizacao.getLatitude())
                .longitude(hospitalInputPort.localizacao.getLongitude())
                .build();

        return HospitalOutputPort.builder()
                .nome(hospitalInputPort.getNome())
                .cnpj(hospitalInputPort.getCnpj())
                .endereco(hospitalInputPort.getEndereco())
                .localizacao(localizacaoOutputPort)
                .build();
    }
}
