package com.tokyonth.tools;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Environment;
import android.text.InputFilter;

public class MainActivity extends Activity 
{
	EditText ed1,ed2;
	ImageView img;
	String aa;
	Bitmap bb;
	Bitmap cc;
    double dd;
	File file;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		 file = new File(Environment.getExternalStorageDirectory().toString()+"/加密");
		if (!file.exists()) {
            file.mkdirs();
        }
		ed1=findViewById(R.id.mainEditText1);
		ed2=findViewById(R.id.mainEditText2);
		img=findViewById(R.id.mainImageView1);
		//ed2.setFilters(new InputFilter[]{new NotChineseFilter(), new InputFilter.LengthFilter(4)}); //限制输入4位
		
    }
	public void choose(View v){//选择

		Intent it = new Intent(Intent.ACTION_PICK);
		it.setType("image/*");
		startActivityForResult(it, 1000);
	}
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == 1000 && resultCode == RESULT_OK){
		 aa = RealPathFromUriUtils.getRealPathFromUri(this, data.getData());
		 bb=BitmapFactory.decodeFile(aa);
		  img.setImageBitmap(bb);
		 toa("选择成功");
		}
	}
	
   public void jm(View v){//加密
   toa("开始加密");
	   dd=Double.parseDouble("0."+ed2.getText().toString());
	   new Thread(new Runnable(){

			   @Override
			   public void run()
			   {
				   cc=HandleBitmap.Encrypt(dd,bb);
				   runOnUiThread(new Runnable(){

						   @Override
						   public void run()
						   {
							   img.setImageBitmap(cc);
						   }
					   });
			   }
		   }).start();
   }
   public void jmm(View v){//解密
   toa("开始解密");
	   dd=Double.parseDouble("0."+ed2.getText().toString());
	   
	   new Thread(new Runnable(){

			   @Override
			   public void run()
			   {
				    cc=HandleBitmap.Decrypt(dd,bb);
				   runOnUiThread(new Runnable(){

						   @Override
						   public void run()
						   {
							   img.setImageBitmap(cc);
						   }
					   });
			   }
		   }).start();
   }
    public void save(View v){
		try
		{
			toa("保存成功"+saveBitmap(cc).toString());
			
		}
		catch (IOException e)
		{
			toa("出错"+e.getMessage());
			}
	}
	public  File saveBitmap(Bitmap mBitmap) throws IOException {
        File filePic=new File(file.toString()+"/"+System.currentTimeMillis()+"压缩.png");
		FileOutputStream fos = new FileOutputStream(filePic);
		mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
		fos.flush();
		fos.close();
		return filePic;
    }
	private void toa(String in){
		Toast.makeText(this,in,10).show();
		
	}
}
