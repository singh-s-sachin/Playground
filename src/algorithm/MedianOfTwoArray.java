package algorithm;

public class MedianOfTwoArray {
    public static int compute(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ax = 0, bx = 0, cx = 0;
        while (true) {
            if (ax < a.length && bx < b.length) {
                if (a[ax] > b[bx]) {
                    c[cx] = b[bx];
                    bx++;
                } else {
                    c[cx] = a[ax];
                    ax++;
                }
                cx++;
                continue;
            }
            if (ax >= a.length && bx >= b.length)
            {
                break;
            }
            if (ax >= a.length && bx < b.length) {
                for(int i=bx; i<b.length;i++,cx++)
                {
                    c[cx]=b[i];
                }
                break;
            }
            if (bx >= b.length && ax < a.length) {
                for(int i=ax; i<a.length;i++,cx++)
                {
                    c[cx]=a[i];
                }
                break;
            }
        }
        if(cx%2==0)
        {
            return (c[cx/2]+c[(cx-1)/2])/2;
        }
        else
        {
            return c[(cx-1)/2];
        }
    }
}
