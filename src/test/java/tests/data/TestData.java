package tests.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("es"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                    "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1990, 2000)),
            subjects = faker.options().option("Social Studies", "Arts", "Chemistry"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("pic.jpg", "pic1.jpg", "pic2.jpg"),
            streetAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state),
            successTitle = "Thanks for submitting the form",
            color = "rgb(220, 53, 69)",
            borderColor = "border-color";

    public String setCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }
    }
}
