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
