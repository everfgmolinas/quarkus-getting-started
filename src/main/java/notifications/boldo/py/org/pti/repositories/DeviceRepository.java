package notifications.boldo.py.org.pti.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import notifications.boldo.py.org.pti.entities.Device;

@ApplicationScoped
public class DeviceRepository implements PanacheRepository<Device> {

    public Device update(Device device) {
        return this.getEntityManager().merge(device);
    }
    
}
