package lesson24.exercise;

public class ToolDAO {
    private Tool[] tools=new Tool[5];

    public Tool save(Tool tool){
        int index=0;
        for (Tool tl:tools){
            if (tl==null){
                tools[index]=tool;
                return tools[index];
            }
            index++;
        }
        return null;
    }
}
