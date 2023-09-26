package med.voli.api.doctor;

public record DoctorReturn(
        Long id,
        String name,
        String email,
        String crm,
        Specialist specialist

){
    public DoctorReturn(Doctor doctor){

        this(doctor.getId(),doctor.getName(),doctor.getEmail(),doctor.getCrm(),doctor.getSpecialist());
    }
}
