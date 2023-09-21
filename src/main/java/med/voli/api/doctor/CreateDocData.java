package med.voli.api.doctor;

import med.voli.api.address.AddressData;

public record CreateDocData(String name, String email, String crm, Specialist especialidade, AddressData endereco) {
}
