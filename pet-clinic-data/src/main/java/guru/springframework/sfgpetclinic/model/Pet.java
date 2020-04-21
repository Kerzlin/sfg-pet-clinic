package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * Created by jt on 7/13/18.
 */
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "pets")
public class Pet extends BaseEntity {

  //@Builder
 // public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
   // super(id);
//    this.name = name;
//    this.petType = petType;
//    this.owner = owner;
//    this.birthDate = birthDate;
//
//    if (visits == null || visits.size() > 0 ) {
//      this.visits = visits;
//    }
//  }

//  @Column(name = "name")
//  private String name;
//
//  @ManyToOne
//  @JoinColumn(name = "type_id")
  private PetType petType;
//
//  @ManyToOne
//  @JoinColumn(name = "owner_id")
  private Owner owner;
//
//  @Column(name = "birth_date")
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;
//
//  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
//  private Set<Visit> visits = new HashSet<>();

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
}
