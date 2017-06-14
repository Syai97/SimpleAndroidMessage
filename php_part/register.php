<?php 
	if (isset($_POST["Token"])) {
		
		   $_uv_Token=$_POST["Token"];
		   $deviceid = $_POST["deviceid"];
		   $conn = mysqli_connect("localhost","root","","test") or die("Error connecting");
		   $q="INSERT INTO androidmsg (username, Token) VALUES ( '$deviceid', '$_uv_Token' ) "
              ." ON DUPLICATE KEY UPDATE Token = '$_uv_Token';";
              
      mysqli_query($conn,$q) or die(mysqli_error($conn));
      mysqli_close($conn);
	}
 ?>