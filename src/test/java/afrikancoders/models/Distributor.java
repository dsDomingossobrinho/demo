package afrikancoders.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "distributor")
public class Distributor extends User {

    @OneToMany(mappedBy = "distributor")
    private List<Collaborator> collaborators;

}
