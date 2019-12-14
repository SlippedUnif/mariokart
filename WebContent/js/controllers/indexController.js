angular.module("mariokart").controller("indexController",
indexController);

indexController.$inject = [ '$scope', 'indexService', '$location' ];

function indexController($scope, indexService, $location) {
	
	var is = this;
	is.service = indexService;
	is.jogadores = [];
	
	is.getLogin = function() {
		is.getLogin();
	};

	is.movePage = () =>{
		$location.path('/cadastro');
	}

	is.getLogin = function() {
		var nickname = document.getElementById('inputUser').value;
		var senha = document.getElementById('inputPassword').value;
		var user = JSON.stringify({nickname,senha});
		user = JSON.parse(user);
		
		is.service.getLogin(user).then(function(data) {
			console.log("log data aqui em baixo");
			
			console.log(data.data);
			
			if(data.data.nickname != null) {
				if (data.data.nickname != "") {
					if (data.data.senha != "") {
						$location.path('/corrida');
					}else{
						alert("Insira uma senha");
					}
				}else{
					alert("Insira um Nick");
				}
			}else{
				alert("Ops! Seu nickname ou senha estão incorretos!");
			}
			
		}), () =>{

		}
	};
/*	is.curentJogador = () =>{
		is.service.get(user).success(function (data){
			is.service.curentUser(data);
		}).error(function(data, status) {
			console.log("Usuario ou senha incorretos");
		}); 
	}
*/
	
}









