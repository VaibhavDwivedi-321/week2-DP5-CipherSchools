class RecoverBst {
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        TreeNode curr = root;
        TreeNode num1 = null;
        TreeNode num2 = null;
        TreeNode prev =null;

        while(curr!=null){
            if(curr.left==null){

//check if current element is lesser the previous.
                if(prev!=null && prev.val>curr.val){
                    if(num1==null && num2==null){
                        num1 = prev;
                        num2 = curr;
                    }
                    else{   //if we find second such pair, save second element.
                        num2 = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            }
            else{
                TreeNode temp = curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp = temp.right;
                }
                if(temp.right==null){
                    temp.right = curr;
                    curr = curr.left;
                }
                else{

//check if current element is lesser the previous
                    if(prev!=null && prev.val>curr.val){
                        if(num1==null && num2==null){
                            num1 = prev;
                            num2 = curr;
                        }
                        else{  //if we find second such pair, save second element.
                            num2 = curr;
                        }
                    }
                    prev = curr;
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
//swap the Node values
        int temp = num1.val;
        num1.val = num2.val;
        num2.val = temp;
    }
}