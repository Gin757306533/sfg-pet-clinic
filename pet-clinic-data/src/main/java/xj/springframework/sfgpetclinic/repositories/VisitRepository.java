package xj.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xj.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
