<?php
    require "conn.php";
    $user_email = $_POST["email"];
    $user_pass = $_POST["senha"];
    if($user_email == "" and $user_pass == ""){
        echo "Insira email e senha!";
    }
    else if ($user_email == "") {
        echo "Insira o email!";
    }
    else if($user_pass == ""){
        echo "Insira a senha!";
    }
    else{
        $mysql_qry = "select * from usuario 
                    where email like '$user_email' 
                    and senha like '$user_pass';";
        $result = mysqli_query($conn, $mysql_qry);
        if(mysqli_num_rows($result)>0){
            echo "OK";
         }
        else {
            $mysql_qry = "select * from usuario 
                    where email like '$user_email';";
            $result_email = mysqli_query($conn, $mysql_qry);
                    if(mysqli_num_rows($result_email)>0){
                        echo "Senha incorreta!";
                    }else{
                        echo"Email incorreto!";
                    }
        }
    }
    
?>