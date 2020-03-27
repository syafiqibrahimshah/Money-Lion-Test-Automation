Money Lion Test Automation
========

Sample test automation framework.

## Usage

Run all tests:

```
$ mvn clean verify
```

Run API tests only:

```
$ mvn clean verify -Dtags="component:API"
```

Run UI tests only:

```
$ mvn clean verify -Dtags="component:UI"
```

## Preparing for Execution

Follow these steps:

1. Ensure Java >= 1.8 version is installed [installation link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Ensure Apache Maven >= 3.6.1 version is installed [installation link](https://maven.apache.org/install.html)
3. Ensure Selenium Gecko Webdriver >= v0.24.0 is install [installation link](https://docs.seleniumhq.org/download/)
4. Clone repository: `git clone https://github.com/syafiqibrahimshah/MoneyLionTestAutomation.git`.
5. `cd` into the repository.
6. vi `/src/test/resources/serenity.properties`. Fill in the path to the Selenium Gecko webdriver.
```
webdriver.driver=firefox
webdriver.gecko.driver=[PATH TO THE DRIVER]
```
7. Run test `mvn clean verify`.
8. Upon test run complete. A detailed report will be generated in `/target/site/serenity/index.html`.
9. Open `index.html` file with a browser to view report.

## Preparing for Development

Follow these steps:
1. Install Eclipse IDE.
2. Import -> Maven -> Existing Maven Projects.

