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
