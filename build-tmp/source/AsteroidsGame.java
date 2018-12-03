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

public class AsteroidsGame extends PApplet {

Spaceship lightyear = new Spaceship();
Star stars[] = new Star[100];
Asteroid enemies[] = new Asteroid[30];
public void setup() 
{
	for(int i = 0 ; i < stars.length ; i++){
		stars[i] = new Star();
	}
	for(int i = 0 ; i < enemies.length ; i++){
		enemies[i] = new Asteroid();
	}
	
	lightyear.setDirectionX(0);
	lightyear.setDirectionY(0);
	for(int i = 0 ; i < enemies.length ; i++){
		enemies[i].accelerate(enemies[i].getMovement());
	}
}
public void draw() 
{
	background(0);
	for(int i = 0 ; i < stars.length ; i++){
		stars[i].show();
	}
	for(int i = 0 ; i < enemies.length ; i++){
		enemies[i].show();
		enemies[i].move();
	}
    lightyear.show();
    lightyear.move();
}
public void keyPressed(){
	if(key == 'd'){ //turn right
		lightyear.turn(20);
	}
	if(key == 'a'){ //turn left
		lightyear.leftTurn(20);
	}
	if(key == 'w'){ //move up
		lightyear.accelerate(0.3f);
	}
	if(key == 's'){ //move up
		lightyear.accelerate(-0.3f);
	}
	if(key == 'g'){
		lightyear.setDirectionX(0);
		lightyear.setDirectionY(0);
		lightyear.setX((int)(Math.random()*600));
		lightyear.setY((int)(Math.random()*600));
	}
}
public class Asteroid extends Floater{
	private int myRotation;
	private int myMovement;
	public Asteroid(){
		myColor = 50; //mandatory constructor
		corners = 19;
		xCorners = new int[corners];
		yCorners = new int[corners];
		xCorners[0] = -13;//1
		yCorners[0] = 0;
		xCorners[1] = -10;//2
		yCorners[1] = 2;
		xCorners[2] = -7;//3
		yCorners[2] = 6;
		xCorners[3] = -6;//4
		yCorners[3] = 5;
		xCorners[4] = -3;//5
		yCorners[4] = 4;
		xCorners[5] = -1;//6
		yCorners[5] = 5;
		xCorners[6] = 0;//7
		yCorners[6] = 5;
		xCorners[7] = 2;//8
		yCorners[7] = 3;
		xCorners[8] = 3;//9
		yCorners[8] = 1;
		xCorners[9] = 2;//10
		yCorners[9] = -1;
		xCorners[10] = 2;//11
		yCorners[10] = -3;
		xCorners[11] = 4;//12
		yCorners[11] = 6;
		xCorners[12] = 4;//13
		yCorners[12] = 9;
		xCorners[13] = 2;//14
		yCorners[13] = 10;
		xCorners[14] = 0;//15
		yCorners[14] = 9;
		xCorners[15] = -2;//16
		yCorners[15] = -7;
		xCorners[16] = -5;//17
		yCorners[16] = -6;
		xCorners[17] = -8;//18
		yCorners[17] = -7;
		xCorners[18] = -13;//19
		yCorners[18] = -5;
		myCenterX = (int)(Math.random()*800);
		myCenterY = (int)(Math.random()*600);
		myRotation = (int)(Math.random()*2) - 1;
		myMovement = (int)(Math.random()*2) - 1;
	}
  public void move(){
  	super.move();
  	if(myRotation == 1){
  		turn(1);
  	}
  	else{
  		turn(-1);
  	}
  }
  public void setX(int x){ myCenterX = (double)x;}
  public int getX(){return (int)myCenterX;}   
  public void setY(int y){myCenterY = (double)y;}   
  public int getY(){return (int)myCenterY;}   
  public void setDirectionX(double x){myDirectionX = x;}   
  public double getDirectionX(){return myDirectionX;}   
  public void setDirectionY(double y){myDirectionY = y;}   
  public double getDirectionY(){return myDirectionY;}   
  public void setPointDirection(int degrees){myPointDirection = degrees;}   
  public double getPointDirection(){return myPointDirection;} 
  public int getRotation(){return myRotation;}
  public int getMovement(){return myMovement;}
}
abstract class Floater //Do NOT modify the Floater class! Make changes in the Spaceship class 
{   
  protected int corners;  //the number of corners, a triangular floater has 3   
  protected int[] xCorners;   
  protected int[] yCorners;   
  protected int myColor;   
  protected double myCenterX, myCenterY; //holds center coordinates   
  protected double myDirectionX, myDirectionY; //holds x and y coordinates of the vector for direction of travel   
  protected double myPointDirection; //holds current direction the ship is pointing in degrees    
  abstract public void setX(int x);  
  abstract public int getX();   
  abstract public void setY(int y);   
  abstract public int getY();   
  abstract public void setDirectionX(double x);   
  abstract public double getDirectionX();   
  abstract public void setDirectionY(double y);   
  abstract public double getDirectionY();   
  abstract public void setPointDirection(int degrees);   
  abstract public double getPointDirection(); 

  //Accelerates the floater in the direction it is pointing (myPointDirection)   
  public void accelerate (double dAmount)   
  {          
    //convert the current direction the floater is pointing to radians    
    double dRadians =myPointDirection*(Math.PI/180);     
    //change coordinates of direction of travel    
    myDirectionX += ((dAmount) * Math.cos(dRadians));    
    myDirectionY += ((dAmount) * Math.sin(dRadians));       
  }   
  public void turn (int nDegreesOfRotation)   
  {     
    //rotates the floater by a given number of degrees    
    myPointDirection+=nDegreesOfRotation;   
  }   
  public void move ()   //move the floater in the current direction of travel
  {      
    //change the x and y coordinates by myDirectionX and myDirectionY       
    myCenterX += myDirectionX;    
    myCenterY += myDirectionY;     

    //wrap around screen    
    if(myCenterX >width)
    {     
      myCenterX = 0;    
    }    
    else if (myCenterX<0)
    {     
      myCenterX = width;    
    }    
    if(myCenterY >height)
    {    
      myCenterY = 0;    
    } 
    
    else if (myCenterY < 0)
    {     
      myCenterY = height;    
    }   
  }   
  public void show ()  //Draws the floater at the current position  
  {             
    fill(myColor);   
    stroke(myColor);    
    
    //translate the (x,y) center of the ship to the correct position
    translate((float)myCenterX, (float)myCenterY);

    //convert degrees to radians for rotate()     
    float dRadians = (float)(myPointDirection*(Math.PI/180));
    
    //rotate so that the polygon will be drawn in the correct direction
    rotate(dRadians);
    
    //draw the polygon
    beginShape();
    for (int nI = 0; nI < corners; nI++)
    {
      vertex(xCorners[nI], yCorners[nI]);
    }
    endShape(CLOSE);

    //"unrotate" and "untranslate" in reverse order
    rotate(-1*dRadians);
    translate(-1*(float)myCenterX, -1*(float)myCenterY);
  }   
} 
class Spaceship extends Floater  
{   
	public Spaceship(){
		myColor = 200; //mandatory constructor
		corners = 12;
		xCorners = new int[corners];
		yCorners = new int[corners];
		yCorners[0] = -10;
		xCorners[0] = -10;
		yCorners[1] = 0;
		xCorners[1] = -4;
		yCorners[2] = 10;
		xCorners[2] = -10;
		yCorners[3] = 8;
		xCorners[3] = -2;
		yCorners[4] = 4;
		xCorners[4] = 4;
		yCorners[5] = 6;
		xCorners[5] = 11;
		yCorners[6] = 0;
		xCorners[6] = 7;
		yCorners[7] = -6;
		xCorners[7] = 11;
		yCorners[8] = -4;
		xCorners[8] = 4;
		yCorners[9] = -8;
		xCorners[9] = -2;
		yCorners[10] = -10;
		xCorners[10] = -10;
		myCenterX = 400;
		myCenterY = 300;
	}
	public void setX(int x){
		myCenterX = (double)x;
	}  
   public int getX(){
   	return (int)myCenterX;
   }   
   public void setY(int y){
   	myCenterY = (double)y;
   }   
   public int getY(){
   	return (int)myCenterY;
   }   
   public void setDirectionX(double x){
   	myDirectionX = x;
   }   
   public double getDirectionX(){
   	return myDirectionX;
   }   
   public void setDirectionY(double y){
   	myDirectionY = y;
   }   
   public double getDirectionY(){
   	return myDirectionY;
   }   
   public void setPointDirection(int degrees){
   	myPointDirection = degrees;
   }   
   public double getPointDirection(){
   	return myPointDirection;
   } 
   public void leftTurn (int nDegreesOfRotation)   
  {     
    //rotates the floater by a given number of degrees    
    myPointDirection -=nDegreesOfRotation;   
  }   
}
class Star //note that this class does NOT extend Floater
{
  protected double myCenterX, myCenterY;    
  protected int myColorRed;
  protected int myColorGreen;
  protected int myColorBlue;
  public Star(){
  	myCenterX = Math.random()*800;
  	myCenterY = Math.random()*600;
  	myColorRed = (int)(Math.random()*200);
  	myColorGreen = (int)(Math.random()*200);
  	myColorBlue = (int)(Math.random()*200);
  }
  public void show(){
  	color(myColorRed, myColorGreen, myColorBlue);
  	ellipse((float)myCenterX, (float)myCenterY, 1 , 1);
  }
  
}
  public void settings() { 	size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AsteroidsGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
