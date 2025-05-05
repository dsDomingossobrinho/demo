package afrikancoders.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Furnisher extends User {

    @OneToMany(mappedBy = "furnisher")
    private List<Collaborator> collaborators;

    @OneToMany(mappedBy = "furnisher")
    private List<Distributor> distributors;
}
