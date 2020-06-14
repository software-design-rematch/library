<?php
$username="root";
$password="";
$database="project";

$link=mysqli_connect("ipaddress",$username,$password,$database);
$output=array();
$email=$_REQUEST["email"];
$Password=$_REQUEST["password"];
$Pass=md5($Password);

$results=mysqli_query($link,("SELECT * FROM registration WHERE email='$email'"));

if($results->num_rows===1){
	
	if($check=mysqli_query($link,("SELECT * FROM registration WHERE email='$email' AND password='$Pass'"))){
		if($check->num_rows===1){
			echo "true";
			}
		else{
			echo "almost";
			}
	}
}
else{
	echo "false";
}
?>
