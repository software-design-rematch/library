<?php

$servername ="ipaddress";
$user ="root";
$pass="";
$dbname="project";

$conn = mysqli_connect($servername,$user,$pass,$dbname);



if($_SERVER['REQUEST_METHOD']=='POST'){
	
	$email  = $_REQUEST['email'];	
	$isbn = $_REQUEST['isbn'];
 	$returntime = $_REQUEST['returntime'];

	
	$check=mysqli_query($conn,("SELECT * FROM loanbook  WHERE isbn='$isbn' AND email='$email'"));




	if($check->num_rows===1){
	
	
		$query = "INSERT INTO `returnbook`(`email`, `isbn` , `returntime`) VALUES ('$email', '$isbn', '$returntime')";
		$sql ="DELETE FROM loanbook WHERE isbn='$isbn'";

		
			if(mysqli_query($conn, $query)){
					if(mysqli_query($conn,$sql)){
						 echo "BOOK SUCCESSFULLY RETURNED";
								}
					else{
							echo "BOOK NOT RETURNED"; 
						}
				

		
				   
			} 





				}
else{
	echo ("you are not allowed to return this book");
}



	


	
}
else{
	
	echo ("book not returned");

	}





?>
