angular.module("mariokart").factory("cadastroService", function ($http) {
	
	const _post = (a) => {
		
		return $http.post('http://localhost:8080/mario-kart-desafio-final/jogadores/' + JSON.stringify(a));
		
	}
	
	return {
		post: _post
	};	
});