package afrikancoders.models;

import jakarta.persistence.*;

@Entity
public class Collaborator extends User {

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

}
