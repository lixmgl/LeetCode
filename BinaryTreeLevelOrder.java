/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer>level=new ArrayList<Integer>();
        List<TreeNode>nextLevel=new ArrayList<TreeNode>();
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        if(root==null) {return result;}
        int currentLevelNum=1;
        int nextLevelNum=0;
        nextLevel.add(root);
        while(nextLevel!=null && nextLevel.size()!=0){
            root=nextLevel.get(0);
            level.add(root.val);
            currentLevelNum--;
            nextLevel.remove(0);
            if(root.left!=null){
                nextLevelNum++;
                nextLevel.add(root.left);
            }
            if(root.right!=null){
                nextLevelNum++;
                nextLevel.add(root.right);
            }
            if(currentLevelNum==0){
                currentLevelNum=nextLevelNum;
                nextLevelNum=0;
                result.add(level);
                level=new ArrayList<Integer>();
            }
        }
        return result;
    }
}