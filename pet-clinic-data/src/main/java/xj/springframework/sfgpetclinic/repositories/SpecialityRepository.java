package xj.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xj.springframework.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
