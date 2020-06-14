<?php
$username = "root";
$password = "";
$database = "project";

$link = mysqli_connect("ipaddress", $username, $password, $database);

$output=array();
$searchh=$_REQUEST["searchkey"];


if ($result = mysqli_query($link, "SELECT * FROM bookinformation WHERE author='$searchh' OR bookname='$searchh'")) {
while ($row=$result->fetch_assoc()){
$output[]=$row;
}
}
mysqli_close($link);
echo json_encode($output);
?>
