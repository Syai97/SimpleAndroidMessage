<html>
<head>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<div class="container">
<div class="col-lg-12 well" align="center">
   <form method="post" action="push_notification.php" class="form-horizontal">
   <div class="form-group">
        <label class="col-lg-4" align="right">Select User :</label>
       <div class="col-lg-4">
        <select name="user" class="form-control">
		    <?php
			  $conn = mysqli_connect("localhost","root","","test");
			  $sql2 = "SELECT * FROM androidmsg";
			  $query = mysqli_query($conn, $sql2);

			  while ($row = mysqli_fetch_array($query)){
				  echo '<option value="'.$row['Token'].'">'.$row['nama'].' ('.$row['kp'].')</option>';
			  }

			?>
		</select>
		</div>
	  </div>
      <div class="form-group">
        <label class="col-lg-4" align="right">Write Your Message :</label>
       <div class="col-lg-4">
        <textarea name="message" class="form-control"></textarea>
		</div>
	  </div>
	  <div class="form-group">
	    <input type="submit" name="send" value="Send Message" class="btn btn-primary"/>
	  </div>
   </form>
</div>
</div>
</body>

</html>


<?php
	function send_notification ($tokens, $message)
	{
		$url = 'https://fcm.googleapis.com/fcm/send';
		$fields = array(
			 'registration_ids' => $tokens,
			 'data' => $message,
			 'sound' => 1
			);
		$headers = array(
			'Authorization:key = AAAArIKxKmU:APA91bHfiDyJqMzIDw_jgSjsJAr_B7gJWyUuDr99gBjmqdoBw3dYweIbncUmKZh3qfKQIKTmUgn6hCh91cFDyUNMWDgQpKmPE8w5cjbNqPI8mRI96aYpXrLEt00pa0tS4GHLAAFmsewJ ',
			'Content-Type: application/json'
			);
	   $ch = curl_init();
       curl_setopt($ch, CURLOPT_URL, $url);
       curl_setopt($ch, CURLOPT_POST, true);
       curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
       curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
       curl_setopt ($ch, CURLOPT_SSL_VERIFYHOST, 0);
       curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
       curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
       $result = curl_exec($ch);
       if ($result === FALSE) {
           die('Curl failed: ' . curl_error($ch));
       }
	   else
		   $success = "<div class=\"container\">
	                     <div class=\"alert alert-success\" align=\"center\"><strong>Success!</strong> Message Had Been Sent.</div>
					   </div>";

       curl_close($ch);
       return $success;
	}


	if(isset($_POST['message'])){
		$msg = $_POST['message'];
		$user = $_POST['user'];

		$conn = mysqli_connect("localhost","root","","test");
		$sql = " Select Token From androidmsg WHERE Token = '$user'";
		$result = mysqli_query($conn,$sql);
		$tokens = array();
		if(mysqli_num_rows($result) > 0 ){
			while ($row = mysqli_fetch_assoc($result)) {
				$tokens[] = $row["Token"];
			}
		}
		mysqli_close($conn);
		$message = array("message" => $msg);
		$message_status = send_notification($tokens, $message);
		echo $message_status;

	}
 ?>
