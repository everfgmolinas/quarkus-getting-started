package notifications.boldo.py.org.pti.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import notifications.boldo.py.org.pti.entities.Patient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PatientRepository implements PanacheRepository<Patient> {

    public Patient update(Patient patient) {
        return this.getEntityManager().merge(patient);
    }


}