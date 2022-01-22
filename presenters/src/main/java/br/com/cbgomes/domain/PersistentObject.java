package br.com.cbgomes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersistentObject {

    @Id
    @Column ( name = "id", nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
