package Others;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Bucket Sort 桶排序
     *
     * @param array unsorted input array
     */
    public static void bucketSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        // 建立桶，个数和待排序数组长度一样
        int length = array.length;
        LinkedList<Integer>[] bucket = new LinkedList[length];

        int maxValue = Arrays.stream(array).max().getAsInt();

        // 根据每个元素的值，分配到对应范围的桶
        for (int i = 0; i < array.length; i++) {
            int index = toBucketIndex(array[i], maxValue, length);
            // 检查是不是已经有桶了
            if (bucket[index] == null) {
                bucket[index] = new LinkedList<>();
            }
            bucket[index].add(array[i]);
        }

        // 对每一个非空的桶排序，排序后存入临时的list
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                temp.addAll(bucket[i]);
            }
        }

        // 讲排好序的临时list写入原数组
        for (int i = 0; i < length; i++) {
            array[i] = temp.get(i);
        }
    }

    private static int toBucketIndex(int value, int maxValue, int length) {
        return (value * length) / (maxValue + 1);
    }

    public static void radixSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;

        // 每位数字范围0-9，基为10
        int radix = 10;
        int[] aux = new int[length];
        int[] count = new int[radix + 1];

        // 以关键字来排序的轮数，由位数最多的数字决定，其余位数少的数字在比较高位时，自动用0进行比较
        // 将数字转换成字符串，字符串的长度就是数字的位数，字符串最长的那个数字也拥有最多的位数
        int x = Arrays.stream(array).map(s -> String.valueOf(s).length()).max().getAsInt();

        // 共需要d轮计数排序, 从d = 0开始，说明是从个位开始比较，符合从右到左的顺序
        for (int d = 0; d < x; d++) {
            // 1. 计算频率，在需要的数组长度上额外加1
            for (int i = 0; i < length; i++) {
                // 使用加1后的索引，有重复的该位置就自增
                count[digitAt(array[i], d) + 1]++;
            }
            // 2. 频率 -> 元素的开始索引
            for (int i = 0; i < radix; i++) {
                count[i + 1] += count[i];
            }

            // 3. 元素按照开始索引分类，用到一个和待排数组一样大临时数组存放数据
            for (int i = 0; i < length; i++) {
                // 填充一个数据后，自增，以便相同的数据可以填到下一个空位
                aux[count[digitAt(array[i], d)]++] = array[i];
            }
            // 4. 数据回写
            for (int i = 0; i < length; i++) {
                array[i] = aux[i];
            }
            // 重置count[]，以便下一轮统计使用
            for (int i = 0; i < count.length; i++) {
                count[i] = 0;
            }
        }
    }

    // 根据d，获取某个值的个位、十位、百位等
    // d = 0取出个位，d = 1取出十位，以此类推
    // 对于不存在的高位，用0补位
    private static int digitAt(int value, int d) {
        return (value / (int) Math.pow(10, d)) % 10;
    }

}
