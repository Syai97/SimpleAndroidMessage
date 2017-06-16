<?php
	if (isset($_POST["Token"])) {

		   $_uv_Token=$_POST["Token"];
		   $nama = $_POST["Nama"];
       $kp = $_POST["ic"];

		   $conn = mysqli_connect("localhost","root","","test") or die("Error connecting");

		   $q="UPDATE androidmsg SET nama = '$nama', kp = '$kp' WHERE deviceid = '$_uv_Token'";

      mysqli_query($conn,$q) or die(mysqli_error($conn));
      mysqli_close($conn);
	}
 ?>
