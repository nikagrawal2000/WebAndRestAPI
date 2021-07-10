@Backend
Feature: PetStore API

@addNewPet
Scenario: POST request for adding new Pet Details
Given "POST" request
When Customer "adds" dog with name "firstDog" with ID "123224"
Then I receive response code "200"

@getPetDetails
Scenario: GET request to retrieve Pet Details
Given "GET" request
When Customer "checks" dog with name "firstDog" with ID "123224"
Then I receive response code "200"
And Customer "verifies" dog with name "firstDog" with ID "123224"

@updatePetInformation
Scenario: PUT request to update Pet Details
Given "PUT" request
When Customer "updates" dog with name "secondDog" with ID "123224"
Then I receive response code "200"
And Customer "verifies" dog with name "secondDog" with ID "123224"

@deletePetDetails
Scenario: DELETE request to delete Pet Details
Given "DELETE" request
When Customer "deletes" dog with name "secondDog" with ID "123224"
Then I receive response code "200"


