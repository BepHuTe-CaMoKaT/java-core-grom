package lesson25.HW;

public class GeneralDAO<T> {
    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[5];

    public T save(T t) throws Exception {
        checkDuplicate(t);
        int index=0;
        for (T el:array){
            if (el==null){
                array[index]=t;
                return array[index];
            }
            index++;
        }
        throw new Exception("can't save");
    }

    public T[] getAll(){
        int index=0;
        int count=0;
        for (T t:array){
            if (t!=null) count++;
        }
        @SuppressWarnings("unchecked")
        T[] res=(T[]) new Object[count];
        for (T ts:res){
            if (ts!=null){
                res[index]=ts;
                return res;
            }
            index++;
        }
        return null;
    }

    private T checkDuplicate(T t) throws Exception {
        for (T ts:array){
            if (ts.equals(t))
                throw new Exception("Can't save");
        }
        return t;
    }
}
