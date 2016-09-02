package graphAlo;

import java.util.ArrayList;
import java.util.List;

public class MinSpanTree {
	
	public void prim(int[][] graph,int i){
		int length = graph.length;
		int[] lowcost = new int[length];
		int[] close = new int[length];
		boolean[] s = new boolean[length];
		
		for(int j =0;j<length;i++){
			lowcost[j] = graph[i][j];
			close[j] = i;
			s[j] = false;
		}
		
		lowcost[i] = 0;
		close[i] = -1;
		s[i] = true;
		
		for(int j=0;j<length;j++){
			int min = 0;
			for(int k =0;k<length;k++){
				if(!s[k]&&lowcost[k]<lowcost[min]){
					min = k;
				}
			}
			s[i] = true;
			for(int k =0;k<length;k++){
				if(!s[k]&&graph[min][k]<lowcost[k]){
					close[k] =  min;
					lowcost[k] = graph[min][k];
				}
			}
		}
	}
    
	public void kruskal(Tripe[] tripe){
		for(int i =0;i<tripe.length;i++){
			int min = i;
			for(int j=i+1;j<tripe.length;j++){
				if(tripe[min].compareTo(tripe[j])>=0){
					min =j;
				}
			}
			Tripe temp = tripe[min];
			tripe[min] = tripe[i];
			tripe[i] = temp;
		}
		int[] parent = new int[tripe.length];
		List<Tripe> result = new ArrayList<>();
		for(int i=0;i<tripe.length;i++){
			
		}
		for(int i =0;i<tripe.length;i++){
		int m = find(parent,tripe[i].row);	
		int n = find(parent,tripe[i].column);
		if(m!=n){
			parent[m] = n;
			result.add(tripe[i]);
		}
		}
	}

	public int find(int[] parent,int index){
		while(parent[index]>=0){
			index = parent[index];
		}
		return index;
	}
}