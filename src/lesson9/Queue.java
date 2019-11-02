package lesson9;

public class Queue {
    public static void main(String[] args){
        int[] arr=new int[10];
        int less = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<less) less=arr[i];
        }
//        int num[] = {1,2,3,4,5};
//        int min, max;
//
//        min=max=num[0];
//        for (int i=0; i<num.length;i++){
//            if (num[i]<min) min=num[i];
//            if (num[i]>max) max=num[i];
//        }
//        System.out.println(min);
//        System.out.println(max);



    }
    char[]q; // массив для хранения элементов очереди
    int putloc, getloc;

    Queue(int size){
        q= new char[size];
        putloc=getloc=0;
    }

    void put(char ch){
        if (putloc==q.length){
            System.out.println(" - Очередь заполнена");
            return;
        }
            q[putloc++]=ch;
    }

    char get(){
        if (getloc==putloc){
            System.out.println("Оречедь пуста");
        }
        return q[getloc++];
    }
}
