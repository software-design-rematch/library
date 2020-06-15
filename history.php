<?php
$username = "root";
$password = "";
$database = "project";


$link = mysqli_connect("ipaddress", $username, $password, $database);

$email =$_REQUEST["email"];
$output=array();


if ($result = mysqli_query($link, "SELECT * FROM returnbook where email='$email'")) {
while ($row=$result->fetch_assoc()){
$output[]=$row;
}
}
mysqli_close($link);
echo json_encode($output);
?>
