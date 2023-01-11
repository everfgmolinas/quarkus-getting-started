package notifications.boldo.py.org.pti.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

@Table(name = "device")
@Entity
public class Device {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    public String tokenDevice;

    // describe if the device is Android, IOs or Other
    @NotNull
    public String operativeSystem;

    @ColumnDefault("TRUE")
    public Boolean active;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    public Patient patient;

}
