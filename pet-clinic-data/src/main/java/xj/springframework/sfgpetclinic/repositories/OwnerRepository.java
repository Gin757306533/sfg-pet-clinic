package xj.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xj.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
