# About the Project

Simple web automation framework using Playwright, Cucumber, JUnit and Page Object pattern in order to increase the knowledge of such tools. The application under test is https://www.saucedemo.com/

## Getting Started

### Prerequisites
- OpenJDK 17+
- Apache Maven 3.9.3+

### Installation
1. Clone the repo
```
git clone https://github.com/BrunoFBarbosa/playwright-cucumber-automation.git
```
2. Navigate to the project's folder and install the dependencies
```
cd playwright-cucumber-automation/
mvn clean install
```

### Project's Structure
`/features`

Folder where all the BDD test scenarios are located

`/src/test/resources`

Folder with the configuration for the QA and local environments

In order to run the tests you will need to configure the `uat.properties` file from the qa or local folder.

Example configuration:

```
BrowserName=chrome
HeadlessBrowser=true
LoginPageUrl=https://www.saucedemo.com/
ValidUser=standard_user
LockedUser=locked_out_user
ValidPassword=secret_sauce
```
`/src/test/java/com/automation/support/properties`

- Folder related to the classes used for reading the properties file


`/src/test/java/com/automation/uat/features/login`

- Folder related to the Login test cases, steps definitions and dependency injection

`/src/test/java/com/automation/uat/pages`

- Folder related to the Page Object classes


`/src/test/java/com/automation/uat/support`

- Folder related to general classes for support


### Running the Tests
In order to run the tests you can use the `mvn test` command

Examples:

1. Running the LoginTest class using the QA properties:
```
mvn test -Dtest=com.automation.uat.features.login.LoginTest -DQA_ENVIRONMENT=qa
```

2. Running the LoginTest class using the QA properties with **only** the tests tagged as "negative":
```
mvn test -Dtest=com.automation.uat.features.login.LoginTest -DQA_ENVIRONMENT=qa -Dgroups="negative"
```

3. Running the LoginTest class using the QA properties **excluding** the tests tagged as "negative":
```
mvn test -Dtest=com.automation.uat.features.login.LoginTest -DQA_ENVIRONMENT=qa -DexcludedGroups="negative"
```
