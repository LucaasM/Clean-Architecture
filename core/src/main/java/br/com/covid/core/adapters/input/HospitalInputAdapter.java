package br.com.covid.core.adapters.input;

import br.com.covid.core.adapters.output.LocalizacaoOutputAdapter;
import lombok.Builder;
import br.com.covid.core.adapters.output.HospitalOutputAdapter;
import lombok.Data;

@Data
@Builder
public class HospitalInputAdapter {

    private String name;
    private String cnpj;
    private String endereco;
    private LocalizacaoInputAdapter localizacao;


    public HospitalOutputAdapter convert(HospitalInputAdapter hospitalInputAdapter) {

        LocalizacaoOutputAdapter localizacao = LocalizacaoOutputAdapter.builder()
                .latitude(hospitalInputAdapter.localizacao.getLatitude())
                .longitude(hospitalInputAdapter.localizacao.getLongitude())
                .build();

        return HospitalOutputAdapter.builder()
                .name(hospitalInputAdapter.name)
                .cnpj(hospitalInputAdapter.cnpj)
                .endereco(hospitalInputAdapter.endereco)
                .localizacao(localizacao)
                .build();
    }

}
