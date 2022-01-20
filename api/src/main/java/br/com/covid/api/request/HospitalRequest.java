package br.com.covid.api.request;

import br.com.covid.core.adapters.input.HospitalInputAdapter;
import br.com.covid.core.adapters.input.LocalizacaoInputAdapter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalRequest {

    private String name;
    private String cnpj;
    private String endereco;
    private LocalizacaoRequest localizacao;


    public HospitalInputAdapter convert(HospitalRequest hospitalRequest) {
        LocalizacaoInputAdapter localizacaoInputPort = LocalizacaoInputAdapter.builder()
                .latitude(hospitalRequest.localizacao.getLatitude())
                .longitude(hospitalRequest.localizacao.getLongitude())
                .build();

        return HospitalInputAdapter.builder()
                .name(hospitalRequest.name)
                .cnpj(hospitalRequest.cnpj)
                .endereco(hospitalRequest.cnpj)
                .localizacao(localizacaoInputPort)
                .build();
    }
}
