package br.com.cbgomes.response;

import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoResponse localizacao;

    public static HospitalResponse convertHospitalResponse(HospitalOutputPort hospitalOutputPort) {
        LocalizacaoResponse localizacaoResponse = LocalizacaoResponse.builder()
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalResponse.builder()
                .id(hospitalOutputPort.getId())
                .nome(hospitalOutputPort.getNome())
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .localizacao(localizacaoResponse)
                .build();
    }
}
