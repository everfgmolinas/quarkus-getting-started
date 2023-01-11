package notifications.boldo.py.org.pti.services;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.quarkus.panache.common.Parameters;
import notifications.boldo.py.org.pti.repositories.DeviceRepository;

import notifications.boldo.py.org.pti.entities.Device;;

@Dependent
public class DeviceService {

  @Inject
  DeviceRepository deviceRepository;

  @Inject
  PatientService patientService;

  public List<Device> listDevices() {
    return deviceRepository.listAll();
  }

  public Device find(Long id) {
    return deviceRepository.findById(id);
  }

  public List<Device> findByFhierId(String id){
    System.out.println("asfasfasfa");
    try{

      var result = deviceRepository.list("from Device d, Patient p where d.patient.id = p.id and p.fhierId = ?1", id);
      return result;
    }catch (Exception e){
      System.out.println(e);

      throw e;
    }
  
  }

  public void delete(Long id) {
    var device = deviceRepository.findById(id);
    deviceRepository.delete(device);
  }

  public void deleteByToken(String tokenDevice) {
    var device = deviceRepository.find( "tokenDevice",tokenDevice).firstResult();
    deviceRepository.delete(device);
  }

  public void update(Device patient) {
    deviceRepository.update(patient);
  }

  public void create(Device patient) {
    deviceRepository.persist(patient);
  }
}
