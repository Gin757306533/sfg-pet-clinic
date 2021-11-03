package xj.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xj.springframework.sfgpetclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    final Long ownerId = 1L;
    final String lastName = "xu";
    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder()
                .id(ownerId)
                .lastName(lastName)
                .build());
    }

    @Test
    void findAll() {
        var ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        var owner2 = Owner.builder().id(2L).build();

        var savedOwner = ownerServiceMap.save(owner2);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        var owner2 = Owner.builder().build();

        var savedOwner = ownerServiceMap.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        var owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        var xu = ownerServiceMap.findByLastName(lastName);

        assertNotNull(xu);
        assertEquals(lastName, xu.getLastName());
    }
}