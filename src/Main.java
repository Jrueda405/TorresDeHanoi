import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido a torres gemelas ");
        Torre TorreA=new Torre("Torre A",new Stack<>());
        Torre TorreB=new Torre("Torre B",new Stack<>());
        Torre TorreC=new Torre("Torre C",new Stack<>());


        TorreA.getTorre().push(4);
        TorreA.getTorre().push(3);
        TorreA.getTorre().push(2);
        TorreA.getTorre().push(1);


        ImprimirVista(TorreB,TorreA,TorreC);

        Hanoi(4,TorreA,TorreB,TorreC);

        ImprimirVista(TorreB,TorreA,TorreC);
    }
    static void Hanoi(int n, Torre  origen, Torre  destino, Torre auxiliar){
        if (n == 1){


            Mover(origen, destino);

            ImprimirVista(origen,destino,auxiliar);
        }
        else{
            //{mover n-1 discos de la torre origen a la torre auxiliar}
            Hanoi(n-1, origen, auxiliar, destino);
            //Mover un disco de la torre origen a la torre destino
            /*int top = origen.getTorre().peek();
            destino.getTorre().push(top);
            origen.getTorre().pop();*/

            Mover(origen,destino);
            //{mover n-1 discos de la torre auxiliar a la torre destino}
            Hanoi(n-1, auxiliar, destino, origen); //{llamada recursiva}
        }

    }
    public static void Mover(Torre origen,Torre destino){
        int top = origen.getTorre().peek();
        destino.getTorre().push(top);
        origen.getTorre().pop();


    }
    public static void ImprimirVista(Torre TorreEjemploA,Torre TorreEjemploB,Torre TorreEjemploC){

        ArrayList<Torre> listaTorres=new ArrayList<>();
        listaTorres.add(TorreEjemploA);
        listaTorres.add(TorreEjemploB);
        listaTorres.add(TorreEjemploC);
        Collections.sort(listaTorres, new Comparator<Torre>() {
            @Override
            public int compare(final Torre object1, final Torre object2) {
                return object1.getEtiqueta().compareTo(object2.getEtiqueta());
            }
        });
        String[][] arreglo= ConvertirTorresEnMatriz(4,listaTorres);
        for (int i = 0; i <arreglo.length ; i++) {
            for (int j = 0; j <arreglo[i].length ; j++) {
                System.out.print(arreglo[i][j]);
            }
            System.out.println();
        }
        System.out.println("________________________________");

    }
    public static String[][] ConvertirTorresEnMatriz(int cantidadDeDiscos,ArrayList<Torre> torres){
        String[][] miarreglo=new String[cantidadDeDiscos][3];
        ArrayList<Queue<Integer>> q=new ArrayList<>();
        for(int i=0;i<torres.size();i++){

            q.add(toQueue(torres.get(i).getTorre()));
        }

        for (int i = miarreglo.length-1; i >=0 ; i--) {
            for (int j = miarreglo[i].length-1; j >=0 ; j--) {
                if(j<=torres.get(j).getTorre().size()){
                    if(q.get(j).size()>0){
                        miarreglo[i][j]=q.get(j).poll()+" ";
                    }else{
                        miarreglo[i][j]="| ";
                    }

                }else{
                    miarreglo[i][j]="| ";
                }
            }
        }

        return miarreglo;
    }
    public static Queue<Integer> toQueue(Stack<Integer> stck){
        Queue<Integer> queue=new LinkedList<>();
        for(int i: stck){

                queue.add(i);
        }
        return queue;
    }
}
