angular.module('mariokart', ['ngRoute']);

angular.module('mariokart').config(Config);

Config.$inject = ['$routeProvider']

function Config($routeProvider) {
    $routeProvider
        .when("/cadastro", {
            templateUrl: "./html/cadastro.html"
        }).when("/corrida", {
            templateUrl: "./html/corrida.html"
        }).when("/" , {
            templateUrl: "./html/login.html"
        }).when("/classificacao", {
            templateUrl: "./html/classificacao.html"
        }).otherwise({
            templateUrl: "./html/login.html"
        });
}