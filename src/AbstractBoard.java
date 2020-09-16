/**
   * @author berkyigitdursun

 */
public abstract class AbstractBoard {
    abstract void reset(); //+
    abstract void print(); //+
    abstract void setSize(int x,int y);
    abstract String to_String();
    abstract boolean IsSolved();
    abstract boolean Move(char selection);
    abstract int Cell(int index_y,int index_x);
    abstract void readFromFile(String name);
    abstract void writeToFile(String name);
    protected static int NumOfBoard=0;
    protected int NumOfMove=0;
    protected char LMov;
    public int NumberOfBoard(){
        return NumOfBoard;
    }
    public int NumberOfMove(){
        return NumOfMove;
    }
    /*public char LastMove(){
        return LMove;
    }*/
    abstract int GetRow();
    abstract int GetColoun();

    public AbstractBoard(){NumOfBoard++;}
    public boolean equal(AbstractBoard  compare){
			 	boolean i=true;
				int k=0;
				int m=0;
				for(k=0;k<compare.GetRow();k++){
					for(m=0;m<compare.GetColoun();m++){
						 if((this).Cell(k,m)!=(compare).Cell(k,m)){
						 		
                                return false; 
                        }
					}

				}
				return true;

		}
}