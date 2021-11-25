function cadastrarUser(){
	if( document.getElementById("nome_usuario").value == "" || document.getElementById("email_usuario").value == "" || document.getElementById("senha_usuario").value == ""){
		return;
	}
	

	
    var objeto = {
        "name" : document.getElementById("nome_usuario").value,
        "email" : document.getElementById("email_usuario").value,
        "password" : document.getElementById("senha_usuario").value
    }	


    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/user/novo-user", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			//alert("Cadastrado com sucesso!")
//            window.location="listaMaterialPage";
        })
        .catch(err => {
			console.log(err);
            window.alert("Deu ruim");
        });
}

function logarUser(){
/*	
	if(document.getElementById("inputName").value == "" || document.getElementById("inputQuant").value == ""){
		return;
	}
	
	if(document.getElementById("inputImg").value == ""){
		document.getElementById("inputImg").value = "https://gartic.com.br/imgs/mural/ma/master18_/xinforinfola.png";
	}
	*/
	
    var objeto = {
        "name" : document.getElementById("loginNome_usuario").value,
        "password" : document.getElementById("loginSenha_usuario").value
    }	


    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/user/login", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			alert("Logado com sucesso!")
            window.location="listaMaterialPage";
        })
        .catch(err => {
			console.log(err);
            window.alert("Login incorreto!");
        });
}