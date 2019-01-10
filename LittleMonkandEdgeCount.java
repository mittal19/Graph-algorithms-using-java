import java.util.*;
class  LittleMonkandEdgeCount
{
    LinkedList<Integer> link[];
    int S;

    LittleMonkandEdgeCount(int s)
    {
        S=s;
        link=new LinkedList[S+1];
        for(int i=0;i<=S;i++)
        {
            link[i]=new LinkedList<Integer>();
        }
    }

    void add(int a,int b)
    {
        link[a].add(b);
        link[b].add(a);
    }

    void bfs(int x)
    {
        boolean visit[]=new boolean[S+1];
      //  System.out.println("bfs");
        int edge=0,brk=0;
        int ele=1;
        LinkedList<Integer> qu=new LinkedList<>();
        int v=1;
        qu.add(v);
        visit[v]=true;
        while(qu.size()!=0)
        {
        //    System.out.println(v);
            v=qu.poll();
            Iterator<Integer> i = link[v].listIterator();
            while(i.hasNext())
            {
                ele=i.next();
                if(visit[ele]==false)
                {
                    visit[ele]=true;
                    qu.add(ele);
                    edge++;
                    if(edge==x)
                    {
                        brk=1;
                        break;
                    }
                }
            }
            if(brk==1)
                break;
        }
        //System.out.println("break"+ele);
        int count=0;
        LinkedList<Integer> qu2=new LinkedList<>();
        v=ele;
        qu2.add(v);

        while(qu2.size()!=0)
        {
        //    System.out.println(v+"d");
            v=qu2.poll();
            Iterator<Integer> i2 = link[v].listIterator();
            while(i2.hasNext())
            {
                ele=i2.next();
                if(visit[ele]==false)
                {
                    visit[ele]=true;
        //            System.out.println(ele+"ele");
                    count++;
                    qu2.add(ele);
                }
            }
            }
        count++;
        int rem=S-count;
        rem=((S*(S-1))/2)-(((rem*(rem-1))/2)+((count*(count-1))/2));
        System.out.println(rem);

    }

    public static void main(String[] args)
    {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        LittleMonkandEdgeCount obj=new LittleMonkandEdgeCount(n);
        int q=in.nextInt();
        for(int i=1;i<n;i++)
        {
            int a=in.nextInt();
            int b=in.nextInt();
            obj.add(a,b);
        }
        for(int i=0;i<q;i++)
        {
            int x=in.nextInt();
            obj.bfs(x);
        }
    }
}