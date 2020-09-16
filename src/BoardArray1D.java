import java.io.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
public class BoardArray1D extends AbstractBoard {
    private int coloun ; 
    private int row ;
    private int [] board ;
    private int [] goal_board ;
    private int y_row;
    private int x_col;
    private char LMov;
    public BoardArray1D(){
        super();
        row=0;
        coloun=0;
    }
    public BoardArray1D(int x,int y){ // 2 parameter constructor
        super();
        coloun=x;
        row=y;
        board=new int[81];
        goal_board=new int[81];
        reset();
    }
    public BoardArray1D(int size){ // 1 parameter constructor
        super();
        coloun=size;
        row=size;
        board=new int[81]; 
        goal_board=new int[81];
        reset();   
    } 
    @Override
    void reset(){
        int m=1;
        int i;
        int k;
        System.out.println("Coloun"+coloun+"Row"+row);
        for(i=0;i<row;i++){
            for(k=0;k<coloun;k++){
                board[m-1]=m;
                goal_board[m-1]=m++;
            }
        }
        board[m-2]=97;
        goal_board[m-2]=97;
    }
    @Override
    void readFromFile(String name) {
        try{
            int i=0,m=0,k=0,savee=0;
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
            System.out.println("Col->"+coloun+"Row->"+row);
            for(i=0;i<=row && str[i]!=null;i++){
                
            
                for(k=0;k<coloun;k=k){
                    first=str[i].charAt(k);
                    k++;
                    second=str[i].charAt(k);
                    k++;
                    
                    
                    if(first=='b'){
                        board[m++]=97;
                    }
                    else{
                        board[m++]=((first-'0')*10)+(second-'0');
                    }
                    System.out.println(board[m-1]+" "+"K->"+k);  
                    k++;
                }
                    if(i==0){
                        savee=m;
                    }
                }
                coloun=savee;
                //
              
        }
        
        /*01 02 03
          04 05 06*/
        catch(Exception e){
            System.err.println("HATA : " + e.getMessage());
        }
    }
    @Override
    void writeToFile(String name){
        try{
            int m=0;
            FileWriter fWriter=null;
            BufferedWriter bWriter=null;
            fWriter=new FileWriter(name);
            bWriter=new BufferedWriter(fWriter);
            
            for(int i=0;i<row;i++){
                for(int k=0;k<coloun;k++){
                   
                    if(board[m]==97){
                        
                        bWriter.write('b');
                        bWriter.write('b');
                        bWriter.write('\t');
                    }
                    else if(board[m]<10){
                         
                        bWriter.write('0');
                        bWriter.write('0'+board[m]);
                        bWriter.write('\t');
                    }
                    else{
                        
                        bWriter.write('0'+(board[m]/10));
                        bWriter.write('0'+(board[m]%10));
                        bWriter.write('\t');
                    }
                    m++;
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
    void print(){
        int i,k,m=0;
        for(i=0;i<row;i++){
            for(k=0;k<coloun;k++){
                if(board[m]<10){
                    System.out.print("0"+board[m]+"\t");    
                }
                else if(board[m]==97){
                    System.out.print("\t");
                }
                else{
                    System.out.print(board[m]+"\t");
                }
                m++;
            }
                System.out.printf("\n");
        }
    }
    @Override
    void setSize(int x,int y){
        coloun=x;
        row=y;
        board=null;
        board=new int[81];
        reset();
    }
    @Override
    String to_String(){
        String str="basliyorudsad" ;
        int p=0;
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
                    + ((char)('0'+(char)board[p++])) 
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
        int m=0;
        for(int i=0;i<row;i++){
            for(int k=0;k<coloun;k++){
                if(board[m]!=goal_board[m++]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean  Move_L(){
        int m=Find_coordinates();
        if(x_col==0 || board[m-1]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[m]=board[m-1];
            board[m-1]=97;
            LMov='L';
            return true;
        }
    } 
    public boolean  Move_R(){
        int m=Find_coordinates();
        if(x_col==coloun-1 || board[m+1]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[m]=board[m+1];
            board[m+1]=97;
            LMov='R';
            return true;
        }
    }
    public boolean  Move_U(){
        int m=Find_coordinates();
        if(y_row==0 || board[m-coloun]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[m]=board[m-coloun];
            board[m-coloun]=97;
            LMov='U';
            return true;
        }        
    }
    public boolean  Move_D(){
        int m=Find_coordinates();
        if(y_row==row-1 || board[m+coloun]==98){
            return false;
            // do nothing ... 
        }
        else{
            board[m]=board[m+coloun];
            board[m+coloun]=97;
            LMov='D';
            return true;
        }
    }
    @Override
    boolean Move(char selection){
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
    public int Find_coordinates(){
        int i=0,m=0,
        k=0;
        boolean control=false;
        for(i=0;i<row && control==false;i++){
            for(k=0;k<coloun && control==false;k++){
                if(board[m++]==97){
                    y_row=i;
                    x_col=k;
                    control=true;
                }
            }
        }
        return m-1;
    }
    @Override
    int Cell(int index_y,int index_x){
        if(index_x>=coloun || index_y>=row || index_x<0 || index_y<0){
            System.exit(0);
        }
        return board[(index_y*coloun)+index_x];
    }
    @Override
    int GetRow(){return row;}
    @Override
    int GetColoun(){return coloun;}
}