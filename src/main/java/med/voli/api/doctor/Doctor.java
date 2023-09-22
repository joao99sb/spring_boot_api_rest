package med.voli.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voli.api.address.Address;

import java.util.UUID;

@Table(name = "medicos")
@Entity(name="Medico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Doctor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialist specialist       ;

    @Enumerated
    private Address address;

    public Doctor(CreateDocData data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();

        this.address = new Address(data.endereco());
        this.specialist = data.especialidade();
    }
}
