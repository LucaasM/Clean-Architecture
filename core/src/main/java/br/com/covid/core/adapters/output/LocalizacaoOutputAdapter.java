package br.com.covid.core.adapters.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoOutputAdapter {

    private Long id;
    private String latitude;
    private String longitude;
}
