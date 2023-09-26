package med.voli.api.doctor;

import jakarta.validation.constraints.NotNull;

public record UpdateDoctorData(
        @NotNull
        Long id,
        String name){
}
