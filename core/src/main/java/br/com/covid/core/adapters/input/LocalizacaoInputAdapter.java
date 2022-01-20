package br.com.covid.core.adapters.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoInputAdapter {

    private String latitude;
    private String longitude;
}
