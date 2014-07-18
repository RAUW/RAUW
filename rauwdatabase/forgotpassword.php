<?php

//load and connect to MySQL database stuff
require("config.inc.php");

if (!empty($_POST)) {
    //gets user's info based on emailadres.
    $query = " 
            SELECT 
                id, 
                emailadres, 
                password,
                firstname
            FROM users 
            WHERE 
                emailadres = :email
        ";
    
    $query_params = array(
        ':email' => $_POST['emailadres']
    );
    
    try {
        $stmt   = $db->prepare($query);
        $result = $stmt->execute($query_params);
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this use this one to product JSON data:
        $response["success"] = 0;
        $response["message"] = "Oeps, daar ging iets fout!";
        die(json_encode($response));
        
    }
    
    //This will be the variable to determine whether or not the user's information is correct.
    //we initialize it as false.
    $validated_info = false;
    
    //fetching all the rows from the query
    $row = $stmt->fetch();
    if ($row) {
        //if we encrypted the password, we would unencrypt it here, but in our case we just
        //compare the two passwords
        
         if ($_POST['emailadres'] === $row['emailadres']) {
            $forgot_ok = true;
        }
    }

	// If the user emailadres is okay, then we send them an email 
    // Otherwise, we display an 'emailadress doesn't exist' message and show the forgot password form again 
    if ($forgot_ok) {
              
        $emailadres = $row['emailadres'];//fetching email
        $firstname = $row['firstname'];
        $password  =  $row['password'];//FETCHING PASS
		//echo "your pass is ::".($pass)."";
		$to = $row['emailadres'];
		//echo "your email is ::".$email;
		//Details for sending E-mail
		$from = "RAUW amsterdam";
		$subject = "Wachtwoordherstel RAUW amsterdam";
		$body = "Dag $firstname,<br><br>
		Hieronder je persoonlijke inloggegevens voor de RAUW-app:<br><br>
		E-mailadres: $emailadres <br>
		Wachtwoord: $password <br><br>
		Tot snel! <br><br>
		Groeten,<br><br>
		RAUW amsterdam";
		$headers1 = "From: $from\n";
		$headers1 .= "Content-type: text/html;charset=iso-8859-1\r\n";
		$headers1 .= "X-Priority: 1\r\n";
		$headers1 .= "X-MSMail-Priority: High\r\n";
		$headers1 .= "X-Mailer: Just My Server\r\n";

		$sentmail = mail ( $to, $subject, $body, $headers1 );
		$response["success"] = 1;
		$response["message"] = "Check je mailbox!";
        die(json_encode($response));
    } else {
        $response["success"] = 0;
        $response["message"] = "Emailadres niet geregistreerd!";
        die(json_encode($response));
    }
} else {
	?>
		<h1>Forgot Password</h1> 
		<form action="forgotpassword.php" method="post"> 
		    Emailadres:<br /> 
		    <input type="text" name="emailadres" placeholder="emailadres" /> 
		    <br /><br /> 
		   	<input type="submit" value="Send Password" /> 
		</form> 
		<a href="login.php">Login</a>
	<?php
}

?>