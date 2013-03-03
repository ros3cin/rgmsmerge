import org.apache.shiro.SecurityUtils
import pages.ArticleCreatePage
import pages.ArticlesPage
import pages.LoginPage
import pages.RegistrationPage
import pages.MembersListPage
import pages.PublicationsPage
import rgms.publication.Periodico
import steps.TestDataAndOperations

import static cucumber.api.groovy.EN.*

Given(~'I am at the Member Listagem page') { ->
    to LoginPage
    at LoginPage
    page.fillLoginData("admin", "adminadmin")
    at PublicationsPage
    page.select("Member")
    at MembersListPage
}

When (~'I select the "([^"]*)" menu option') { String option ->
    page.menuSelect(option)
}

Then (~'I am redirected to the Publications Menu page') { ->
    at PublicationsPage
}

Given(~'I am at the Login Page') { ->
    to LoginPage
}
When(~'I try to login with an user that does not exist'){ ->
    at LoginPage
    page.fillLoginData('NonExistentUser','NonExistentUserPass')
}
Then(~'A login failure message is displayed'){ ->
    at LoginPage
    assert (page.flashMessage() != null)
}

Given(~'I am at the Registration Page') {  ->
     to RegistrationPage
}
When(~'I register a user with success')  {  ->
     at RegistrationPage
     page.fillFormWithValidInfo()
}
Then(~'A message indicating the user was successfully registered is displayed at login page'){->
     at RegistrationPage
     assert (page.flashMessage() != null)
}

Given (~'I am not logged') {    ->
    assert SecurityUtils.subject?.principal == null
}

When (~'I access the Publications Menu Page') {  ->
    to LoginPage
    at LoginPage
    page.fillLoginData("admin", "adminadmin")
}

Then (~'I am redirected to the Login Page') { ->
    at LoginPage

}

