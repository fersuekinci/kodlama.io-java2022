package kodlama.io.Kodlama.io.Devs.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Table(name="languages")
@Data // Getter, Setter, parametresiz cons?? ve gerekli fonk oluşturur.
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "language")
    private List<Technology> technologiest;
}
