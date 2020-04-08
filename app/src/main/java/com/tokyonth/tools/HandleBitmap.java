package com.tokyonth.tools;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class HandleBitmap {
    
    public static Bitmap Encrypt(double d, Bitmap bitmap) {//加密
        Algorithms algorithms = new Algorithms();
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[(height * width)];
        int[] iArr2 = iArr;
        int i = width;
        bitmap.getPixels(iArr2, 0, i, 0, 0, width, height);
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{height, width});
        arrayFunctions.change(iArr, iArr3, height, width);
        algorithms.encrypt(iArr3, d, height, width);
        arrayFunctions.recovery(iArr3, iArr2, height, i);
        return Bitmap.createBitmap(iArr2, 0, i, i, height, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap Decrypt(double d, Bitmap bitmap) {//解密
        Algorithms algorithms = new Algorithms();
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[(height * width)];
        int[] iArr2 = iArr;
        int i = width;
        bitmap.getPixels(iArr2, 0, i, 0, 0, width, height);
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{height, width});
        arrayFunctions.change(iArr, iArr3, height, width);
        algorithms.decrypt(iArr3, d, height, width);
        arrayFunctions.recovery(iArr3, iArr2, height, i);
        return Bitmap.createBitmap(iArr2, 0, i, i, height, Bitmap.Config.ARGB_8888);
    }
}

