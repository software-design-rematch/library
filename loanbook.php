<?php

$servername ="ipaddress";
$user ="root";
$pass="";
$dbname="project";

$conn = mysqli_connect($servername,$user,$pass,$dbname);




if($_SERVER['REQUEST_METHOD']=='POST'){
	
	$email  = $_REQUEST['email'];	
	$isbn = $_REQUEST['isbn'];
	$bookstatus  = $_REQUEST['bookstatus'];
 	$loantime = $_REQUEST['loantime'];

	
	$check=mysqli_query($conn,("SELECT * FROM bookinformation  WHERE isbn='$isbn'"));




	if($check->num_rows===1){
	
	
		$query = "INSERT INTO `loanbook`(`email`, `isbn`, `bookstatus`, `loantime`) VALUES ('$email', '$isbn', '$bookstatus', '$loantime')";

			

	if($results=mysqli_query($conn,("SELECT * FROM loanbook WHERE email='$email'"))){
		if($results->num_rows===0){
			
			
				if(mysqli_query($conn,$query)){
		
						echo ("book is successfully loaned");
		
							      }
				else{
						echo ("something went wrong");
		
				    }
	




			}
		else{
			echo ("you can not loan 2 books,please return the book you loaned first");
			}
	}










				}
else{
	echo ("the book does not exist");
}



	


	
}
else{
	
	echo ("book not loaned");

	}





?>
