import java.util.*;
class BurningTree {
    static TreeNode n1 = null;
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,Integer> vis = new HashMap<TreeNode,Integer>();
        Map<TreeNode,TreeNode> par = new HashMap<TreeNode,TreeNode>();
        getParent(root,null,par);
        getnode(root,start);
        return getMaxdis(n1, 0, vis, par);
    }
    
    
    public static void getParent(TreeNode root,TreeNode parent,Map<TreeNode,TreeNode>map){
        if(root==null){
            return;
        }
        map.put(root,parent);
        getParent(root.left,root,map);
        getParent(root.right,root,map);
    return;
    }

public static void getnode(TreeNode root,int a){
if(root==null){
    return;
}
    if(root.val==a){
        n1=root;
    }
    getnode(root.left,a);
    getnode(root.right,a);
    return;
}

    
    public static int getMaxdis(TreeNode start,int dis,Map<TreeNode,Integer>vis,Map<TreeNode,TreeNode> map){
        if(start==null){
            return dis-1;
        }
        if(vis.containsKey(start)){
            return Integer.MIN_VALUE;
        }
        vis.put(start,1);
        int a1 = Integer.MIN_VALUE;
        int a2 = Integer.MIN_VALUE;
        int a3 = Integer.MIN_VALUE;
        a1=getMaxdis(start.left,dis+1,vis,map);
        a2=getMaxdis(start.right,dis+1,vis,map);
        a3=getMaxdis(map.get(start),dis+1,vis,map);
        return Math.max(Math.max(a1,a2),a3);
        
        
    } 
}