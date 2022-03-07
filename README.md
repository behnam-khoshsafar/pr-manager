# Pr-Manager

## Features

- Login with Github
- Load public repositories
- Load pull requests for selected repository

## Tech
- Kotlin:1.6
- Java:17
- Spring Boot:2.6.3
- Javascript
- Html
- CSS

## Installation

### Add a New GitHub App:
To use GitHub’s OAuth 2.0 authentication system for login, 
you must first Add a new [GitHub app](https://github.com/settings/developers).
Select "New OAuth App" and then the "Register a new OAuth application" page is presented. Enter an app name and description. Then, enter your app’s home page, which should be http://localhost:8080, in this case. Finally,
indicate the Authorization callback URL as http://localhost:8080/login/oauth2/code/github and click Register Application.

Then, to make the link to GitHub, update the credentials you just created with GitHub in application.yml:
```
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            clientId: github-client-id
            clientSecret: github-client-secret
```






