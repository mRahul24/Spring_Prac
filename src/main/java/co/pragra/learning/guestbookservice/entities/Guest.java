package co.pragra.learning.guestbookservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.time.Instant;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Guest {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer guestId;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="addressId")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @Builder.Default
    private boolean active = true;

    @Transient
    @Builder.Default
    private Instant createDateTime = Instant.now();

}
