angular.module("mariokart").controller("classificacaoController",
classificacaoController);

classificacaoController.$inject = ['$scope', 'corridaService', '$location', 'indexService'];

function classificacaoController($scope, corridaService, $location, indexService) {
    
    var cc = this;

    cc.service = indexService;
    var user = (cc.service.getCurrentUser()).$$state.value.data;


    cc.service = corridaService;
    var classificados = (cc.service.getClassificacao()).$$state.value.data.classificacao;
    
    cc.init = function () {
        
        cc.init();
    };

    cc.novaCorrida = () =>{
        $location.path('/corrida');
    }
    cc.sair = () =>{
        $location.path('/');
    }

    cc.init =  () => {
        
        
        var contador = 1;

        classificados.forEach(concorrente => {            
            
            console.log(contador + "° lugar =" + concorrente.nickname + "tempo =" + concorrente.notaCorrida);
            if (contador == 1 && user.idPersonagem == concorrente.personagemdto.id) {
                document.getElementById("VD").innerText = "!!!!!1° LUGAR, VOCE GANHOU!!!!!  TEMPO =" + concorrente.notaCorrida + "mim";
            }if (contador == 2 && user.idPersonagem == concorrente.personagemdto.id) {
                document.getElementById("VD").innerText = "Voce perdeu, colocação = " + contador + "° Lugar TEMPO =" + concorrente.notaCorrida + "mim";
            }if (contador == 3 && user.idPersonagem == concorrente.personagemdto.id) {
                document.getElementById("VD").innerText = "Voce perdeu, colocação = " +  contador + "° Lugar TEMPO =" + concorrente.notaCorrida + "mim";
            }if (contador == 4 && user.idPersonagem == concorrente.personagemdto.id) {
                document.getElementById("VD").innerText = "Voce perdeu, colocação = " + contador + "° Lugar TEMPO =" + concorrente.notaCorrida + "mim";
            }if (contador == 5 && user.idPersonagem == concorrente.personagemdto.id) {
                document.getElementById("VD").innerText = "Voce perdeu, colocação = " + contador + "° Lugar TEMPO =" + concorrente.notaCorrida + "mim";
            }if (contador == 6 && user.idPersonagem == concorrente.personagemdto.id) {
                document.getElementById("VD").innerText = "Voce perdeu, colocação = " + contador + "° Lugar TEMPO =" + concorrente.notaCorrida + "mim";
            }if(contador == 7 && user.idPersonagem == concorrente.personagemdto.id){
                document.getElementById("VD").innerText = "Voce perdeu, colocação = " + contador + "° Lugar TEMPO =" + concorrente.notaCorrida + "mim";
            }
            
            document.getElementById(contador.toString()).src = "./pictures/"+concorrente.personagemdto.id.toString()+".png";
            
            contador++;
        });
    };
}






