Money Lion Test Automation
========

A mini runnable test automation framework and scripts verifying test scenarios in https://www.moneylion.com/

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
2. Ensure Apache Maven >= 3.0 version is installed [installation link](https://maven.apache.org/install.html)
3. Ensure Gecko Webdriver >= v0.24.0 is install [installation link](https://docs.seleniumhq.org/download/)
3. Clone repository: `git clone https://github.com/syafiqibrahimshah/MoneyLionTestAutomation.git`
3. `cd` into the repository
4. Open /src/test/resources and fill in the path to your selenium driver
```
webdriver.driver=firefox
webdriver.gecko.driver=[PATH TO THE DRIVER]
```
5. Upon test run complete. A detailed report will be generated in /target/site/serenity/index.html
6. Open index.html with a browser.

