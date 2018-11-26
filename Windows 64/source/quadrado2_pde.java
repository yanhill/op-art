import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class quadrado2_pde extends PApplet {

int x1 = 186;
int y1 = 186;
int x2 = 290;
int y2 = 186;
int x3 = 290;
int y3 = 290;
int x4 = 186;
int y4 = 290;
int i = 0;
int xDirecao = 1;
int yDirecao = 1;
int xDirecao2 = -1;
int yDirecao2 = 1;
int xDirecao3 = -1;
int yDirecao3 = -1;
int xDirecao4 = +1;
int yDirecao4 = -1;
int ajuste = 324;
int fill;
String[] fontList = PFont.list();
PFont arial;
PFont arial2;
String titulo = "C L I C K\nT O\nS T A R T";
/* int velocidade = 200; */


public void setup ()
{
  
  background(0, 0, 0);
  arial = loadFont("ArialMT-12.vlw");
  stroke(255);
  strokeWeight(2);
  textFont(arial);
  noLoop();
 }


public void keyPressed() {
  
   if(key == 's' || key == 'S')
    { 
    saveFrame("linhas-#####.jpg");
    println("\r\n<> FRAME SALVO <> \r\n");
    }   
  
 /*  if(key == '8'){
       velocidade += 10;
     }
     
     if(key == '2'){
       velocidade -= 10;
     }  */
}


public void quada() {
  for(int i = 0; i < 145; i += 5){
  noFill();
  stroke(255);
  quad(x1-i, y1-i, x2+i, y2-i, x3+i, y3+i, x4-i, y4+i);
  }
}


public void setas() {
  triangle(60, 70, 65, 60 , 70, 70);
  triangle(70, 70, 80, 75 , 70, 80);
  triangle(60, 70, 50, 75 , 60, 80);
  triangle(60, 80, 70, 80 , 65, 90);
  }
  

public void click() {
  
    //                  SETAS A
  if(mousePressed)
  {
    
      if(mouseX > 60 && mouseX < 70 && mouseY > 45 && mouseY < 55){
     
        if(y1 >= 186){
          y1 = y1 - 2;
      
          pushMatrix();
          fill(255);
          translate(0,-15);
          triangle(60, 70, 65, 60 , 70, 70);
          noFill();
          popMatrix();
         }
      }
    
    if(mouseX < 80 && mouseX > 70 && mouseY > 55 && mouseY < 65){
     
      if(x1 <= 430){
      
        x1 = x1 + 2;
        
          pushMatrix();
          fill(255);
          translate(1,-15);
          triangle(70, 70, 80, 75 , 70, 80);
          noFill();
          popMatrix();
      }
    }
    if(mouseX < 70 && mouseX > 60 && mouseY > 65 && mouseY < 75){
      if(y1 <= 430){
      y1 = y1 + 2;
          pushMatrix();
          fill(255);
          translate(1,-15);
          triangle(60, 80, 70, 80 , 65, 90);
          noFill();
          popMatrix();    
    
  }
    }
    if(mouseX > 50 && mouseX < 60 && mouseY > 55 && mouseY < 65){
      if(x1 >= 186){
      x1 = x1 - 2;
      }
          pushMatrix();
          fill(255);
          translate(1,-15);
          triangle(60, 70, 50, 75 , 60, 80);
          noFill();
          popMatrix();  
      }
    }
    
    //                  SETAS D
   if(mousePressed){ 
    if(mouseX > 60 && mouseX < 70 && mouseY > height-65 && mouseY < height-55){
      if(y4 >= 46) {
      y4 = y4 - 2;
          pushMatrix();
          fill(255);
          translate(0,height-125);
          triangle(60, 70, 65, 60 , 70, 70);
          noFill();
          popMatrix();
      }
    }
    if(mouseX < 80 && mouseX > 70 && mouseY > height-55 && mouseY < height-45){
      if(x4 <= 430){
      x4 = x4 + 2;
          pushMatrix();
          fill(255);
          translate(1,height-125);
          triangle(70, 70, 80, 75 , 70, 80);
          noFill();
          popMatrix();
      }

    }
    if(mouseX < 70 && mouseX > 60 && mouseY > height-45 && mouseY < height-35){
      if(y4 <= 290) {
      y4 = y4 + 2;
          pushMatrix();
          fill(255);
          translate(1,height-125);
          triangle(60, 80, 70, 80 , 65, 90);
          noFill();
          popMatrix();  
      }
    }
    if(mouseX >= 50 && mouseX < 60 && mouseY > height-55 && mouseY < height-45){
      if(x4 >= 186){
      x4 = x4 - 2;
          pushMatrix();
          fill(255);
          translate(1,height-125);
          triangle(60, 70, 50, 75 , 60, 80);
          noFill();
          popMatrix();  
      }
    }
   }
    
    //                  SETAS C
    if(mousePressed){
    if(mouseX < width-70 && mouseX > width -80 && mouseY > height-65 && mouseY < height-55){
      if(y3 >= 46){
      y3 = y3 - 2;
          pushMatrix();
          fill(255);
          translate(width-140,height-125);
          triangle(60, 70, 65, 60 , 70, 70);
          noFill();
          popMatrix();  
      }
    }
    if(mouseX < width - 60 && mouseX > width-70 && mouseY > height-55 && mouseY < height-45){
      if(x3 <= 290){
      x3 = x3 + 2;
          pushMatrix();
          fill(255);
          translate(width-140,height-125);
          triangle(70, 70, 80, 75 , 70, 80);
          noFill();
          popMatrix();
      }
    }
    if(mouseX < width-70 && mouseX > width-80 && mouseY > height-45 && mouseY < height-35){
      if(y3 <= height-310){
      y3 = y3 + 2;
          pushMatrix();
          fill(255);
          translate(width-140,height-125);
          triangle(60, 80, 70, 80 , 65, 90);
          noFill();
          popMatrix(); 
      }
    }
    if(mouseX < width-80 && mouseX > width-90 && mouseY > height-55 && mouseY < height-45){
      if(x3 >= 46){
      x3 = x3 - 2;
          pushMatrix();
          fill(255);
          translate(width-140,height-125);
          triangle(60, 70, 50, 75 , 60, 80);
          noFill();
          popMatrix(); 
      }
    }
    }
    
    //                  SETAS B
    if(mousePressed){
    if(mouseX < width-70 && mouseX > width-80 && mouseY > 45 && mouseY < 55){
       if (y2 >= 186) {
       y2 = y2 - 2;
       
          pushMatrix();
          fill(255);
          translate(width-140,-15);
          triangle(60, 70, 65, 60 , 70, 70);
          noFill();
          popMatrix(); 
          
      }
    }
    if(mouseX < width-60 && mouseX > width-70 && mouseY > 55 && mouseY < 65){
      if (x2 <= 290){
      x2 = x2 + 2;
      
          pushMatrix();
          fill(255);
          translate(width-140,-15);
          triangle(70, 70, 80, 75 , 70, 80);
          noFill();
          popMatrix();
     }
    }
    if(mouseX < width-70 && mouseX > width-80 && mouseY > 65 && mouseY < 75){
      if(y2 <= 430) {
      y2 = y2 + 2;
      
          pushMatrix();
          fill(255);
          translate(width-140,-15);
          triangle(60, 80, 70, 80 , 65, 90);
          noFill();
          popMatrix(); 
      }
    }
    if(mouseX < width-80 && mouseX > width-90 && mouseY > 55 && mouseY < 65){
      if(x2 >= 46) {
      x2 = x2 - 2;
      
          pushMatrix();
          fill(255);
          translate(width-140,-15);
          triangle(60, 70, 50, 75 , 60, 80);
          noFill();
          popMatrix();       
      }
      }
    }
 }

public void mouseClicked()
{
      loop();
    titulo = "";
}
  

 
public void draw() 
{
    strokeWeight(1);
    background(0);
    
click();
    
                   
  
  pushMatrix();
  arial2= loadFont("Arial-BoldMT-17.vlw");
  textAlign(CENTER);
  textFont(arial2);
  text(titulo, width/2-2, height/2-12);
  textFont(arial);
  popMatrix();
  
   String texto1 =  "(" + Integer.toString(x1+60) + ", " +Integer.toString(y1+60) + ") \n A" ;
   String texto2 =  "("+ Integer.toString(x2+60)+", " +Integer.toString(y2+60) + ")\n B  " ;
   String texto3 =  " C  \n(" + Integer.toString(x3+60) + ", " +Integer.toString(y3+60) + ")" ;
   String texto4 =  " D \n(" + Integer.toString(x4+60) + ", " +Integer.toString(y4+60) + ")" ;
   
   pushMatrix();
   textAlign(LEFT);
   text(texto1, 20, 30);
   textAlign(RIGHT);
   text(texto2, width-20, 30);
   text(texto3, width-20, height-30);
   textAlign(LEFT);
   text(texto4, 20, height-30); 
   popMatrix();
   
   pushMatrix();
   translate(0,-15);
   setas();
   popMatrix();
  
   pushMatrix();
   translate(width-140,-15);
   setas();
   popMatrix();
   
   pushMatrix();
   translate(width-140,height-125);
   setas();
   popMatrix();
   
   pushMatrix();
   translate(0,height-125);
   setas();
   popMatrix();
   
 
 for( i = 0; i < 1 ; x1 = x1 + xDirecao, y1 = y1 + yDirecao, x2 = x2 + xDirecao2, y2 = y2 + yDirecao2, x3 = x3 + xDirecao3, y3 = y3 + yDirecao3, x4 = x4 + xDirecao4, y4 = y4 + yDirecao4, i+=2)
 { 
   pushMatrix();
   translate(width / 10 , height / 10 );
   quada();
   popMatrix();
 
   if(key == 'b' || key == 'B')
   {
     break;
     
   }

 }
                          // DIRE\u00c7\u00c3O X1
   if(x1 > 430){
   xDirecao = -1;
 }
   if(y1 > 430){
   yDirecao = -1;
 }
 if(x1 < 186)
 {
   xDirecao = +1;
 }
  if(y1 < 186){
   yDirecao = +1;
 }
                          // DIRE\u00c7\u00c3O X2                      
  if(x2 < 46)
 {
   xDirecao2 = +1;
 }
  if(y2 > 430)
 {
   yDirecao2 = -1;
 }
  if(y2 < 186)
 {
   yDirecao2 = +1;
 }
  if(x2 > 290)
 {
   xDirecao2 = -1;
 }
                         // DIRE\u00c7\u00c3O X3                       
   if(x3 > 290 || y3 > 290)
 {
   xDirecao3 = -1;
   yDirecao3 = -1;
 }
  if(x3 < 46 || y3 < 46)
 {
   xDirecao3 = +1;
   yDirecao3 = +1;
 }
                         // DIRE\u00c7\u00c3O X4
 if(x4 < 186)
 {
   xDirecao4 = +1;
 }
  if(y4 > 290)
 {
   yDirecao4 = -1;
 }
  if(y4 < 46)
 {
   yDirecao4 = +1;
 }
  if(x4 > 430)
 {
   xDirecao4 = -1;
 }

}
  public void settings() {  size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "quadrado2_pde" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
