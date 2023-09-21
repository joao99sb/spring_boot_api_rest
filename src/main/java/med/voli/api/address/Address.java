package med.voli.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address{
    private String uf;
    private String city;

    public Address(AddressData address) {
        this.city = address.cidade();
        this.uf = address.uf();
    }
}
