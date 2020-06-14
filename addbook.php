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
	
	$isbn = $_REQUEST['isbn'];
	$bookname  = $_REQUEST['bookname'];
 	$author = $_REQUEST['author'];
	$location = $_REQUEST['location'];
 	$email  = $_REQUEST['email'];

	$query = "INSERT INTO `bookinformation`(`isbn`, `bookname`, `author`, `location`, `email`) VALUES ('$isbn', '$bookname', '$author', '$location', '$email')";

	
	
	if(mysqli_query($conn,$query)){
		
			echo ("book is successfully added");
		
	}
	else{
		echo ("book already exist in the database");
		
	}
	
}
	else{
		echo ("book is not added");
		
	}





?>
