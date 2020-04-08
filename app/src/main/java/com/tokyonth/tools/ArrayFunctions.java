package com.tokyonth.tools;

public class ArrayFunctions {
    

    void recovery(int[][] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = i4;
            int i6 = 0;
            while (i6 < i2) {
                iArr2[i5] = iArr[i3][i6];
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
    }

    void change(int[] iArr, int[][] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = i4;
            int i6 = 0;
            while (i6 < i2) {
                iArr2[i3][i6] = iArr[i5];
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
    }

    void arr_change(int[][] iArr, int[][] iArr2, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4][i3] = iArr[i3][i4];
            }
        }
    }

    void arr_copy(double[] dArr, double[] dArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dArr2[i2] = dArr[i2];
        }
    }
}

