package br.com.cbgomes.domain;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.data.output.LocalizacaoOutputPort;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn ( name = "localizacao_ID" )
    private LocalizacaoEntity localizacao;


    public static HospitalEntity converteHospitalEntity(HospitalOutputPort hospitalOutputPort) {

        LocalizacaoEntity localizacao = LocalizacaoEntity.builder()
                .id(null)
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalEntity.builder()
                .id(null)
                .nome(hospitalOutputPort.getNome())
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .localizacao(localizacao)
                .build();

    }

    public static HospitalOutputPort convertHospitalOutputPort(HospitalEntity hospitalEntity) {

        LocalizacaoOutputPort localizacao = LocalizacaoOutputPort.builder()
                .id(null)
                .latitude(hospitalEntity.localizacao.getLatitude())
                .longitude(hospitalEntity.localizacao.getLongitude())
                .build();

        return HospitalOutputPort.builder()
                .id(hospitalEntity.id)
                .nome(hospitalEntity.getNome())
                .cnpj(hospitalEntity.getCnpj())
                .endereco(hospitalEntity.getEndereco())
                .localizacao(localizacao)
                .build();

    }

    public static List<HospitalOutputPort> convertListHospitalOutputPort(List<HospitalEntity> hospitalEntity) {

        List<HospitalOutputPort> hospitalOutputPorts = new ArrayList<>();

        for (var value: hospitalEntity) {

            LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                    .id(value.localizacao.getId())
                    .latitude(value.localizacao.getLatitude())
                    .longitude(value.localizacao.getLongitude())
                    .build();

            HospitalOutputPort hospitalOutputPort = HospitalOutputPort.builder()
                    .id(value.id)
                    .nome(value.getNome())
                    .cnpj(value.getCnpj())
                    .endereco(value.getEndereco())
                    .localizacao(localizacaoOutputPort).build();

            hospitalOutputPorts.add(hospitalOutputPort);
        }
        return hospitalOutputPorts;
    }
}
