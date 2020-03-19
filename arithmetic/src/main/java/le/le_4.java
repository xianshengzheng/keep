package le;

public class le_4 {
    public static void main(String[] args) {
        le_4 le_4 = new le_4();
        System.out.println(le_4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length;
        int j = nums2.length;
        int ij = i + j;

        int left = (ij + 1) / 2;
        int right = (ij + 2) / 2;
        System.out.println(findK(nums1, 0, nums2, 0, left));
        System.out.println(findK(nums1, 0, nums2, 0, right));
        return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;

    }

    public int findK(int[] nums1, int i, int[] nums2, int j, int length) {
        if(i>= nums1.length){
            return nums2[j+length-1];
        }
        if(j>=nums2.length){
            return nums1[i+length-1];
        }
        if (length == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        if (a + i > nums1.length) {
            a = nums1.length - i;
            b = length - a;
        }
        if (b + j > nums2.length) {
            b = nums2.length - j;
            a = length - b;
        }



        if (nums1[a + i - 1] >= nums2[b + j - 1]) {
            j = b + j ;
            length -= b;
        } else {
            i = a + i;
            length -= a;
        }

        return findK(nums1, i, nums2, j, length);

    }
}
