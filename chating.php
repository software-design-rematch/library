<?php

$servername ="ipaddress";
$user ="root";
$pass="";
$dbname="project";

$conn = mysqli_connect($servername,$user,$pass,$dbname);




if($_SERVER['REQUEST_METHOD']=='POST'){
	
	$semail  = $_REQUEST['semail'];	
	$remail = $_REQUEST['remail'];
	$msg  = $_REQUEST['msg'];
	



   $query = "INSERT INTO `chating`(`semail`, `remail`, `msg`) VALUES ('$semail', '$remail', '$msg')";

			

	if($results=mysqli_query($conn,("SELECT * FROM registration WHERE email='$remail'"))){
		if($results->num_rows===1){
			
			
				if(mysqli_query($conn,$query)){
		
						echo ("message succesfully sent");
		
							      }
				else{
						echo ("something went wrong,msg not sent");
		
				    }
	




			}
		else{
			echo ("the receiver email is not registered");
			}
	}

}
else{
	
	echo ("msg not sent");

	}





?>
