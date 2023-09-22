package med.voli.api.doctor;

public record DoctorReturn(
        String name,
        String email,
        String crm,
        Specialist especialidade

){
    public DoctorReturn(Doctor doctor){

        this(doctor.getName(),doctor.getEmail(),doctor.getCrm(),doctor.getSpecialist());
    }
}
