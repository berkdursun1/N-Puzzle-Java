import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
  * @author berkyigitdursun
  * @since 17.01.2020
    @version 1.0
  * 
 */
public class Main {
   /**
    * Test_fuction which is Call all the method for 2 class(one d array,two d array)
    * global function checks whether the movements in the given array are correct
    */
    public static void Test_Function(){
        int selection;
        AbstractBoard[] test = new AbstractBoard[2];
        test[1] = new BoardArray2D(3,3);
        test[0] = new BoardArray1D(3,3);
        Scanner ht = new Scanner(System.in);
        int index1,index2;
        String txt="berk.txt" ;
        String w_txt="yigit.txt" ;
        System.out.println("One D Array Class");
        System.out.println("Read From File Method");
        test[0].readFromFile(txt);
        test[0].print();
        System.out.println("Write From File Method");
        test[0].writeToFile(w_txt);
        System.out.println("Move Method");
        do{
            System.out.println("Please enter choise");
            System.out.println("0->Up -- 1->Left -- 2->Down -- 3->Right ");
            System.out.println("-1 for quit");
            selection=ht.nextInt();
            if(selection==0){
                test[0].Move('U');
                test[0].print();
            }
            else if(selection==1){
                test[0].Move('L');
                test[0].print();
            }
            else if(selection==2){
                test[0].Move('D');
                test[0].print();
            }
            else if(selection==3){
                test[0].Move('R');
                test[0].print();
            }
            
        }while(selection!=-1);
        System.out.println("Set Method");
        System.out.println("Please enter x-y coordinates");
        index1=ht.nextInt();
        index2=ht.nextInt();
        test[0].setSize(index1,index2);
        test[0].print();
        System.out.println("Reset");
        test[0].reset();
        test[0].print();
        System.out.println("Test for IsSolved Method");
        System.out.println("The game dont stop until is solved");
        do{
            System.out.println("Please enter choise");
            System.out.println("0->Up -- 1->Left -- 2->Down -- 3->Right ");
            System.out.println("-1 for quit");
            selection=ht.nextInt();
            if(selection==0){
                test[0].Move('U');
                test[0].print();
            }
            else if(selection==1){
                test[0].Move('L');
                test[0].print();
            }
            else if(selection==2){
                test[0].Move('D');
                test[0].print();
            }
            else if(selection==3){
                test[0].Move('R');
                test[0].print();
            }
            
        }while(!test[0].IsSolved());
        System.out.println("Testing for Cell Method");
        System.out.println("The program dont stop until the entered values are valid");
        do{
            System.out.println("Please enter coordinates");
            index1=ht.nextInt();
            index2=ht.nextInt();
            
        }while(test[0].Cell(index1,index2)==-1);
        System.out.println(test[0].Cell(index1,index2));


        System.out.println("2 D array");
        System.out.println("Read From File Method");
        test[1].readFromFile(txt);
        test[1].print();
        System.out.println("Write From File Method");
        test[1].writeToFile(w_txt);
        System.out.println("Move Method");
        do{
            System.out.println("Please enter choise");
            System.out.println("0->Up -- 1->Left -- 2->Down -- 3->Right ");
            System.out.println("-1 for quit");
            selection=ht.nextInt();
            if(selection==0){
                test[1].Move('U');
                test[1].print();
            }
            else if(selection==1){
                test[1].Move('L');
                test[1].print();
            }
            else if(selection==2){
                test[1].Move('D');
                test[1].print();
            }
            else if(selection==3){
                test[1].Move('R');
                test[1].print();
            }
            
        }while(selection!=-1);
        System.out.println("Set Method");
        System.out.println("Please enter x-y coordinates");
        index1=ht.nextInt();
        index2=ht.nextInt();
        test[1].setSize(index1,index2);
        test[1].print();
        System.out.println("Reset");
        test[1].reset();
        test[1].print();
        System.out.println("Test for IsSolved Method");
        System.out.println("The game dont stop until is solved");
        do{
            System.out.println("Please enter choise");
            System.out.println("0->Up -- 1->Left -- 2->Down -- 3->Right ");
            System.out.println("-1 for quit");
            selection=ht.nextInt();
            if(selection==0){
                test[1].Move('U');
                test[1].print();
            }
            else if(selection==1){
                test[1].Move('L');
                test[1].print();
            }
            else if(selection==2){
                test[1].Move('D');
                test[1].print();
            }
            else if(selection==3){
                test[1].Move('R');
                test[1].print();
            }
            
        }while(!test[1].IsSolved());
        System.out.println("Testing for Cell Method");
        System.out.println("The program dont stop until the entered values are valid");
        do{
            System.out.println("Please enter coordinates");
            index1=ht.nextInt();
            index2=ht.nextInt();
            
        }while(test[1].Cell(index1,index2)==-1);
        System.out.println(test[1].Cell(index1,index2));
        
        
        /*
        
        System.out.println("Two D Array Class");
        
        hi.readFromFile(txt);
        hi.print();
        hi.writeToFile(w_txt);
        hi.Move('L');
        hi.Move('U');
        hi.Move('R');
        hi.print();
        hi.reset();
        hi.print();
        hi.set(3,3);
        hi.print();
        System.out.println(hi.IsSolved());
        index1=ht.nextInt();
        index2=ht.nextInt();
        System.out.println(hi.Cell(index1,index2));
        //System.out.println(hey.NumberOfBoard());

    */
    }
    public static boolean global(AbstractBoard[] abs){  
        boolean f=true;
        int i=0;
        int k=0;
        int t=0;
        int size=abs[0].NumberOfBoard();
        
        
           while(i<size-1){
                System.out.println("SYSTEM");
                abs[i].print();
                System.out.println("SYSTEM");
                abs[i+1].print();
                
                System.out.println("");
                
                t=0;
                if(abs[i].Move('U')){
                    if(abs[i].equal(abs[i+1])){
                        t=1;
                    }
                    abs[i].Move('D');	
                }
                if(abs[i].Move('L')){
                    if(abs[i].equal(abs[i+1])){
                        t=1;
                    }
                    abs[i].Move('R');	
                }
                if(abs[i].Move('D')){
                    if(abs[i].equal(abs[i+1])){
                        t=1;
                    }
                    abs[i].Move('U');	
                }
                if(abs[i].Move('R')){
                    if(abs[i].equal(abs[i+1])){
                        t=1;
                    }
                    abs[i].Move('L');	
                }
                if(t==0){
                    System.out.println("I"+i);
                    abs[i].print();
                    abs[i+1].print();
                    return false;
                }	
                i++;
            }
        return true;
    }
    public static void main(String [] args){
             
            Test_Function();
        }
    
}

