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
