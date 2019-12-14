var classificacao;
angular.module("mariokart").factory("corridaService", function ($http) {
	
	const _initCorrida = (a) => {
		classificacao = $http.get('http://localhost:8080/mario-kart-desafio-final/corrida/initCorrida/' + JSON.stringify(a));
        
		return classificacao;
		
	}

	const _getClassificacao = () =>{
		return classificacao;
	}
	
	return {
		initCorrida: _initCorrida,
		getClassificacao: _getClassificacao
	};	
});