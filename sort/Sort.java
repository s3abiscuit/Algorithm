class Sort {
    public static void main(String[] args) {
        
    }
    
    public static void selection (Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }
    
    public static void insertion (Comparable[] a, int lo, int hi) {
      for (int i = lo + 1; i < hi; i++) {
          for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
              exch(a, j, j-1);
          }
      }
      assert isSorted(a, lo, hi);
    }
    
    public static void shell (Comparable[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < n/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            assert isHsorted(a, h); 
            h /= 3;
        }
        assert isSorted(a);
    }
}
