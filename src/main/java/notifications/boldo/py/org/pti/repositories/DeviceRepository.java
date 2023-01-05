package notifications.boldo.py.org.pti.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import notifications.boldo.py.org.pti.entities.Device;

public class DeviceRepository implements PanacheRepository<Device> {

    public Device update(Device device) {
        return this.getEntityManager().merge(device);
    }
    
}
