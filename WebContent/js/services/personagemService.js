angular.module("mariokart").factory("personagemService", function ($http) {
	var baseUrl = 'http://localhost:8080/mario-kart-desafio-final/personagem';
	var _getPersonagens = function () {
		const retorno = $http.get(baseUrl);
		return retorno;
	};

	return {
		getPersonagens: _getPersonagens
	};	
});