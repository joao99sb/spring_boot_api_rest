package med.voli.api.address;

import jakarta.validation.constraints.NotBlank;

public record AddressData(
        @NotBlank
        String uf,
        @NotBlank
        String cidade){
}
