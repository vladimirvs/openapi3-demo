package org.example;



import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.PetApi;
import org.openapitools.client.auth.OAuth;
import org.openapitools.client.model.Category;
import org.openapitools.client.model.Pet;
import org.openapitools.client.model.Tag;

import java.io.File;
import java.util.*;

public class PetApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/api/v3");

        // Configure OAuth2 access token for authorization: petstore_auth
        OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
        petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

        PetApi apiInstance = new PetApi();
        Pet pet = new Pet(); // Pet | Create a new pet in the store

        Long id = 789L; // Long |
        String name = "name_example"; // String |
        Category category = new Category(); // Category |
        List<String> photoUrls = Arrays.asList("photoUrls_example"); // List<String> |
        List<Tag> tags = Arrays.asList(new Tag()); // List<Tag> |
        String status = "status_example"; // String |
        pet.setId(id);
        pet.setName(name);
        pet.setCategory(category);
        pet.setPhotoUrls(photoUrls);
        pet.setTags(tags);
        pet.setStatus(Pet.StatusEnum.AVAILABLE);
        try {

            Pet result = apiInstance.addPet(pet);
            System.out.println(result);
         //   apiInstance.addPet(1L,"Name", new Category(), new ArrayList<>(), Arrays.asList(new Tag()), "");
        } catch (ApiException e) {
            System.err.println("Exception when calling PetApi#addPet "+e.getMessage());
            e.printStackTrace();
        }
    }
}
