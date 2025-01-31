import org.code.media.Pixel;
import org.code.media.Color;  // Make sure to import the Color class
public class ImageFilter extends ImagePlus {

  
  
  public ImageFilter(String filename) {
        super(filename);
}

//here is my first filter, and the goal of it is to make the image pixelated
 public void pixelate(int gridSize) {
    int numRows = getHeight();  
    int numCols = getWidth();   //THESE 2 METHODS GIVE YOU THE WIDTH AND HEIGHT 
    
//GO THROUGH IT BASED ON THE PARAMATER SIZE 
    
    for (int rowStart = 0; rowStart < numRows; rowStart += gridSize) {
        for (int colStart = 0; colStart < numCols; colStart += gridSize) {
            // Determine the end row and column for the current block
            int rowEnd = Math.min(rowStart + gridSize, numRows);
            int colEnd = Math.min(colStart + gridSize, numCols);
            
            int redSum = 0;
          int greenSum = 0; 
          int blueSum = 0;
            int pixelCount = 0;
//SETS THE SUM OF RED GREEN AND BLUE THAT WILL BE DIVIDED LATER
          
          //rowstart determines the start of your current chunk, row end is the end of the chunk
          for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); 
                    redSum += pixel.getRed();         //adds the current colors of the pixel to the total chunk value
                    greenSum += pixel.getGreen();     
                    blueSum += pixel.getBlue();      
                    pixelCount++;                     //goes to next pixel while adding 1 to the count
                }
            }
            
            int avgRed = redSum / pixelCount;
            int avgGreen = greenSum / pixelCount;//divides the chunk colors by total amt of pixels there are in the chunk
            int avgBlue = blueSum / pixelCount;
            
            // Set each pixel in the block to the average color
            for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); // Get the Pixel object at (row, col)
            
                  pixel.setRed(avgRed);             
                   pixel.setGreen(avgGreen);     // Set the colors in that chunk to the average color
                pixel.setBlue(avgBlue);           
         }
      }
   }
}
}





/*

THIS NEXT METHOD WE WORKED ON IN CLASS FOR OUR PROJECT
I WORKED WITH CARA AND CHLOE
IT ADDS MOTION BLUR
YOU USE A PARAMETER TO DETERMINE WHAT DIRECTION 


*/
public void motionBlur(int length, String direction) {
    Pixel[][] imagePixels = getImagePixels();  // Get the 2D array of Pixel objects

    // Traverse the image pixel array
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        int redTotal = 0, greenTotal = 0, blueTotal = 0;
        int count = 0;

        // Check neighboring pixels based on the direction
        for (int i = 0; i < length; i++) {
          int newX = x;
          int newY = y;

          // Adjust coordinates based on the motion blur direction
          if (direction.equals("horizontal")) {
            newX = x + i;
          } else if (direction.equals("vertical")) {
            newY = y + i;
          } else if (direction.equals("diagonal")) {
            newX = x + i;
            newY = y + i;
          }

          // Make sure the new coordinates are within bounds of the image
          if (newX >= 0 && newX < getWidth() && newY >= 0 && newY < getHeight()) {
            Pixel currentPixel = imagePixels[newY][newX];
            redTotal += currentPixel.getRed();
            greenTotal += currentPixel.getGreen();
            blueTotal += currentPixel.getBlue();
            count++;
          }
        }

        // Calculate the average color values of the neighboring pixels
        int avgRed = redTotal / count;
        int avgGreen = greenTotal / count;
        int avgBlue = blueTotal / count;

        // Create a Color object with the average RGB values
        Color avgColor = new Color(avgRed, avgGreen, avgBlue);

        // Use a set method to update the pixel (assuming setPixel is available)
        setPixel(x, y, avgColor);  // Replace this with the actual method for setting the pixel
      }
    }
  }



/*
WE WORKED ON THIS FOR THE PROJECT
 */

  /*
   * Applies a threshold filter to an image
   */

  
  public void threshold(int value) {
    // Get the image pixels
    Pixel[][] imagePixels = getImagePixels();  // Assuming this method gives you the 2D Pixel array

    // Traverse the 2D array of pixels
    for (int row = 0; row < getHeight(); row++) {
        for (int col = 0; col < getWidth(); col++) {
            // Get the current pixel
            Pixel currentPixel = imagePixels[row][col];

            // Get the RGB values of the current pixel
            int red = currentPixel.getRed();
            int green = currentPixel.getGreen();
            int blue = currentPixel.getBlue();

            // Calculate the average grayscale value of the pixel
            int avgRGB = (red + green + blue) / 3;

            // If the average RGB value is less than the threshold, set to black
            if (avgRGB < value) {
                currentPixel.setRed(0);
                currentPixel.setGreen(0);
                currentPixel.setBlue(0);
            } else {
                // Otherwise, set to white
                currentPixel.setRed(255);
                currentPixel.setGreen(255);
                currentPixel.setBlue(255);
            }
        }
    }
}

  
 public void zeroGreen() {
    // 0. Get the 2D array of pixels
    Pixel[][] pixels = getImagePixels();
    
    // 1. Traverse the 2D array of Pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
      // 2. Select out the current pixel
      Pixel currentPixel = pixels[row][col];
      
      // 3. Remove all the red of the current pixel
      currentPixel.setGreen(0);
      }
    }
 }
}