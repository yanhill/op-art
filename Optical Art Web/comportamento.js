	var canvas = document.getElementById("mycanvas");
	var ctx = canvas.getContext("2d");
	
	var velocidade = 24;
	
	var teclas = {};

    var movX = [0,0,0,0];
    var movY = [0,0,0,0];

    var theta = [Math.PI + (Math.PI/4),
                 Math.PI + Math.PI - (Math.PI/4),
                 Math.PI/4,
                 Math.PI - (Math.PI/4)];

	var raio = [156 , 156, 156 , 156];

    var angX = [4];
	            
	var angY = [4];  

	var bt =   [[45, 55],   // BOTAO LEFT
	            [60, 40],   // BOTAO UP
	            [60, 70],   // BOTAO DOWN
	            [75, 55]];   // BOTAO RIGHT
	            
    var TRI = ["◁","△","▽","▷",];

    var alt = [-1,-1,-1,-1];
var r = [4];

	var LARGURA = canvas.width;
	var ALTURA = canvas.height;

var eas = [156,156,156,156];
var dx = [4];

	var estadoAtual,
	estados = {
	    jogar: 0,
	    jogando: 1 
	};
    


    var vertice;

	click = "C L I C K", to = "T O", play = "P L A Y", espaco = 7, esp = "1";
	
	estadoAtual = estados.jogar;

	document.addEventListener("keydown", function(e) {
		teclas[e.keyCode] = true;
		//alert(e.keyCode);
	});

	document.addEventListener("keyup", function(e) {
		delete teclas[e.keyCode];
	});
 
canvas.onclick = function (evt){
            
    var dist = 10;
    
 	var rectNav = canvas.getBoundingClientRect();
    var pos = {
        x: evt.clientX - rectNav.left,
        y: evt.clientY - rectNav.top
     };
     
     estadoAtual = estados.jogando;
    
    for(var count = 0, x = 0, y = -10 ; count < angX.length ; count++, x += 465){
        
        if(x > 465 && y < 500){
            x = 465;
            y += 500;
        }
        
        if( y > 500){
            y = 490;
            x = 0;
        }
        
        if(pos.x > bt[0][0] + x &&
           pos.x < (bt[0][0] + dist) + x &&
           pos.y > bt[0][1] + y &&
           pos.y < (bt[0][1] + dist) + y){
            
            movX[count] -= 5;
            
            ctx.font = "20px Helvetica";
            ctx.fillText("◄", bt[0][0] + x -3 , bt[0][1] + y + 11);
        }
        
        if(pos.x > bt[1][0] + x &&
           pos.x < (bt[1][0] + dist) + x &&
           pos.y > bt[1][1] + y &&
           pos.y < (bt[1][1] + dist) + y){
            
            movY[count] -= 5;
            
            ctx.font = "20px Helvetica";
            ctx.fillText("▲", bt[1][0] + x  -3, bt[1][1] + y + 10);
        }
        
        if(pos.x > bt[2][0] + x &&
           pos.x < (bt[2][0] + dist) + x &&
           pos.y > bt[2][1] + y &&
           pos.y < (bt[2][1] + dist) + y){
          
            movY[count] += 5;
            
            ctx.font = "20px Helvetica";
            ctx.fillText("▼", bt[2][0] + x -3, bt[2][1] + y +11);
        }
        
        if(pos.x > bt[3][0] + x &&
           pos.x < (bt[3][0] + dist) + x &&
           pos.y > bt[3][1] + y &&
           pos.y < (bt[3][1] + dist) + y){
            
            movX[count] += 5;
            
            ctx.font = "20px Helvetica";
            ctx.fillText("►", bt[2][0] + x + 12, bt[2][1] + y -4);
        }
    }
    
  /*  if(pos.x > 0 &&
        pos.x < 400 &&
        pos.y > 0 &&
        pos.y < 60){
        
            vertice = 0;
        }    
    if(pos.x > LARGURA - 50 &&
        pos.x < LARGURA &&
        pos.y > 0 &&
        pos.y < 50){
        
            vertice = 1;
        }   
    if(pos.x > LARGURA - 50 &&
        pos.x < LARGURA &&
        pos.y > ALTURA - 50 &&
        pos.y < ALTURA){
        
            vertice = 2;
        }
    if(pos.x > 0 &&
        pos.x < 80 &&
        pos.y > ALTURA - 60 &&
        pos.y < ALTURA){
        
            vertice = 3;
        } */

}

function boardControl(){
        for(var count = 0 ; count < movX.length ; count++){
        if(vertice == count){
            if(38 in teclas || 87 in teclas){
                movY[count] -= 2;
            }
    
            if(40 in teclas || 83 in teclas){
                movY[count] += 2;
            }
    
            if(37 in teclas || 65 in teclas){
                movX[count] -= 2;
            }
    
            if(39 in teclas || 68 in teclas){
                movX[count] += 2;
            }
        }
    }    
}

function moveQuad(){
    angX = [eas[0] * Math.cos(theta[0]) + movX[0],
            eas[1] * Math.cos(theta[1]) + movX[1],
            eas[2] * Math.cos(theta[2]) + movX[2],
            eas[3] * Math.cos(theta[3]) + movX[3]];
	            
    angY = [eas[0] * Math.sin(theta[0]) + movY[0],
            eas[1] * Math.sin(theta[1]) + movY[1],
            eas[2] * Math.sin(theta[2]) + movY[2],
            eas[3] * Math.sin(theta[3]) + movY[3]];  
};

function drawQuad(){ 
    
    boardControl();
    moveQuad();
    
    for(var i = 0, o = 0; i < 60; i += espaco){     
        
        ctx.strokeStyle="white";
        ctx.lineWidth = 2;
        ctx.translate(300, 300);
        
        ctx.beginPath();
        ctx.lineTo(angX[0] + i , angY[0] + i );
        ctx.lineTo(angX[1] - i , angY[1] + i );
        ctx.lineTo(angX[2] - i , angY[2] - i );
        ctx.lineTo(angX[3] + i , angY[3] - i );
        ctx.lineTo(angX[0] + i , angY[0] + i );
        ctx.stroke();
        
        ctx.beginPath();
        ctx.lineTo(angX[0] - i , angY[0] - i );
        ctx.lineTo(angX[1] + i , angY[1] - i );
        ctx.lineTo(angX[2] + i , angY[2] + i );
        ctx.lineTo(angX[3] - i , angY[3] + i );
        ctx.lineTo(angX[0] - i , angY[0] - i );
        ctx.stroke();
        ctx.setTransform(1, 0, 0, 1, 0, 0); 
    }
}

function espacamento() {
 /*if(96 in teclas || 58 in teclas){
			espaco = 3;
			esp = "0";
		} */
		if(97 in teclas || 49 in teclas){
			espaco = 5;
			esp = "1";
		}

		if(98 in teclas || 50 in teclas){
			espaco = 9;
			esp = "2";
		}
		
		if(99 in teclas || 51 in teclas){
			espaco = 15;
			esp = "3";
		}
		if(100 in teclas || 52 in teclas){
			espaco = 50;
			esp = "4";
		}

	};
       
function botoes(){
    
    var LETRA = ["A","B","C","D"];
    
    var textxy = ["(" + parseInt(angX[0]) + ", " + parseInt(angY[0]) + ")",
                  "(" + parseInt(angX[1]) + ", " + parseInt(angY[1]) + ")",
                  "(" + parseInt(angX[2]) + ", " + parseInt(angY[2]) + ")",
                  "(" + parseInt(angX[3]) + ", " + parseInt(angY[3]) + ")"]; 
    
   /*  var textxy = ["(" + raio[0]+ ")",
                  "(" + raio[1] +  ")",
                  "(" + raio[2] + ")",
                  "(" + raio[3] + ")"];     */
    
    ctx.fillStyle="white";
    
    for(var x = 5, y = 0, l = 0 ; l < LETRA.length ; l++ , x += 542){ //           (X , Y)
        if(x > 547 && y < 581){
            x = 550;
            y += 580;
        }
        if( y > 581){
            x = 5;
            y = 580;
        }
        
        if(vertice != l){
        ctx.font = "10px Helvetica";
        ctx.fillText(textxy[l], x , 13 + y);
        }
        
        if(vertice == l){
        ctx.font = "10px Helvetica";
        ctx.fillText(textxy[l], 5 + x, 18 + y);
            
        ctx.beginPath();
        ctx.lineWidth = 2;
    
    ctx.stroke(); 
        }
    }
    
    
    for(var x = 5, y = 0, l = 0 ; l < LETRA.length ; l++ , x += 565){ //          A B C D
        if(x > 570 && y < 546){
            x = 570;
            y += 545;
        }
        if( y > 546){
            x = 5;
            y = 545;
        }
        
        if(vertice != l){
            ctx.font = "17px Helvetica";
            ctx.fillText(LETRA[l], 3 + x, 38 + y);
        }
        if(vertice == l){
        //ctx.fillStyle="#050505";
        //ctx.fillRect(-3 + x , 2 + y , 80 , 60);
            
            ctx.beginPath();
            ctx.strokeStyle="#555";
            ctx.rect(-3 + x , 2 + y,80 , 60); 
            ctx.stroke();
        
            ctx.font = "17px Helvetica";
            ctx.fillStyle="#fff";
            ctx.fillText(LETRA[l], 8 + x, 43 + y); 
            
            ctx.beginPath();
            ctx.strokeStyle="#555";
            ctx.rect(-3 + x , 2 + y,80 , 60); 
            ctx.stroke();
        }
    }
    
    for(var x = 0, y = 0, l = 0 ; l < LETRA.length ; l++ , x += 465){ //            SETAS
        if(x > 465){
            x = 0;
            y = 500;
        }

        ctx.fillText(TRI[0], bt[0][0] + x , bt[0][1] + y );
        ctx.fillText(TRI[1], bt[1][0] + x  , bt[1][1] + y);
        ctx.fillText(TRI[2], bt[2][0] + x , bt[2][1] + y );
        ctx.fillText(TRI[3], bt[3][0] + x , bt[3][1] + y );
    } 
}

function atualiza(){
    var easing = 0.02;
    
    r[0] = Math.sqrt((angX[0] * angX[0]) + (angY[0] * angY[0]));
    r[1] = Math.sqrt((angX[1] * angX[1]) + (angY[1] * angY[1]));
    r[2] = Math.sqrt((angX[2] * angX[2]) + (angY[2] * angY[2]));
    r[3] = Math.sqrt((angX[3] * angX[3]) + (angY[3] * angY[3]));
    
    drawQuad(); 
    
    for(var  count = 0 ; count < r.length ; count++){
    raio[count] = raio[count] + alt[count];
    
    dx[count] = raio[count] - eas[count]; 
    eas[count] += dx[count] * easing;     
      
    if(raio[count] > 150){
        alt[count] = -1;
    }

    if(raio[count] < -150){       
        alt[count] = +1;  
    }}
    
}

function desenha(){

	ctx.clearRect(0,0,canvas.width,canvas.height);
	
	espacamento();
    botoes()

	if(estadoAtual == estados.jogar){
        
	    drawQuad();
	    ctx.font = "20px Helvetica";
	    ctx.lineWidth = 1;
	    ctx.fillText(click, canvas.width/2 - 41, canvas.width/2 -18);	    
	    ctx.fillText(to, canvas.width/2 - 15, canvas.width/2 + 8);   
	    ctx.fillText(play, canvas.width/2 - 32, canvas.width/2 + 33);
	}
	
	if(estadoAtual == estados.jogando){
	    click = "";
	    to = "";
	    play = "";
	    atualiza();
	}
}
setInterval(desenha, velocidade);