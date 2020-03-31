package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

//@NoArgsConstructor
//@AllArgsConstructor
//@MappedSuperclass
public class BaseEntity implements Serializable {

 // @Id
 // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

//  public BaseEntity(Long id) {
//    this.id = id;
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  public boolean isNew() {
//    return this.id == null;
//  }
}
