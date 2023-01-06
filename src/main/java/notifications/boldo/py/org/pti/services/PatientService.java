package notifications.boldo.py.org.pti.services;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import notifications.boldo.py.org.pti.entities.Patient;
import notifications.boldo.py.org.pti.repositories.PatientRepository;

@Dependent
public class PatientService {

  @Inject
  PatientRepository patientRepository;

  public List<Patient> listPatients() {
    return patientRepository.listAll();
  }

  public Patient find(Long id) {
    return patientRepository.findById(id);
  }

  public Patient findById(String id){
    return patientRepository.find("patientId",id).firstResult();
  }

  public void delete(Long id) {
    var admBook = patientRepository.findById(id);
    patientRepository.delete(admBook);
  }

  public void update(Patient patient) {
    patientRepository.update(patient);
  }

  public void create(Patient patient) {
    patientRepository.persist(patient);
  }
}
