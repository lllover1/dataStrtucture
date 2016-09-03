package graphAlo;

public class ShortestPath {
	public int[] dijkstra(int[][] graph,int i){
		int n = graph.length;
		int[] proPath = new int[n];
		int[] cost = new int[n];
		boolean[] isRead = new boolean[n];
		for(int j=0;j<n;j++){
			proPath[j] = i;
			cost[j] = graph[i][j];
			isRead[j] = false;
		}
		isRead[i]= true;
		
		for(int j=0;j<n;j++){
			int min = 0;
			int minCost = Integer.MAX_VALUE;
			for(int k=0;k<n;k++){
				if(!isRead[k]&&cost[k]<minCost){
					min = k;
					minCost = cost[k];
				}
			}
			if(minCost == Integer.MAX_VALUE){
				throw new  IllegalArgumentException("图为非连通图");
			}
			isRead[min] = true;
			
			for(int k=0;k<n;k++){
				if(!isRead[k]&&cost[k]>cost[min]+graph[min][k]){
					cost[k] = cost[min]+graph[min][k];
					proPath[k] = min;
				}
			}
		}
		
		return proPath;
	}
	
	public int[][] floyd(int[][] graph){
		int length = graph.length;
		int[][] cost = new int[length][length];
		int[][] path = new int[length][length];
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				cost[i][j] = graph[i][j];
				if(i!=j&&cost[i][j]<Integer.MAX_VALUE){
					path[i][j] = i;
				}else{
					path[i][j] = -1;
				}
			}
		}
		
		for(int k=0;k<length;k++){
			for(int i=0;i<length;i++ ){
				if(i!=k){
					for(int j=0;j<length;j++){
						if(j!=k&&j!=i&&cost[i][j]>cost[i][k]+cost[k][j]){
							cost[i][j]=cost[i][k]+cost[k][j];
							path[i][j] = path[k][j];
						}
					}
				}
			}
		}
		
		return path;
	}
}
