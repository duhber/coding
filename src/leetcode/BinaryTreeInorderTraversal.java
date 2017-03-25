package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inorderList = new ArrayList<Integer>();
        inorder(root,inorderList);
        return inorderList;
        
    }
    
    private void inorder(TreeNode node, List<Integer> inorderList){
        if(node!=null){
            inorder(node.left,inorderList);
            inorderList.add(node.val);
            inorder(node.right,inorderList);
        }
    }

}
