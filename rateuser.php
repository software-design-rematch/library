<?php

$username="root";
$password="cassius98";
$database="cassius";

$conn=mysqli_connect("ipaddress",$username,$password,$database);


if($_SERVER['REQUEST_METHOD']=='POST'){
	
	$email  = $_REQUEST['email'];	
	$remail = $_REQUEST['remail'];
 	$ratee = $_REQUEST['ratee'];

	
	$check=mysqli_query($conn,("SELECT * FROM REGISTRATION  WHERE email='$remail'"));




	if($check->num_rows===1){
	
	
		$query = "INSERT INTO `rateuser`(`email`, `remail` , `ratee`) VALUES ('$email', '$remail', '$ratee')";


		
			if(mysqli_query($conn, $query)){
						 echo "you have successfully rated the user";
								}
					else{
							echo "USER NOT RATED"; 
						}
				

		
				   
			 





				}
else{
	echo ("THE USER YOU ARE TRYING TO RATE DOES NOT EXIST");
}



	


	
}
else{
	
	echo ("user not rated");

	}





?>
