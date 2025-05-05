package afrikancoders.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Company extends User {

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @OneToMany(mappedBy = "empresa")
    private List<Collaborator> collaborators;

}
