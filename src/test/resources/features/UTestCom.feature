#Author: Juan David Salgado Ariza
@stories
Feature: Test Utest
  As a User, I want to register myself on the website UTest.com.

  @register
  Scenario: Approved Register
    Given Than Juan want to register himself on the website
    When He complete the first part of the registry
      | FirstName  | LastName      | EmailAddress         | BirthMonth | BirthDay | BirthYear | Languages |
      | Juan David | Salgado Ariza | jdsa181922@gmail.com | May        | 22       | 2003      | Spanish   |
    And He complete the second part
      | City   | Zip    | Country  |
      | Soacha | 250056 | Colombia |
    And He complete the third part
      | oSComputer | VersionOSComputer | LanguageOSComputer | BrandMobile | ModelMobile | OSMobile   |
      | Windows    | 7 64-bit          | Spanish            | Motorola    | Moto G20    | Android 11 |
    And He complete the fourth part
      | password      | confirmPassword |
      | Contrasena33* | Contrasena33*   |
    Then He can see the welcome message on the website
