<?php
    require "conn.php";
    $nome = $_POST["nome"];
    $email = $_POST["email"];
    $senha = $_POST["senha"];
    $senha_lenght = strlen($senha);
    if ($nome == "" || $email == "" || $senha == ""){
        echo "Todos campos devem ser preenchidos!";        
    }
    else if(strstr($email, '@')){
        $mysql_qry = "select * from usuario 
                    where email like '$email';";
        $result = mysqli_query($conn, $mysql_qry);
        if(mysqli_num_rows($result)>0){
            echo "Email já cadastrado!";
         }
         else if($senha_lenght < 8){
                  echo "A senha deve conter no minimo 8 caracteres";  
               }
               else{
                    $mysql_qry = "insert into usuario (nome, email, senha) 
                    values('$nome', '$email', '$senha')";
   
                    if($conn->query($mysql_qry) === TRUE){
                        echo "Registro feito com sucesso!";
                    }
                    else {
                        echo "Error: ". $mysql_qry . "<br>" . $conn->error;
                    }
                    $conn->close(); 
                }  
            }
    else{
        echo "Email inválido!";
        }
?>