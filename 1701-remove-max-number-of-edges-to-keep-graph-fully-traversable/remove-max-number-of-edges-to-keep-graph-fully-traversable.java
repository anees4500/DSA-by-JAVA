class DSU {
int[] parent, rank;
int components;


DSU(int n){
    parent = new int[n];
    rank = new int[n];
    components = n;
    for(int i=0;i<n;i++) parent[i]=i;
}

int find(int x){
    if(parent[x]!=x) parent[x] = find(parent[x]);
    return parent[x];
}

boolean union(int x, int y){
    int rx = find(x), ry = find(y);
    if(rx == ry) return false;

    if(rank[rx] < rank[ry]){
        parent[rx] = ry;
    } 
    else if(rank[ry] < rank[rx]){
        parent[ry] = rx;
    }
    else{
        parent[ry] = rx;
        rank[rx]++;
    }
    components--;
    return true;
}


}


class Solution {
public int maxNumEdgesToRemove(int n, int[][] edges) {
DSU alice = new DSU(n+1);
DSU bob   = new DSU(n+1);


    // Sort according to type: type 3 first
    Arrays.sort(edges,(a,b)-> b[0] - a[0]);

    int used = 0;

    for(int[] e : edges){
        int type = e[0];
        int u = e[1];
        int v = e[2];

        if(type == 3){
            boolean canAlice = alice.union(u, v);
            boolean canBob   = bob.union(u, v);

            if(canAlice || canBob) used++;
        }
    }

    for(int[] e : edges){
        int type = e[0];
        int u = e[1];
        int v = e[2];

        if(type == 1){
            if(alice.union(u,v)) used++;
        }
        else if(type == 2){
            if(bob.union(u,v)) used++;
        }
    }

    if(alice.components == 2 && bob.components == 2){
        return edges.length - used;
    }
    return -1;
}

}
