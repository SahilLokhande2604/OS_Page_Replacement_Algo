import java.util.*;
public class OptimalPageReplacement {

    private int findInFuture(int pages, int[] refrenceString, List<Integer>frames, int index){
        int pageIndex=index;
        int frameNo=0;

        for(int i=0;i<frames.size();i++){
            int j=index+1;
            for(;j<pages;j++){

                if(refrenceString[j]==frames.get(i)){
                    if(j>pageIndex){
                        pageIndex=j;
                        frameNo=i;
                    }
                    break;
                }
            }
            if(j==pages){
                pageIndex=j;
                frameNo=i;
                break;
            }
        }

        return frameNo;
    }

    public void OptimalPageReplacementAlgo(int pages, int[] refrenceString, int frames){
        int hit=0;
        int miss=0;

        List<Integer>frame=new ArrayList<>(frames);

        int frameNo=0;
        for(int i=0;i<pages;i++){
            if(frame.size()<frames){
                if(frame.contains(refrenceString[i])){
                    hit++;
                }
                else{
                    miss++;
                    frame.add(refrenceString[i]);
                }
            }
            else{
                if(frame.contains(refrenceString[i])){
                    hit++;
                    System.out.println(frame);
                    continue;
                }
                // find the page which is use in longest time in future
                int frameIndex=findInFuture(pages, refrenceString, frame, i);

                frame.remove(frameIndex);

                frame.add(refrenceString[i]);
                miss++;
            }
            System.out.println(frame);
        }


        System.out.println("No. of hit "+ hit);
        System.out.println("No. of miss "+ miss);

        

    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of pages");
        int pages=sc.nextInt();
        System.out.println("Enter the no. of frames");
        int frames=sc.nextInt();
        int[] refrence=new int[pages];
        System.out.println("Enter the page no. in sequence ");
        for(int i=0;i<pages;i++){
            refrence[i]=sc.nextInt();
        }

        OptimalPageReplacement opr=new OptimalPageReplacement();
        opr.OptimalPageReplacementAlgo(pages, refrence, frames);
    }
}


// 20
// 4
// 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1