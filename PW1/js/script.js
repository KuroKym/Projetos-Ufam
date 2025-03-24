(function (){
    const botao = document.getElementById("botao");
    botao.onclick = function(){
        document.body.style.background = getRandomColor();
    };

    function getRandomColor(){
        const letras = "0123456789ABCDE";
        let color = "#";
        for (let i = 0; i < 6; i++) {
            color += letras[Math.floor(Math.random() * 16)];
        }
        return color;
    }
})();
