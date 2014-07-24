<?php

/**
 * Please note: we can use unencoded characters like ö, é etc here as we use the html5 doctype with utf8 encoding
 * in the application's header (in views/_header.php). To add new languages simply copy this file,
 * and create a language switch in your root files.
 */

// login & registration classes
define("MESSAGE_ACCOUNT_NOT_ACTIVATED", "Je account is nog niet geactiveerd. Check je mailbox en klik op de link.");
//define("MESSAGE_CAPTCHA_WRONG", "Captcha was wrong!");
define("MESSAGE_COOKIE_INVALID", "Ongeldig cookie.");
define("MESSAGE_DATABASE_ERROR", "Database verbindingsprobleem.");
define("MESSAGE_EMAIL_ALREADY_EXISTS", "Dit e-mailadres is al geregistreerd. Klik op \"Wachtwoord vergeten\" als je je wachtwoord vergeten bent.");
define("MESSAGE_EMAIL_CHANGE_FAILED", "Oops, wijzigen van je e-mailadres mislukt");
define("MESSAGE_EMAIL_CHANGED_SUCCESSFULLY", "Je e-mailadres is succesvol gewijzigd, naar: ");
define("MESSAGE_EMAIL_EMPTY", "Vul je e-mailadres in.");
define("MESSAGE_EMAIL_INVALID", "Gebruik een correct format voor je e-mailadres.");
define("MESSAGE_EMAIL_SAME_LIKE_OLD_ONE", "Kies alsjeblieft een ander e-mailadres als je huidige.");
define("MESSAGE_EMAIL_TOO_LONG", "Je e-mailadres mag niet langer zijn dan 64 tekens.");
define("MESSAGE_LINK_PARAMETER_EMPTY", "Lege link parameter data.");
define("MESSAGE_LOGGED_OUT", "Je bent nu uitgelogd.");
// The "login failed"-message is a security improved feedback that doesn't show a potential attacker if the user exists or not
define("MESSAGE_LOGIN_FAILED", "Inloggen mislukt.");
define("MESSAGE_OLD_PASSWORD_WRONG", "Je OUDE wachtwoord klopt niet.");
define("MESSAGE_PASSWORD_BAD_CONFIRM", "Je nieuwe wachtwoorden komen niet overeen.");
define("MESSAGE_PASSWORD_CHANGE_FAILED", "Oops, wachtwoord wijzigen mislukt.");
define("MESSAGE_PASSWORD_CHANGED_SUCCESSFULLY", "Wachtwoord succesvol gewijzigd.");
define("MESSAGE_PASSWORD_EMPTY", "Vul je wachtwoord in.");
define("MESSAGE_PASSWORD_RESET_MAIL_FAILED", "Wachtwoord reset e-mail niet succesvol verzonden. Error: ");
define("MESSAGE_PASSWORD_RESET_MAIL_SUCCESSFULLY_SENT", "Wachtwoord reset e-mail succesvol verzonden.");
define("MESSAGE_PASSWORD_TOO_SHORT", "Wachtwoord dient een minimum lengte van 6 tekens te hebben.");
define("MESSAGE_PASSWORD_WRONG", "Verkeerd wachtwoord. Probeer opnieuw.");
define("MESSAGE_PASSWORD_WRONG_3_TIMES", "Je hebt 3 keer een verkeerd wachtwoord ingevoerd. Probeer het over 30 seconden opnieuw.");
define("MESSAGE_PHONE_TOO_LONG", "Vul 10 cijfers in als telefoonnummer.");
define("MESSAGE_REGISTRATION_ACTIVATION_NOT_SUCCESSFUL", "Oops, combinatie e-mailadres en verificatie code niet gevonden.");
define("MESSAGE_REGISTRATION_ACTIVATION_SUCCESSFUL", "Activatie succesvol. Je kunt inloggen!");
define("MESSAGE_REGISTRATION_FAILED", "Oops, registratie mislukt. Probeer het opnieuw.");
define("MESSAGE_RESET_LINK_HAS_EXPIRED", "Je reset-link is verlopen. Gebruik deze link alsjeblieft binnen 60 minuten.");
define("MESSAGE_VERIFICATION_MAIL_ERROR", "Oops, verificatie e-mail niet verzonden. Je account is nog niet geregistreerd.");
define("MESSAGE_VERIFICATION_MAIL_NOT_SENT", "Verificatie e-mail niet succesvol verzonden. Error: ");
define("MESSAGE_VERIFICATION_MAIL_SENT", "Account succesvol geregistreerd. Check je mailbox en klik op de link als laatste stap.");
define("MESSAGE_USER_DOES_NOT_EXIST", "Deze account bestaat niet.");
//define("MESSAGE_USERNAME_BAD_LENGTH", "Username cannot be shorter than 2 or longer than 64 characters");
//define("MESSAGE_USERNAME_CHANGE_FAILED", "Sorry, your chosen username renaming failed");
//define("MESSAGE_USERNAME_CHANGED_SUCCESSFULLY", "Your username has been changed successfully. New username is ");
//define("MESSAGE_USERNAME_EMPTY", "Username field was empty");
define("MESSAGE_USERNAME_EXISTS", "Dit e-mailadres staat al geregistreerd.");
//define("MESSAGE_USERNAME_INVALID", "Username does not fit the name scheme: only a-Z and numbers are allowed, 2 to 64 characters");
//define("MESSAGE_USERNAME_SAME_LIKE_OLD_ONE", "Sorry, that username is the same as your current one. Please choose another one.");

// views
define("WORDING_BACK_TO_LOGIN", "Terug naar Inlogpagina");
define("WORDING_CHANGE_EMAIL", "Wijzig e-mailadres");
define("WORDING_CHANGE_PASSWORD", "Wijzig wachtwoord");
//define("WORDING_CHANGE_USERNAME", "Change username");
define("WORDING_CURRENTLY", "huidig");
define("WORDING_EDIT_USER_DATA", "Wijzig gegevens");
define("WORDING_EDIT_YOUR_CREDENTIALS", "Je bent ingelogd en kunt hier je gegevens wijzigen");
define("WORDING_FORGOT_MY_PASSWORD", "Wachtwoord vergeten");
define("WORDING_LOGIN", "Log in");
define("WORDING_LOGOUT", "Log uit");
define("WORDING_NEW_EMAIL", "Nieuw e-mailadres");
define("WORDING_NEW_PASSWORD", "Nieuw wachtwoord");
define("WORDING_NEW_PASSWORD_REPEAT", "Herhaal nieuw wachtwoord");
//define("WORDING_NEW_USERNAME", "New username (username cannot be empty and must be azAZ09 and 2-64 characters)");
define("WORDING_OLD_PASSWORD", "Je OUDE wachtwoord");
define("WORDING_PASSWORD", "Wachtwoord");
define("WORDING_PROFILE_PICTURE", "Je profielfoto (van gravatar):");
define("WORDING_REGISTER", "Registreren");
define("WORDING_REGISTER_NEW_ACCOUNT", "Registreren");
//define("WORDING_REGISTRATION_CAPTCHA", "Please enter these characters");
define("WORDING_REGISTRATION_EMAIL", "E-mailadres (je krijgt een verificatie-link)");
define("WORDING_REGISTRATION_PASSWORD", "Wachtwoord (min. 6 tekens)");
define("WORDING_REGISTRATION_PASSWORD_REPEAT", "Wachtwoord herhalen");
//define("WORDING_REGISTRATION_USERNAME", "Username (only letters and numbers, 2 to 64 characters)");
define("WORDING_REMEMBER_ME", "Login onthouden");
define("WORDING_REQUEST_PASSWORD_RESET", "Vul je e-mailadres in en ontvang een e-mail met instructies");
define("WORDING_RESET_PASSWORD", "Reset mijn wachtwoord");
define("WORDING_SUBMIT_NEW_PASSWORD", "Bevestig nieuw wachtwoord");
define("WORDING_USEREMAIL", "E-mailadres");
define("WORDING_YOU_ARE_LOGGED_IN_AS", "Welkom, ");

define("WORDING_FIRSTNAME", "Voornaam");
define("WORDING_MIDDLENAME", "Tussenvoegsel");
define("WORDING_LASTNAME", "Achternaam");
define("WORDING_TELEPHONE", "06-nummer");
define("WORDING_DATEOFBIRTH", "Geboortedatum");
