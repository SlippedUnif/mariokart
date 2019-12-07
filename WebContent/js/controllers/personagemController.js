angular.module("mariokart").controller("PersonagemController",
		PersonagemController);

PersonagemController.$inject = [ '$scope', 'PersonagemService' ];

function PersonagemController($scope, PersonagemService) {
	var vm = this;
	vm.service = PersonagemService;
	vm.personagens = [];

	vm.init = function() {
		vm.carregarPersonagens();
	};

	vm.carregarPersonagens = function() {
		vm.service.getPersonagens().success(function(data) {
			vm.personagens = data;
		}).error(function(data, status) {
			vm.message = "Aconteceu um problema: " + data;
		});
	};
}