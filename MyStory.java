import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {
    private String[][] colorGrid = {
        {"white", "orange", "yellow"},
        {"green", "blue", "purple"}
    };

public void print(){
clear("white");

ImageFilter ss1 = new ImageFilter("ss1.jpg");
ImageFilter ss2 = new ImageFilter("ss2.jpg");
ImageFilter ss3 = new ImageFilter("ss3.jpg");
ImageFilter ss4 = new ImageFilter("ss4.jpg");
playSound("crowd-applause-236697.wav");
 //this is my first sound used
 setTextHeight(30);
drawText("Project: Personal Narrative", 75-44, 40+120);
drawText("My Room Tour", 118-16, 75+150);
//the methods above is the starting words
pause(3.0);
//puase it
clear("white");
//clear scene
printRandomColor();
drawText("My favorite color", 100, 40+120);
drawText("             Is  ", 118-16, 75+120);

  pause(2.0);
clear("white");

    
//this is my opening scene
drawText("Here's the shelf", 100, 40+120);
drawText("above my desk", 118-16, 75+120);
drawText("->", 180, 75+150);
  pause(2.0);
//that makes the text for the second page
clear("white");//clears the screen
//now the shelf 1 image plays
 drawImage(ss1, 0, 0, 400);
 pause(2.0);
 clear("white");//clears the screen
 drawText("Here's the shelf", 100, 40+120);
 drawText(" but Pixelated!", 118-16, 75+120);
 drawText("->", 180, 75+150);
 pause(2.0);
 clear("white");//clears the screen
 //THIS NEXT METHOD APPLIES MY FIRST FILTER, THE PIXELATE FILTER
 ss1.pixelate(5);
 drawImage(ss1, 0, 0, 400);
 pause(2.0);
clear("white");//clears the screen
drawText("Here's the shelf", 100, 40+120);
drawText("with my skulls!", 118-16, 75+120);
drawText("->", 180, 75+150);
pause(2.0);
clear("white");//clears the screen
drawImage(ss2, 0, 0, 400);
pause(2.0);
clear("white");//clears the screen
    drawText("Here's the shelf", 100, 40+120);
drawText("     but Blurry!", 118-16, 75+120);
drawText("->", 180, 75+150);
    pause(2.0);
    //<video controls src="20250131-1757-35.3928559.mp4" title="Title"></video>
clear("white");//clears the screen
//THIS NEXT METHOD ADDS MOTION BLUR TO MY IMAGE
ss2.motionBlur(16, "horizontal");
drawImage(ss2, 0, 0, 400);
        pause(2.0);
clear("white");//clears the screen 
    
drawText("Here's the wall", 100, 40+120);
drawText("next to the Closet! ", 118-30, 75+120);
drawText("->", 180, 75+150);
pause(2.0);
clear("white");//clears the screen
drawImage(ss3, 0, 0, 400);
pause(2.0);
clear("white");//clears the screen
drawText("Here's the wall", 100, 40+120);
drawText("With a Threshhold! ", 118-30, 75+120);
 drawText("->", 180, 75+150);
  pause(2.0);
clear("white");//clears the screen
ss3.threshold(128);
    drawImage(ss3, 0, 0, 400);
pause(2.0);
clear("white");//clears the screen
drawText("Here's the Shelf", 100, 40+120);
drawText("   that Glows!! ", 118-30, 75+120);
drawText("->", 180, 75+150);
pause(2.0);
clear("white");//clears the screen
drawImage(ss4, 0, 0, 400);
pause(2.0);
clear("white");//clears the screen
  drawText("Here's the Shelf", 100, 40+120);
drawText("Without any Green!", 118-30, 75+120);
drawText("->", 180, 75+150);
  pause(2.0);
clear("white");//clears the screen
ss4.zeroGreen();
drawImage(ss4, 0, 0, 400);
      pause(2.0);
clear("white");//clears the screen
drawText("      Thanks!!", 118-30, 75+120);
}

  /*
  this uses a 2d array
  it is a seperate 2d array from my pictures
  it determines a "favorite color"
  my real favorite color is dark green
  my walls are green
  */
     public void printRandomColor() {
        int row = (int) (Math.random() * colorGrid.length);  // Random row index 
        int col = (int) (Math.random() * colorGrid[row].length);  // Random column index 

        //Print the color 
      
      clear("white");
      drawText(colorGrid[row][col], 177, 75+150);
    }
}

    