import java.util.*;

public class FIFO_PageReplacement{

    public void fifoPageReplacementAlgo(List<Integer>request, int frames){
        Queue<Integer>queue=new LinkedList<>();
        int hit=0;
        int miss=0;

        for(int i=0;i<request.size();i++){
            if(queue.size()<3){
                if(!queue.contains(request.get(i))){
                    miss++;
                    queue.add(request.get(i));
                }
                else{
                    hit++;
                }
            }
            else if(queue.contains(request.get(i))){
                hit++;
            }
            else{
                queue.poll();
                queue.add(request.get(i));
                miss++;
            }
            System.out.println(queue);
        }

        System.out.println("No. of hit "+ hit);
        System.out.println("No. of miss "+ miss);

    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the no. of frames in main memeory");
        int frames=sc.nextInt();

        System.out.println("Enter the page no. demanded by CPU in a sequence");
        System.out.println("Enter -1 to stop");
        List<Integer>request=new ArrayList<>();
        int page=sc.nextInt();
        while(page!=-1){
            request.add(page);
            page=sc.nextInt();
        }

        FIFO_PageReplacement fifo= new FIFO_PageReplacement();

        fifo.fifoPageReplacementAlgo(request, frames);
    }
}