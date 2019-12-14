var user;
angular.module("mariokart").factory("indexService", function ($http) {
	
	var _getJogadores = function () {
		return 'http://localhost:8080/mario-kart-desafio-final/jogadores';
	}
	
	const _getLogin = (a) => {
		user = $http.get('http://localhost:8080/mario-kart-desafio-final/jogadores/getLogin/' + JSON.stringify(a));

		return user;
		
	}
	
	const _getCurrentUser = () =>{
		return user;
	}
	
	return {
		getLogin: _getLogin,
		getJogadores: _getJogadores,
		getCurrentUser: _getCurrentUser
	};	
});