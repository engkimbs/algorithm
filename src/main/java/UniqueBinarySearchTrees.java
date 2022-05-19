public class UniqueBinarySearchTrees {

    public static int numTrees(int finalNumberOfNodes) {
        int[] cache = new int[finalNumberOfNodes+1];
        cache[0]= 1;
        cache[1] = 1;
        for(int numberOfNodes = 2; numberOfNodes <= finalNumberOfNodes; numberOfNodes++)
            for(int leftDeployedNumberOfNodes = 0; leftDeployedNumberOfNodes<=numberOfNodes-1; leftDeployedNumberOfNodes++) {
                int rightDeployedNumberOfNodes = numberOfNodes-(leftDeployedNumberOfNodes+1);
                cache[numberOfNodes] += cache[rightDeployedNumberOfNodes]*cache[leftDeployedNumberOfNodes];
            }

        return cache[finalNumberOfNodes];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}