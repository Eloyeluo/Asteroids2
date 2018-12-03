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
	size(600,600);
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
		lightyear.accelerate(0.3);
	}
	if(key == 's'){ //move up
		lightyear.accelerate(-0.3);
	}
	if(key == 'g'){
		lightyear.setDirectionX(0);
		lightyear.setDirectionY(0);
		lightyear.setX((int)(Math.random()*600));
		lightyear.setY((int)(Math.random()*600));
	}
}
