package br.com.covid.core.adapters.output;

import br.com.covid.core.adapters.input.HospitalInputAdapter;
import br.com.covid.core.adapters.input.LocalizacaoInputAdapter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalOutputAdapter {
    private String name;
    private String cnpj;
    private String endereco;
    private LocalizacaoOutputAdapter localizacao;

    public HospitalInputAdapter convert(HospitalOutputAdapter hospitalOutputAdapter) {

        LocalizacaoInputAdapter localizacao = LocalizacaoInputAdapter.builder()
                .latitude(hospitalOutputAdapter.localizacao.getLatitude())
                .longitude(hospitalOutputAdapter.localizacao.getLongitude())
                .build();

        return HospitalInputAdapter.builder()
                .name(hospitalOutputAdapter.name)
                .cnpj(hospitalOutputAdapter.cnpj)
                .endereco(hospitalOutputAdapter.endereco)
                .localizacao(localizacao).build();

    }
}
