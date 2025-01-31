import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {
    
  MyStory images = new MyStory();

//this establishes all the images I will use
images.print();
  Theater.playScenes(images);

    
  }
}