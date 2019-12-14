angular.module("mariokart").controller("cadastroController",
    cadastroController);

cadastroController.$inject = ['$scope', 'cadastroService', '$location'];

function cadastroController($scope, cadastroService, $location) {



    var id;
    var cs = this;
    cs.service = cadastroService;
    cs.jogadores = [];

    cs.jogadorPost = function () {
        cs.jogadorPost();
    };
    cs.sair = () =>{
        $location.path('/');
    };
    cs.jogadorPost = function () {
        var nickname = document.getElementById('inputUser').value;
        var senha = document.getElementById('inputPassword').value;
        var idPersonagem = id;
        var user = JSON.stringify({ nickname, senha, idPersonagem });
        user = JSON.parse(user);
        console.log(user);

        cs.service.post(user).then(function (data) {
            if (data.data.localeCompare("Nick invalidante")) {
                alert(data.data);
            } if (data.data.localeCompare("Usuario ja existente") == 0) {
                alert(data.data);
            } if (data.data.localeCompare("Senha invalida") == 0) {
                alert(data.data);
            } if (data.data.localeCompare("escolha um personagem!") == 0) {
                alert(data.data);
            } if (data.data.localeCompare("cadastrado com sucesso!") == 0) {
                alert(data.data);
                $location.path('/');


            }
        });
    };
    $(document).ready(function (e) {

        $("input#inputIdPersonagem.small").click(function (e) {
            id = $(this).val();
            console.log($(this)[0].value);

        });
    });



}









