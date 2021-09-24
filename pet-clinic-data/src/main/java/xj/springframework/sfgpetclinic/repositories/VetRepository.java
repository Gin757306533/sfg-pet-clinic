package xj.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xj.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
