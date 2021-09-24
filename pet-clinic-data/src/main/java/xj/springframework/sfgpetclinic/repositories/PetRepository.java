package xj.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xj.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
