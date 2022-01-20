package br.com.covid.presenters.entity;

import br.com.covid.core.adapters.output.HospitalOutputAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cnpj;

    private String endereco;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn ( name = "localizacao_id")
    private LocalizacaoEntity localizacao;


    public static HospitalEntity convert (HospitalOutputAdapter hospitalOutputPort) {

        LocalizacaoEntity localizacao = LocalizacaoEntity.builder()
                .id(null)
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalEntity.builder()
                .id(null)
                .name(hospitalOutputPort.getName())
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .localizacao(localizacao)
                .build();
    }

}
