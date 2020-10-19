package TextUIPack;
import Model.LensManager;
import Model.Lens;
import Model.DepthOfField;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The class use to interact with the user, by displaying
 * text and reads the user input.
 */
public class TextUIClass {
    private LensManager manager;
    private Scanner in = new Scanner(System.in);
    public TextUIClass(LensManager manager){
        this.manager= manager;
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));

    }
    public void display(){
      boolean temp = false;
      while(! temp){
          System.out.println("Lenses to pick from:");
          System.out.println("0. Canon 50mm F1.8  ");
          System.out.println("1. Tamron 90mm F2.8 ");
          System.out.println("2. Sigma 200mm F2.8 ");
          System.out.println("3. Nikon 200mm F4.0 ");
          System.out.println("  (-1 to exit)");
          System.out.print(": ");
          int choice = in.nextInt();

          if( choice == -1){
              System.exit(0);
          }
          if(choice != 0 && choice!=-1 && choice != 1 && choice !=2 && choice != 3 ){
              System.out.println("Error: Invalid lens index. \n ");
          }

          switch(choice){
              case 0: case 1: case 2: case 3:
                  System.out.print("Aperture [the F number]: ");
                  double input_aperture = in.nextDouble();
                  if(input_aperture < manager.get_retrieve(choice).getMax_aperture()){
                      System.out.println("ERROR: This aperture is not possible with this lens, try again !!");
                      continue;
                  }
                  System.out.print("Distance to the Subject [m]: ");
                  double input_subject_distance = in.nextDouble();
                  if(input_subject_distance <0){
                      System.out.println("Distance cannot be negative try again!!");
                      continue;
                  }
                  DepthOfField info_cal = new DepthOfField(manager.get_retrieve(choice), input_subject_distance, input_aperture);
                  System.out.println("In Focus: " + formatM(info_cal.Nearfocal()) + "m to "+ formatM(info_cal.Farfocal()) + "m " + "[DoF =" + formatM(info_cal.depthoffield())+ "m]");
                  System.out.println("Hyperfocal point: "+ formatM(info_cal.Hyperfocal())+ "m");
                  System.out.println();

          }
      }
    }
    private String formatM(double distanceInM) {
        distanceInM = distanceInM/1000;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }

}
