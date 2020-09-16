import java.io.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
/**
   * The BoardArray2D class is sub class of abstract class
 */
public class BoardArray2D extends AbstractBoard {
    private int coloun ; 
    private int row ;
    private int [][] board ;
    private int [][] goal_board ;
    private int y_row;
    private int x_col;
    private char LMov;
    public BoardArray2D(){
        super();
        row=0;
        coloun=0;
    }
    public BoardArray2D(int x,int y){ // 2 parameter constructor
        super();
        coloun=x;
        row=y;
        board=new int[9][9];
        goal_board=new int[9][9];
        reset();
    }
    public BoardArray2D(int size){ // 1 parameter constructor
        super();
        coloun=size;
        row=size;
        board=new int[9][9]; 
        goal_board=new int[9][9];
        reset();   
    } 
    @Override
    void reset(){
        int m=1;
        int i;
        int k;
        for(i=0;i<row;i++){
            for(k=0;k<coloun;k++){
                board[i][k]=m;
                goal_board[i][k]=m++;
            
            }
            
        }
        board[row-1][coloun-1]=97;
        goal_board[row-1][coloun-1]=97;
    }
    @Override
    void readFromFile(String name){
        /**    
        This method is used to read data from file  
        Str is which element that holds the data to be read
        First is 1.digit
        Second is 2.digit
        */
        try{
            int i=0,m=0,k=0,save;
            String [] str = new String[9];
            char first,second;
            FileInputStream fstream = new FileInputStream(name);
            DataInputStream dstream = new DataInputStream(fstream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dstream));
            while( (str[i] = bReader.readLine())  != null){
                i++;
            }
            
            //System.out.println(str[i-1].charAt(5));
            row=i;
            coloun=str[0].length();
            
            for(i=0;i<=row && str[i]!=null;i++){
                m=0;
            
                for(k=0;k<coloun;k=k){
                    first=str[i].charAt(k);
                    k++;
                    second=str[i].charAt(k);
                    k++;
                    
                    
                    if(first=='b'){
                        board[i][m++]=97;
                    }
                    else{
                        board[i][m++]=((first-'0')*10)+(second-'0');
                    }
                    
                    k++;
                }
                save=m;
            }
        coloun=m;    
        }
        
        /*01 02 03
          04 05 06*/
        catch(Exception e){
            System.err.println("HATA : " + e.getMessage());
        }
    }
    @Override
    void writeToFile(String name){
        /**
        Method to write data to a file 
        If 97 write to "bb"
        */
        try{
            FileWriter fWriter=null;
            BufferedWriter bWriter=null;
            fWriter=new FileWriter(name);
            bWriter=new BufferedWriter(fWriter);
            
            for(int i=0;i<row;i++){
                for(int k=0;k<coloun;k++){
                   
                    if(board[i][k]==97){
                        
                        bWriter.write('b');
                        bWriter.write('b');
                        bWriter.write('\t');
                    }
                    else if(board[i][k]<10){
                         
                        bWriter.write('0');
                        bWriter.write('0'+board[i][k]);
                        bWriter.write('\t');
                    }
                    else{
                        
                        bWriter.write('0'+(board[i][k]/10));
                        bWriter.write('0'+(board[i][k]%10));
                        bWriter.write('\t');
                    }
                }
                bWriter.newLine();
            }
            bWriter.close();
        }
        catch(Exception e){
            System.err.println("HATA : " + e.getMessage());
        }
    }
    @Override
    boolean Move(char selection){
        /**
        Method to move board by given selection
        */
        if(selection=='u' || selection=='U'){
            if(Move_U()){return true;}
            else{return false;}
        }
        else if(selection=='d' || selection=='D'){
            if(Move_D()){return true;}
            else{return false;}
        }
        else if(selection=='r' || selection=='R'){
            if(Move_R()){return true;}
            else{return false;}
        }
        else if(selection=='l' || selection=='L'){
            if(Move_L()){return true;}
            else{return false;}
        }
        return false;
        
    }
    @Override
    void print(){
        /**
        This Method to print board to display
        \t is tab 
         */
        int i,k;
        for(i=0;i<row;i++){
            for(k=0;k<coloun;k++){
                if(board[i][k]<10){
                    System.out.print("0"+board[i][k]+"\t");    
                }
                else if(board[i][k]==97){
                    System.out.print("\t");
                }
                else{
                    System.out.print(board[i][k]+"\t");
                }
            }
                System.out.printf("\n");
        }
    }
    @Override
    void setSize(int x,int y){
        /**
        This method to determinate the sizes
        */
        coloun=x;
        row=y;
        board=null;
        board=new int[y][x];
        reset();
    }
    @Override
    String to_String(){
        /**
        This method return the board by string format
        */
        String str="basliyorudsad" ;
        int m=0;
        int j;
        char x;
        for(int i=0;i<row;i++){
            for(int k=0;k<coloun;k++){
                if(i==row-1 && k==coloun-1){
                    str = str.substring(0, m) 
                    + ('\0') 
                    + str.substring(m + 1);
                 
                }
                else{
                    str = str.substring(0, m) 
                    + ((char)('0'+(char)board[i][k])) 
                    + str.substring(m + 1);
                }
                
                m++;
            }
            
        }
        j=m;
            while(j<str.length()){
                
                str = str.substring(0, j) 
                    + (' ') 
                    + str.substring(j + 1);
                 j++;   
            }
        //System.out.println((char)('0'+(char)board[1][1])); 
        return str;
    }
    @Override
    boolean IsSolved(){
        /** 
        This method to determinate is solved or not solved
        */
        for(int i=0;i<row;i++){
            for(int k=0;k<coloun;k++){
                if(board[i][k]!=goal_board[i][k]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
    Move methods
    */
    boolean Move_L(){
        Find_coordinates();
        if(x_col==0 || board[y_row][x_col-1]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[y_row][x_col]=board[y_row][x_col-1];
            board[y_row][x_col-1]=97;
            LMov='L';
            return true;
        }
    } 
    boolean Move_R(){
        Find_coordinates();
        if(x_col==coloun-1 || board[y_row][x_col+1]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[y_row][x_col]=board[y_row][x_col+1];
            board[y_row][x_col+1]=97;
            LMov='R';
            return true;
        }
    }
    boolean Move_U(){
        Find_coordinates();
        if(y_row==0 || board[y_row-1][x_col]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[y_row][x_col]=board[y_row-1][x_col];
            board[y_row-1][x_col]=97;
            LMov='U';
            return true;
        }        
    }
    boolean Move_D(){
        Find_coordinates();
        if(y_row==row-1 || board[y_row+1][x_col]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[y_row][x_col]=board[y_row+1][x_col];
            board[y_row+1][x_col]=97;
            LMov='D';
            return true;
        }
    }
    
    
    public void Find_coordinates(){
        /**
        Find the blank of y coordinate and x coordinate
        */
        int i=0,
        k=0;
        for(i=0;i<row;i++){
            for(k=0;k<coloun;k++){
                if(board[i][k]==97){
                    y_row=i;
                    x_col=k;
                }
            }
        }
    }
    @Override
    int Cell(int index_y,int index_x){
        if(index_x>=coloun || index_y>=row || index_x<0 || index_y<0){
            System.out.println("Not valid");
            System.exit(0);
        }
        return board[index_y][index_x];
    }
    @Override
    int GetRow(){return row;}
    @Override
    int GetColoun(){return coloun;}

}