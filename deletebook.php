<?php
$username="root";
$password="";
$database="project";
$conn = mysqli_connect("ipaddress",$username,$password,$database);

$output=Array();

$isbn=$_REQUEST["ISBN"];


$results=mysqli_query($conn,("SELECT * FROM bookinformation WHERE isbn='$isbn'"));

if($results->num_rows===1){
$sql ="DELETE FROM bookinformation WHERE isbn='$isbn'";

if (mysqli_query($conn, $sql)) {
    echo "BOOK SUCCESSFULLY DELETED";
} else {
    echo "BOOK NOT DELETED"; 
}
}
else{
	echo "THE BOOK DOES NOT EXIST IN THE DATABASE";
}
?> 

