angular.module("mariokart").factory("PersonagemService", function ($http) {
	var baseUrl = 'http://localhost:8080/mario-kart-desafio-final/personagem';
	var _getPersonagens = function () {
		return $http.get(baseUrl);
	};

	return {
		getPersonagens: _getPersonagens
	};	
});