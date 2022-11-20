package com.example.demo;

import org.openapitools.api.PetApi;
import org.openapitools.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping({"${openapi.swaggerPetstoreOpenAPI30.base-path:/api/v3}"})
public class PetsApiController implements PetApi {
    private final NativeWebRequest request;
    private final Random rand;

    @Autowired
    public PetsApiController(NativeWebRequest request) {
        this.request = request;
        this.rand = new Random(2050L);
    }

    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(this.request);
    }

    private List<Pet> pets = new ArrayList<>();
    private Long id = 0L;
    @Override
    public ResponseEntity<Pet> addPet(@Valid Pet pet) {
        System.out.println("Adding PET "+pet);
        pet.setId(id++);
        pets.add(pet);
        return ResponseEntity.ok(pet);
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return ResponseEntity.ok(pets.stream().filter(pet -> Objects.equals(pet.getId(), petId)).findFirst().get());
    }
}
