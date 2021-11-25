function cadastrarMaterial(){
/*	
	if(document.getElementById("inputName").value == "" || document.getElementById("inputQuant").value == ""){
		return;
	}
	
	if(document.getElementById("inputImg").value == ""){
		document.getElementById("inputImg").value = "https://gartic.com.br/imgs/mural/ma/master18_/xinforinfola.png";
	}
	*/
	
    var objeto = {
        "type" : document.getElementById("material_material").value,
        "quantity" : document.getElementById("quant_material").value
    }	


    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/materiais/novo-material", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			alert("Item cadastrado com sucesso!")
        })
        .catch(err => {
			console.log(err);
            window.alert("Deu ruim");
        });
}

function emprestimoMaterial(){
/*	
	if(document.getElementById("inputName").value == "" || document.getElementById("inputQuant").value == ""){
		return;
	}
	
	if(document.getElementById("inputImg").value == ""){
		document.getElementById("inputImg").value = "https://gartic.com.br/imgs/mural/ma/master18_/xinforinfola.png";
	}
	*/
	var select = document.getElementById('selectMaterial');
	var text = select.options[select.selectedIndex].value;
	
	var selectQuant = document.getElementById('selectMaterialQuant');
	var textQuant = selectQuant.options[selectQuant.selectedIndex].value;
	
	
    var objeto = {
        "type" : text,
		"quant": textQuant,
		"name": document.getElementById('nome_aluno').value,
		"number": document.getElementById('num_aluno').value
		
    }	

	console.log(objeto)

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/alunos/novo-aluno", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			alert("Item emprestado com sucesso!")
        })
        .catch(err => {
			console.log(err);
            window.alert("Deu ruim");
        });

}



