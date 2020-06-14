<?php

$username="root";
$password="cassius98";
$database="cassius";

$conn=mysqli_connect("ipaddress",$username,$password,$database);


if($_SERVER['REQUEST_METHOD']=='POST'){
	
	$email  = $_REQUEST['email'];	
	$nm = $_REQUEST['nm'];
 	$ratee = $_REQUEST['ratee'];

	
	$check=mysqli_query($conn,("SELECT * FROM bookinformation  WHERE bookname='$nm'"));




	if($check->num_rows===1){
	
	
		$query = "INSERT INTO `ratebook`(`email`, `nm` , `ratee`) VALUES ('$email', '$nm', '$ratee')";


		
			if(mysqli_query($conn, $query)){
						 echo "you have successfully rated the book";
								}
					else{
							echo "BOOK NOT RATED"; 
						}
				

		
				   
			 





				}
else{
	echo ("THE BOOK YOU ARE TRYING TO RATE DOES NOT EXIST");
}



	


	
}
else{
	
	echo ("book not rated");

	}





?>
