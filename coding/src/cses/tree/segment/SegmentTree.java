package cses.tree.segment;

import java.io.*;

/*
min max logic
@author: akash
 */
public class SegmentTree {
    long[] st;
    int size;

    public SegmentTree(int n){
        size = 1;
        while (size<n) {
            size = size*2;
        }
        st=new long[2*size];
    }

    void constructUtil(int i, int v, int x, int lx, int rx){
        if(rx-lx == 1){
            st[x] = v;
            return ;
        }
        int m=(lx+rx)/2;
        if(i<m){
            constructUtil(i,v,2*x+1,lx,m);
        }
        else{
            constructUtil(i,v,2*x+2,m,rx);
        }
        st[x]=Math.min(st[2*x+1],st[2*x+2]);
    }
    void constructUtil(int i, int v){
        constructUtil(i,v,0,0, size);
    }

    long min(int l, int r, int x, int lx, int rx){
        if(l>=rx||r<=lx)
            return Integer.MAX_VALUE;

        if(lx>=l&&rx<=r){
            return st[x];
        }

        int m=(lx+rx)/2;
        long s1= min(l,r,2*x+1,lx,m);
        long s2= min(l,r,2*x+2,m,rx);
        return Math.min(s1,s2);
    }
    long min(int l, int r){
        return min(l,r,0,0,size);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input1 =br.readLine().split(" ");
        int n=Integer.parseInt(input1[0]);
        int query=Integer.parseInt(input1[1]);

        int[] arr =new int[n];
        int i;
        String[] input2 =br.readLine().split(" ");

        SegmentTree seg=new SegmentTree(n);

        for(i=0;i<n;i++){
            arr[i]=Integer.parseInt(input2[i]);
            seg.constructUtil(i, arr[i]);
        }

        seg.displaySegment();

        while(query-->0){
            String[] input3 =br.readLine().split(" ");
            int u=Integer.parseInt(input3[0]);
            int v=Integer.parseInt(input3[1]);
            int k=Integer.parseInt(input3[2]);
            if(u==1){
                seg.constructUtil(v,k);
                seg.displaySegment();
            }
            else{
                System.out.println(seg.min(v, k));
            }
        }
    }

    private void displaySegment() {
        for (long i: st) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}