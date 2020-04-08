package com.tokyonth.tools;

import java.lang.reflect.Array;
import java.util.HashMap;

public class Algorithms {
    

    static void SelectSort(double[] dArr, int i, HashMap hashMap, int[] iArr) {
        if (dArr != null && i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2;
                int i4 = i3;
                while (i3 < i) {
                    if (dArr[i3] < dArr[i4]) {
                        i4 = i3;
                    }
                    i3++;
                }
                if (i4 != i2) {
                    double d = dArr[i2];
                    dArr[i2] = dArr[i4];
                    dArr[i4] = d;
                }
                iArr[Integer.parseInt(String.valueOf(hashMap.get(Double.valueOf(dArr[i2]))))] = i2;
            }
        }
    }

    static void produce_logisticArray(double d, double[] dArr, int i) {
        dArr[0] = d;
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = i2 - 1;
            dArr[i2] = 3.9999999d * dArr[i3] * (1.0d - dArr[i3]);
        }
    }

    static void produce_map(HashMap hashMap, double[] dArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hashMap.put(Double.valueOf(dArr[i2]), Integer.valueOf(i2));
        }
    }

    double rowEncrypt(int[][] iArr, double d, int i, int i2, int i3) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        double[] dArr = new double[i3];
        produce_logisticArray(d, dArr, i3);
        HashMap hashMap = new HashMap();
        produce_map(hashMap, dArr, i3);
        double[] dArr2 = new double[i3];
        arrayFunctions.arr_copy(dArr, dArr2, i3);
        int[] iArr2 = new int[i3];
        SelectSort(dArr2, i3, hashMap, iArr2);
        int[] iArr3 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr3[iArr2[i4]] = iArr[i][i4];
        }
        for (int i5 = 0; i5 < i3; i5++) {
            iArr[i][i5] = iArr3[i5];
        }
        return dArr[i3 - 1];
    }

    void rowEncrypt_interface(int[][] iArr, double d, int i, int i2) {
        double d2 = d;
        for (int i3 = 0; i3 < i; i3++) {
            d2 = rowEncrypt(iArr, d2, i3, i, i2);
        }
    }

    double columnEncrypt(int[][] iArr, double d, int i, int i2, int i3) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        double[] dArr = new double[i3];
        produce_logisticArray(d, dArr, i3);
        HashMap hashMap = new HashMap();
        produce_map(hashMap, dArr, i3);
        double[] dArr2 = new double[i3];
        arrayFunctions.arr_copy(dArr, dArr2, i3);
        int[] iArr2 = new int[i3];
        SelectSort(dArr2, i3, hashMap, iArr2);
        int[] iArr3 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr3[iArr2[i4]] = iArr[i][i4];
        }
        for (int i5 = 0; i5 < i3; i5++) {
            iArr[i][i5] = iArr3[i5];
        }
        return dArr[i3 - 1];
    }

    void columnEncrypt_interface(int[][] iArr, double d, int i, int i2) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{i2, i});
        arrayFunctions.arr_change(iArr, iArr2, i, i2);
        double d2 = d;
        for (int i3 = 0; i3 < i2; i3++) {
            d2 = columnEncrypt(iArr2, d2, i3, i2, i);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{i, i2});
        arrayFunctions.arr_change(iArr2, iArr3, i2, i);
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i4][i5] = iArr3[i4][i5];
            }
        }
    }

    double rowDecrypt(int[][] iArr, double d, int i, int i2) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        double[] dArr = new double[i2];
        produce_logisticArray(d, dArr, i2);
        HashMap hashMap = new HashMap();
        produce_map(hashMap, dArr, i2);
        double[] dArr2 = new double[i2];
        arrayFunctions.arr_copy(dArr, dArr2, i2);
        int[] iArr2 = new int[i2];
        SelectSort(dArr2, i2, hashMap, iArr2);
        int[] iArr3 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr3[i3] = iArr[i][iArr2[i3]];
        }
        for (int i4 = 0; i4 < i2; i4++) {
            iArr[i][i4] = iArr3[i4];
        }
        return dArr[i2 - 1];
    }

    void rowDecrypt_interface(int[][] iArr, double d, int i, int i2) {
        double d2 = d;
        for (int i3 = 0; i3 < i; i3++) {
            d2 = rowDecrypt(iArr, d2, i3, i2);
        }
    }

    double columnDecrypt(int[][] iArr, double d, int i, int i2, int i3) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        double[] dArr = new double[i3];
        produce_logisticArray(d, dArr, i3);
        HashMap hashMap = new HashMap();
        produce_map(hashMap, dArr, i3);
        double[] dArr2 = new double[i3];
        arrayFunctions.arr_copy(dArr, dArr2, i3);
        int[] iArr2 = new int[i3];
        SelectSort(dArr2, i3, hashMap, iArr2);
        int[] iArr3 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr3[i4] = iArr[i][iArr2[i4]];
        }
        for (int i5 = 0; i5 < i3; i5++) {
            iArr[i][i5] = iArr3[i5];
        }
        return dArr[i3 - 1];
    }

    void columnDecrypt_interface(int[][] iArr, double d, int i, int i2) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{i2, i});
        arrayFunctions.arr_change(iArr, iArr2, i, i2);
        double d2 = d;
        for (int i3 = 0; i3 < i2; i3++) {
            d2 = columnDecrypt(iArr2, d2, i3, i2, i);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{i, i2});
        arrayFunctions.arr_change(iArr2, iArr3, i2, i);
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i4][i5] = iArr3[i4][i5];
            }
        }
    }

    void encrypt(int[][] iArr, double d, int i, int i2) {
        rowEncrypt_interface(iArr, d, i, i2);
        columnEncrypt_interface(iArr, d, i, i2);
    }

    void decrypt(int[][] iArr, double d, int i, int i2) {
        columnDecrypt_interface(iArr, d, i, i2);
        rowDecrypt_interface(iArr, d, i, i2);
    }
}

