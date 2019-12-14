angular.module("mariokart").controller("corridaController",
    corridaController);

corridaController.$inject = ['$scope', 'corridaService', 'indexService', '$location'];

function corridaController($scope, corridaService, indexService, $location) {
    var cs = this;
    var distancia = 0;
    var listaConcorrentes = [];
    var numeroVoltas;
    var listaClassificação = [];
    cs.service = indexService;
    var user = (cs.service.getCurrentUser()).$$state.value.data;


    cs.service = corridaService;

    cs.initCorrida = function () {
        cs.initCorrida();
    };

    cs.initCorrida = () => {
        if(distancia > 0){
            if (document.getElementById('numeroVoltas').value > 0) {
                numeroVoltas = document.getElementById('numeroVoltas').value;
                var corrida = new Object();
                corrida.jogadorDto = user;
                corrida.numeroVoltas = numeroVoltas;
                corrida.distancia = distancia;
    
                cs.service.initCorrida(corrida).then((data) => {
                    $location.path('/classificacao');
    
                }), () => {
                    console.log(data);
                    console.log("error");
    
    
                }
            }else{
                alert("Escolha um numero positivo de voltas");
            }
        }else{
            alert("Selecione um mapa");
        }
        



    }
    $(document).ready(function (e) {

        $("input#inputMapa.small").click(function (e) {
            distancia = $(this)[0].value;
            console.log(distancia);

        });
    });


}






