package frc.robot;
import java.util.ArrayList;

public class DataTable {

    private ArrayList<ArrayList> data;

    //creates a table with empty columns with the given names
    public DataTable(String ... columnTags){
        ArrayList<String> firstRow = new ArrayList<String>();
        this.data = new ArrayList();
        firstRow.add("");
        for(String tag: columnTags){
            firstRow.add(tag);
        }
        this.data.add(firstRow);
    }

    //sets the item at the given place to the given value
    public void setEntry(String row, String tag, int value){
        for(ArrayList i: data){
            if(i.get(0).equals(row)){
                for(int j = 1; j < i.size(); j++) {
                    if(data.get(0).get(j).equals(tag)){
                        i.set(j, value);
                    }
                }
            }
        }
    }
    
    //returns the name of a row at an index
    public String getRowName(int index){
        return (String) data.get(index).get(0);
    }

    //changes name of row given its index
    public void changeRowName(int index, String newName){
        data.get(index).set(0,newName);
    }

    //changes name of a row given its old name
    public void changeRowName(String oldName, String newName){
        for(ArrayList li: data){
            if(li.get(0).equals(oldName)){
                li.set(0,newName);
            }
        }
    }

    //adds empty rows with the given names
    public void addRows(String ... rows){
        for(String i: rows){
            ArrayList temp = new ArrayList();
            temp.add(i);
            data.add(temp);
        }
    }

    //returns the numbe of tags, or columns
    public int getTagCount(){
        return data.get(0).size() -1;
    }
    
    //adds rows
    public void addFullRows(String[] rows, int[][] values){
        int x = 0;
        for(String str: rows){
            ArrayList temp = new ArrayList();
            temp.add(str);
            for(int i: values[x]){
                temp.add(i) ;
            }
            x++;
            data.add(temp);
        }
    }

    public void fillRow(String row, int ... nums){
        for(ArrayList i: data){
            if(i.get(0).equals(row)){
                for(int j: nums){
                    i.add((int) j);
                }
            }
        }
    }

    public int getEntry(String row, String tag){
        int x = 0;
        for(ArrayList i: data){
            if(i.get(0).equals(row)){
                for(int j = 1; j < i.size(); j++){
                    if(data.get(0).get(j).equals(tag)){
                        return (int) data.get(x).get(j);
                    }
                }
            }
            x++;
        }
        return -666;
    }

    public int[] getColumn(String tag){
        int index = 0;
        int[] column = new int[data.size()];
        for(index = 0; index < data.get(0).size() && (! ((String) data.get(0).get(index)).equals(tag) ); index++);
        if(data.get(0).get(index).equals(tag)){
            for(int i = 1; i < data.size(); i++){
                column[i] = (int) data.get(i).get(index);
            }
            return column;
        }
        return new int[] {-666};
    }

    public String toString(){
        String out = "";
        int[] maxC = new int[data.get(0).size()];
        
        for(ArrayList li: data){
            for(Object obj: li){
                int c = 0;
                String x = obj + "";
                if(  x.length() > maxC[c] ) {
                    maxC[c] = ((String)obj).length();
                }
                c++;
            }
        }
        for(ArrayList li: data){
            for(Object obj: li){
                int c = 0;
                out = out + " " + obj;
                String x = obj + "";
                for(int sp = maxC[c]; sp > x.length(); sp-- ){
                    out = out + " ";
                }
                c++;
            }
            out= out + "\n";
        }
        return out;
    }
    public int size(){
        return data.size();
    }
}