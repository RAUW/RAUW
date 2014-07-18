<?php

require ("config.inc.php");

if(!empty($_POST)){

    //If the emailadres or password is empty when the user submits
    //the form, the page will die.
    //Using die isn't a very good practice, you may want to look into
    //displaying an error message within the form instead.  
    //We could also do front-end form validation from within our Android App,
    //but it is good to have a have the back-end code do a double check.
    if (empty($_POST['emailadres']) || empty($_POST['password']) ||
        empty($_POST['firstname']) || empty($_POST['lastname']) ||
        empty($_POST['telephone']) || empty($_POST['dateofbirth'])) {
        
        // Create some data that will be the JSON response 
        $response["success"] = 0;
        $response["message"] = "Vul alsjeblieft alle velden in!";
        
        //die will kill the page and not execute any code below, it will also
        //display the parameter... in this case the JSON data our Android
        //app will parse
        die(json_encode($response));
    }
    
    //if the page hasn't died, we will check with our database to see if there is
    //already a user with the emailadres specificed in the form.  ":email" is just
    //a blank variable that we will change before we execute the query.  We
    //do it this way to increase security, and defend against sql injections
    $query        = " SELECT 1 FROM users WHERE emailadres = :email";
    //now lets update what :email should be
    $query_params = array(
        ':email' => $_POST['emailadres']
    );
    
    //Now let's make run the query:
    try {
        // These two statements run the query against your database table. 
        $stmt   = $db->prepare($query);
        $result = $stmt->execute($query_params);
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this one to product JSON data:
        $response["success"] = 0;
        $response["message"] = "Oeps, daar ging iets fout!";
        die(json_encode($response));
    }
    
    //fetch is an array of returned data.  If any data is returned,
    //we know that the emailadres is already in use, so we murder our
    //page
    $row = $stmt->fetch();
    if ($row) {
        // For testing, you could use a die and message. 
        //die("This username is already in use");
        
        //You could comment out the above die and use this one:
        $response["success"] = 0;
        $response["message"] = "Dit E-mailadres is al in gebruik";
        die(json_encode($response));
    }
    
      //If we have made it here without dying, then we are in the clear to 
    //create a new user.  Let's setup our new query to create a user.  
    //Again, to protect against sql injects, user tokens such as :email and :pass
    $query = "INSERT INTO users ( emailadres, password, firstname, lastname, telephone, dateofbirth ) VALUES ( :email, :pass, :first, :last, :phone, :birth ) ";
    
    //Again, we need to update our tokens with the actual data:
    $query_params = array(
        ':email' => $_POST['emailadres'],
        ':pass' => $_POST['password'],
        ':first' => $_POST['firstname'],
        ':last' => $_POST['lastname'],
        ':phone' => $_POST['telephone'],
        ':birth' => $_POST['dateofbirth']
    );
    
    //time to run our query, and create the user
    try {
        $stmt   = $db->prepare($query);
        $result = $stmt->execute($query_params);
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this one:
        $response["success"] = 0;
        $response["message"] = "Oeps, daar ging iets fout!";
        die(json_encode($response));
    }
    
    //If we have made it this far without dying, we have successfully added
    //a new user to our database.  We could do a few things here, such as 
    //redirect to the login page.  Instead we are going to echo out some
    //json data that will be read by the Android application, which will login
    //the user (or redirect to a different activity, I'm not sure yet..)
    $response["success"] = 1;
    $response["message"] = "Gebruiker succesvol geregistreerd!";
    echo json_encode($response);
    
    //for a php webservice you could do a simple redirect and die.
    //header("Location: login.php"); 
    //die("Redirecting to login.php");
    
} else {
?>
    <h1>Register</h1> 
    <form action="register.php" method="post"> 
        Emailadres:<br /> 
        <input type="text" name="emailadres" placeholder="emailadres" /> 
        <br /><br /> 
        Password:<br /> 
        <input type="password" name="password" placeholder="password" /> 
        <br /><br /> 
        First name:<br />
        <input type="firstname" name="firstname" placeholder="first name" /> 
        <br /><br /> 
        Last name:<br />
        <input type="lastname" name="lastname" placeholder="last name" /> 
        <br /><br /> 
        Telephone:<br />
        <input type="telephone" name="telephone" placeholder="telephone" /> 
        <br /><br /> 
        Date of Birth:<br />
        <input type="dateofbirth" name="dateofbirth" placeholder="date of birth" /> 
        <br /><br /> 
        <input type="submit" value="Register New User" /> 
    </form>
    <a href="login.php">Login</a><br>
    <?php
}

?>
