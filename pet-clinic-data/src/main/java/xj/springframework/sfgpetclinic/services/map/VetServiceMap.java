package xj.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import xj.springframework.sfgpetclinic.model.Speciality;
import xj.springframework.sfgpetclinic.model.Vet;
import xj.springframework.sfgpetclinic.services.SpecialtyService;
import xj.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId()==null) {
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId((savedSpecialty.getId()));
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
