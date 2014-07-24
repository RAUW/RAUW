<?php include('_header.php'); ?>

<!-- show registration form, but only if we didn't submit already -->
<?php if (!$registration->registration_successful && !$registration->verification_successful) { ?>

	<form method="post" action="register.php" name="registerform">

	<label for="first_name"><?php echo WORDING_FIRSTNAME; ?></label>
    <input id="first_name" type="text" name="first_name" required />

    <label for="middle_name"><?php echo WORDING_MIDDLENAME; ?></label>
    <input id="middle_name" type="text" name="middle_name" />

    <label for="last_name"><?php echo WORDING_LASTNAME; ?></label>
    <input id="last_name" type="text" name="last_name" required />

    <label for="telephone_number"><?php echo WORDING_TELEPHONE; ?></label>
    <input id="telephone_number" type="tel" name="telephone_number" pattern=".{10,}" required />

    <label for="date_of_birth"><?php echo WORDING_DATEOFBIRTH; ?></label>
    <input id="date_of_birth" type="date" name="date_of_birth" required />

    <label for="user_email"><?php echo WORDING_REGISTRATION_EMAIL; ?></label>
    <input id="user_email" type="email" name="user_email" required />

    <label for="user_password_new"><?php echo WORDING_REGISTRATION_PASSWORD; ?></label>
    <input id="user_password_new" type="password" name="user_password_new" pattern=".{6,}" required autocomplete="off" />

    <label for="user_password_repeat"><?php echo WORDING_REGISTRATION_PASSWORD_REPEAT; ?></label>
    <input id="user_password_repeat" type="password" name="user_password_repeat" pattern=".{6,}" required autocomplete="off" />

    <input type="submit" name="register" value="<?php echo WORDING_REGISTER; ?>" />
</form>

<?php } ?>

    <a href="index.php"><?php echo WORDING_BACK_TO_LOGIN; ?></a>

<?php include('_footer.php'); ?>
