package notifications.boldo.py.org.pti.entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "patient")
@Entity
public class Patient {

    @Id
    @GeneratedValue
    private long id;

    @Column
    @NotNull
    private String fhierId;

    @Column
    private String givenName;

    @Column
    public String familyName;

    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    private Set<Device> device;

}

