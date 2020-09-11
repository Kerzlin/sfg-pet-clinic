package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter // klase koje se inherituju najbolje dodate geter i seter
@MappedSuperclass
public class Person extends BaseEntity {

  public Person(Long id, String firstName, String lastName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Column(name = "first_name")
  @NotEmpty
  private String firstName;

 @Column(name = "last_name")
 @NotEmpty
  private String lastName;

}
