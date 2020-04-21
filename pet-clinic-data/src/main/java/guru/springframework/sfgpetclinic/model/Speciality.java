package guru.springframework.sfgpetclinic.model;

/**
 * Created by jt on 7/29/18.
 */
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "specialties")
public class Speciality extends BaseEntity {

//  @Column(name = "description")
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
