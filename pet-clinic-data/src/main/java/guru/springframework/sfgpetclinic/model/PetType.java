package guru.springframework.sfgpetclinic.model;

/**
 * Created by jt on 7/13/18.
 */

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "types")
public class PetType extends BaseEntity {

//  @Builder
//  public PetType(Long id, String name) {
//   // super(id);
//    this.name = name;
//  }
//
//  @Column(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
//
//
//  @Override
//  public String toString() {
//    return name;
//  }
}
