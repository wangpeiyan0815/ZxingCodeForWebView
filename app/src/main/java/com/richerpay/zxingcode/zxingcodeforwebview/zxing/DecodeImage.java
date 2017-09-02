package com.richerpay.zxingcode.zxingcodeforwebview.zxing;

import android.graphics.Bitmap;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.util.Hashtable;

public class DecodeImage {

	public static Result handleQRCodeFormBitmap(Bitmap bitmap) {
        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType,String>();
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
        RGBLuminanceSource source =new RGBLuminanceSource(bitmap);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));  
        QRCodeReader reader2= new QRCodeReader();
        Result result = null;
        try {
        	try {
                result = reader2.decode(bitmap1,hints);
            } catch (ChecksumException e) {
                e.printStackTrace();
            } catch (FormatException e) {
                e.printStackTrace();
            }
        	
        } catch (NotFoundException e) {
                e.printStackTrace();
        } 
        return result;
    }

}
