import algorithm.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        Timestamp timestamp = Timestamp.from(Instant.now());

        //Question 1 - Whether there is a path to destination (bottom right) from origin (top left) or not. One can step over 0 and move right or down

        Traversal traversal = new Traversal();
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 1, 0, 0, 0, 0, 0),
                Arrays.asList(0, 1, 0, 1, 0, 0, 0),
                Arrays.asList(0, 0, 0, 1, 0, 0, 0),
                Arrays.asList(1, 1, 0, 0, 1, 0, 0),
                Arrays.asList(0, 0, 1, 0, 1, 1, 1),
                Arrays.asList(1, 1, 0, 0, 0, 1, 0),
                Arrays.asList(1, 0, 1, 1, 0, 0, 0)
        );
        System.out.println(traversal.hasPathToDestination(matrix));


        //Question 2 - Suggest all the passwords based on user input password by replacing certain characters. Eg -> Password = passIndexWord ; Suggestion = [ pa$$IndexW0rd, pas$IndexWord etc.]

        PasswordSuggester passwordSuggester = new PasswordSuggester();
        System.out.println(passwordSuggester.getSuggestions("password"));


        /**Question 3 - Design a LRU cache
         * algorithm.LRUCache cache = new algorithm.LRUCache(2);
         * cache.set(1, 10); // it will store a key (1) with value 10 in the cache.
         * cache.set(2, 20); // it will store a key (2) with value 20 in the cache.
         * cache.get(1); // returns 10
         * cache.set(3, 30); // evicts key 2 and store a key (3) with value 30 in the cache.
         * cache.get(2); // returns -1 (not found)
         * cache.set(4, 40); // evicts key 1 and store a key (4) with value 40 in the cache.
         * cache.get(1); // returns -1 (not found)
         * cache.get(3); // returns 30
         * cache.get(4); // returns 4
         */

        LRUCache lruCache = new LRUCache(3);
        lruCache.insert("Sachin", "Singh");
        lruCache.insert("Sumit", "Kaushik");
        lruCache.insert("Amit", "Singh");
        lruCache.insert("Shubham", "Kaushik");
        //lruCache.display();
        System.out.println(lruCache.get("Sumit"));
        System.out.println(lruCache.get("Amit"));
        System.out.println(lruCache.get("Sachin"));


        /**
         Question 4 - Given a NxN matrix of positive integers. There are only three possible moves from a cell
         Matrix[r][c].
         1. Matrix [r+1] [c]
         2. Matrix [r+1] [c-1]
         3. Matrix [r+1] [c+1]
         Starting from any column in row 0 return the largest sum of any of the paths up to row N-1.
         */
        List<List<Integer>> sumMatrix = Arrays.asList(
                Arrays.asList(16, 92, 41, 44),
                Arrays.asList(4, 2, 3, 4),
                Arrays.asList(17, 24, 4, 13),
                Arrays.asList(15, 1, 3, 0)
        );
        MaxSumTraversal maxSumTraversal = new MaxSumTraversal();
        System.out.println(maxSumTraversal.getMaxSumTraversal(sumMatrix));

        /**
         * BST CRUD operations
         */
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(Arrays.asList(15, 10, 20, 8, 12, 16, 25, 4, 11, 26, 27, 3, 2, 1, 0));
        System.out.println(bst.nearestVal(14));
        bst.inorder();
        bst.postorder();
        bst.preorder();
        bst.circumferenceView();
        bst.rightView();
        bst.leftView();
        System.out.println("Height:" + bst.height());
        System.out.println(bst.search(9));
        DoublyLinkedList dll = DoublyLinkedList.valueOf(bst);
        dll.display();
        dll.displayRev();
        bst.averageOfEachLevel();
        System.out.println("Common Ancestor : " + bst.getCommonAncestor(16, 25));
        /**
         *                15
         *           10        20
         *         8    12  16     25
         *      4     11                26
         *    3                             27
         *  2
         *1
         * */


        //Kth biggest element
        System.out.println(KthBiggest
                .getBiggest(new int[]{99, 198, 10, 20, 8, 12, 16, 25, 4, 11, 26, 27}, 1));

        //Implement a stack
        List<Integer> values = Arrays.asList(11, 15, 10, 20, 8, 12, 16, 25, 4, 11, 26, 27);
        StackPen stackPen = new StackPen(19);
        values.forEach(data -> {
            try {
                stackPen.insert(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(stackPen.contains(11));
        System.out.println("Minimum Value : " + stackPen.min());
        stackPen.pop();
        stackPen.pop();
        stackPen.pop();
        stackPen.pop();
        stackPen.pop();
        stackPen.pop();
        System.out.println(stackPen.contains(11));
        System.out.println(stackPen.contains(10));
        stackPen.popAll();


        //LinkedList to imput and reverse/reverse in group
        LinkedList ll = new LinkedList();
        values.forEach(data -> ll.insert(data));
        ll.display();
        ll.reverse();
        ll.display();
        ll.reverse(2);
        ll.display();

        //Sum of the values in 2 linked List
        LinkedList a = new LinkedList();
        a.insert(1);
        a.insert(6);
        a.insert(7);
        a.insert(1);
        LinkedList b = new LinkedList();
        b.insert(5);
        b.insert(9);
        b.insert(9);
        LinkedList ll1 = LinkedList.sum(a, b);
        ll1.display();

        //Rotate matrix by 90 degree anti-clockwise
        MatrixRotor.rotate(sumMatrix).forEach(row -> System.out.println(row));


        //Print next greater element
        NextGreaterElement.print(Arrays.asList(13, 7, 6, 12));


        //Singleton
        XSingleton xSingleton = XSingleton.getInstance();

        //PossibleJumps
        System.out.println(PossibleJumps.getPossibleJumps(3, 13));


        System.out.println("Longest Substring : " +
                LongestUniformString.getLongestUniformSubString("aabbbbbCdAA"));

        System.out.println("Smallest : " + SmallestNumber.getSmallestNumber(Arrays.asList(3, 4, 5, 6, 1, 2)));

        System.out.println("Kth Smallest : " + KthSmallest.getKthSmallest(Arrays.asList(3, 4, 5, 6, 1, 2), 2));

        System.out.println("Prime factors : " + PrimeFactor.getPrimeFactors(6));

        System.out.println(AnagramAnalytic.getComputedAnagram("cat dog tac sat tas god dog"));

        int[] sumVal = SumOfFractions.compute(new int[]{1, 2}, new int[]{2, 3});
        System.out.println("Sum of fraction : " + sumVal[0] + "/" + sumVal[1]);

        System.out.println("Length Encoded String : " + StringManipulation.encodeLength("aabbbc"));

        System.out.println("Non repeating first char : " + StringManipulation.getFirstNonRepeatingChar("apple"));

        PascalTriangle.print(9);

        System.out.println("Reversed string : " + StringManipulation.reverse("apple"));

        System.out.println("Is power of ten : " + MathUtil.isPowerOfTen(100000));

        System.out.println("Power value : " + MathUtil.power(10, 3));

        System.out.println("Missing values from panagram : " + StringManipulation.getMissingCharFromPanagram("sachin kumar singh"));

        System.out.println("Loop Length : " + CycleLength.compute(new int[]{2, 0, 4, 1, 3}, 1));

        System.out.println("[Logs] Maximum consumers : " + LogUtil.getMaximumConsumer(Arrays.asList("10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20")));

        System.out.println("Unique Tuples : " + UniqueTuples.getUniqueTuples("aaab", 3));

        System.out.println("ATOI : " + MathUtil.atoi("345"));

        System.out.println("Median : " + MedianOfTwoArray.compute(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}));

        System.out.println("Distinct character String : "+StringManipulation.removeDuplicateCharacters("qegdogoqwgdouasaaaswsssss"));

        int[] nearestElements = NeartestGreater.compute(new int[]{1,2,3,4,3});
        System.out.println("Nearest greatest");
        for(int element :nearestElements)
        {
            System.out.println(element);
        }

        System.out.println("Smallest sub-array exceeding target : " + SmallestSubArrayExceedingTarget.compute(new int[]{1, 4, 45, 6, 0, 19}, 51));

        System.out.println("Who is elected : " + WhoIsElected.compute(100, 21));

        int[] position = RobotUtil.move("rluldldddURLDDDudllURlllddddrrrrrrrrr");
        System.out.println("Move robot \nx : " + position[0] + "\ny : " + position[1]);

        System.out.println("Min diff between two word : " + StringManipulation.distanceBetweenTwoWord("geeks for geeks contribute practice", "geeks", "practice"));

        System.out.println("Optimal collection path : " + MaxCollectOptimalPath.compute(new int[][]{{0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}}));

        System.out.println("Maximum snow collected : " + MaxSnowCollection.compute(new int[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}));
        //[0,1,3,3,3,3,3,4,4,4,4,4]
        //[4,4,4,4,4,4,4,3,3,3,3,0]
        // 0,0,0,3,2,1,3,0,1,3,0,0

        System.out.println("Longest palindrome : " + LongestPalindrome.compute("forgeeksskeegfor"));

        System.out.println("Is open closed bracket : " + OpenClosedBracket.validate("{{{[(({{}}))]}}}"));

        System.out.println("Fraction to decimal : " + RepeatingDecimalBracket.fractionToDecimal(23, 22));

        System.out.println("Time elapsed : " + (Timestamp.from(Instant.now()).getTime() - timestamp.getTime()) + "ms");

    }
}
