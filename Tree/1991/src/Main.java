import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Node{
    char data;
    Node rc;
    Node lc;
    public Node(char data){
        this.data=data;
    }
}

class Tree{
    Node root;

    public void create(char data, char lc, char rc){
        if(root==null){
            root = new Node(data);
            if(lc!='.')  root.lc = new Node(lc);
            if(rc!='.')root.rc = new Node(rc);
        }else {
            search(root, data, lc, rc);
        }
    }
    public void search(Node root, char data, char lc, char rc){
        if(root==null) return;
        if(root.data == data){
            if(lc!='.')  root.lc = new Node(lc);
            if(rc!='.')  root.rc = new Node(rc);
        }else{
            search(root.lc, data, lc, rc);
            search(root.rc, data, lc, rc);
        }
    }

    public void preorder(Node root) {
        if(root==null) return;
            System.out.print(root.data);
            preorder(root.lc);
            preorder(root.rc);


    }
    public void inorder(Node root) {
        if(root==null) return;
        inorder(root.lc);
        System.out.print(root.data);
        inorder(root.rc);
    }
    public void postorder(Node root) {
        if(root==null) return;
        postorder(root.lc);
        postorder(root.rc);
        System.out.print(root.data);
    }


}
public class Main {
    static int arr[];
    static int n;
    static long last = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            char temp[] = br.readLine().replaceAll(" ", "").toCharArray();
            tree.create(temp[0], temp[1], temp[2]);
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);


    }

}