class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
class Solution {
    public static void mergeSort(ArrayList<Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    static int count = 0;

    public static void merge(ArrayList<Integer> arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        ArrayList<Integer> as = new ArrayList<>();
        while (i <= mid && j <= end) {
            int t = arr.get(i);
            int r = arr.get(j);
            if (t > r) {
                as.add(r);
                j++;
                int k = mid + 1;
                count = count + (k - i);
            }
            if (t < r) {
                as.add(t);
                i++;
            }

            if (t == r) {
                as.add(t);
                i++;
            }
        }

        while (i <= mid) {
            as.add(arr.get(i));
            i++;
        }

        while (j <= end) {
            as.add(arr.get(j));
            j++; 
        }

        for (int k = 0; k < as.size(); k++) {
            arr.set(start, as.get(k));
            start++;
        }
    }

    public static void rec(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        rec(root.left, arr);
        arr.add(root.data);
        rec(root.right, arr);
    }

    public static int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        rec(root, arr);
        mergeSort(arr, 0, arr.size() - 1);
        int tn = 0;
        tn = count;
        count = 0;
        return tn;
    }
}
