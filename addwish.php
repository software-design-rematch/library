<?php

$servername ="ipaddress";
$user ="root";
$pass="";
$dbname="project";

$conn = mysqli_connect($servername,$user,$pass,$dbname);




if($_SERVER['REQUEST_METHOD']=='GET'){
	
	$email = $_REQUEST['email'];
	$wish  = $_REQUEST['wish'];
 	$time = $_REQUEST['time'];


	$query = "INSERT INTO `wish`(`email`, `wish`, `time`) VALUES ('$email', '$wish', '$time')";

	
	
	if(mysqli_query($conn,$query)){
		
			echo ("successfully added to wish list");
		
	}
	else{
		echo ("something went wrong,nothing added to wish list");
		
	}
	
}
	else{
		echo ("something went wrong");
		
	}





?>
