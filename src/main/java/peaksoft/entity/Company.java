package peaksoft.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "companies")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY
            ,generator = "company_id")
    @SequenceGenerator(name = "company_id",
            sequenceName = "company_seq",
            allocationSize = 1)
    @Id
    private Long id;
    private String name;
    private String imageURL;
    private String description;

    public Company(String name, String imageURL, String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
    }
}
