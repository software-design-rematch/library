<?php

$servername ="ipaddress";
$user ="root";
$pass="";
$dbname="project";

$conn = mysqli_connect($servername,$user,$pass,$dbname);

if($conn){
	echo ("done,");
	
}
else{
	echo ("failed");

}


if($_SERVER['REQUEST_METHOD']=='POST'){
	
	$name = $_REQUEST['name'];
	$surname  = $_REQUEST['surname'];
 	$email = $_REQUEST['email'];
	$gender = $_REQUEST['gender'];
 	$password  = $_REQUEST['password'];
	$passs =md5($password);
	
	$query = "INSERT INTO `registration`(`name`, `surname`, `email`, `password`, `gender`) VALUES ('$name', '$surname', '$email', '$passs', '$gender')";

	
	
	if(mysqli_query($conn,$query)){
		
			echo ("registration successful");
		
	}
	else{
		echo ("email address already exist");
		
	}
	
}
	else{
		echo ("registration not suuccessful");
		
	}





?>
