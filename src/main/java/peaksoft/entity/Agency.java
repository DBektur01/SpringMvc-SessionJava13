package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
public class Agency  {
    @Id
    @GeneratedValue(
            generator = "agency_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "agency_gen",
            sequenceName = "agency_seq",
            allocationSize = 1)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String country;
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull
    @Column(name = "image_link",length = 1000)
    @NotNull
    private String imageLink;
    @NotNull
    private String email;

    @OneToMany(mappedBy = "agency",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<House> houses;

    public Agency(String name, String country, String phoneNumber, String imageLink, String email) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.imageLink = imageLink;
        this.email = email;
    }
}
