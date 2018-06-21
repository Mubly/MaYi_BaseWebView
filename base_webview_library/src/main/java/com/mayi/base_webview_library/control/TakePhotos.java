package com.mayi.base_webview_library.control;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.ArrayMap;
import android.widget.Toast;

import com.mayi.base_webview_library.utils.JUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Hezier on 2017/11/14.
 */

public class TakePhotos {
    public final static String SAVED_IMAGE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();

    public static void takePhotos(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

        } else {
            JUtils.Toast(context, "SD卡未挂起");
        }
    }

//    //图片上传
//    public static void upLoadImage(File file, final Context context, final OneCallback callback) {
//        UploadImage uploadImage = new UploadImage();
//        uploadImage.uploadHeadImage(URLConstant.UPLOAD_IMAGE_URL, file, context, new UploadImage.uploadCallBack() {
//            @Override
//            public void isSuccess(boolean isSuccess, Object url) {
//                try {
//                    if (isSuccess && !ObjectUtil.isNullObject(url)) {
//                        RequestResult requestResult = (RequestResult) url;
//                        if (requestResult.getCode() == 200) {
//                            JsonResult jsonResult = JsonResultControl.getJsonResult(requestResult.getData());
//                            if (jsonResult.isOk()) {
//                                callback.callBack(jsonResult.getData());
//                            } else {
//                                callback.callBack(null);
//                                JUtils.Toast(context, jsonResult.getMessage());
//                            }
//                        } else {
//                            JUtils.Toast(context, requestResult.getMsg());
//                        }
//
//                    } else {
//                        callback.callBack(null);
//                        JUtils.Toast(context, "网络错误");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    //照片提交
//    public static void photosAck(final Activity context, List<PhotoInfo> photoInfoList, final OneCallback callback) {
//        Map<String, String> map = new ArrayMap<>();
//        String photoInfoStr = JSON.toJSONString(photoInfoList);
//        map.put("photoInfo", photoInfoStr);
//        DataUtils.upLoadPhotoList(context, map, new NetWorkTask.SuccessCallBack() {
//            @Override
//            public void isSuccess(boolean result, Object object) {
//                if (result && !ObjectUtil.isNullObject(object)) {
//                    RequestResult requestResult = (RequestResult) object;
//                    if (JsonResultControl.isValiResult(requestResult, context)) {
//                        JsonResult jsonResult = (JsonResult) ToolUtils.json2Object(requestResult.getData(), JsonResult.class);
//                        if (jsonResult.isOk()) {
//                            callback.callBack(true);
//                        } else {
//                            JUtils.Toast(context, jsonResult.getMessage());
//                            callback.callBack(false);
//                        }
//                    } else {
//                        JUtils.Toast(context, requestResult.getMsg());
//                        callback.callBack(false);
//                    }
//                } else {
//                    JUtils.Toast(context, "网络错误");
//                    callback.callBack(false);
//                }
//            }
//        });
//    }

//    //图片上传
//    public static void upLoadImage(String photoPath, Context context, final ImageUpLoadForResult imageUpLoadForResult) {
//        File photoFile = new File(photoPath);
//        if (photoFile.exists()) {
//
//            //通过图片地址将图片加载到bitmap里面
//            try {
//                Bitmap bm = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
////          添加日期水印并压缩
//                photoFile = ImageUtils.compressImage(ImageUtils.addTimeFlag(bm), "");
//                upLoadImage(photoFile, context, new OneCallback() {
//                    @Override
//                    public void callBack(Object object) {
//                        if (!ObjectUtil.isNullObject(object)) {
//                            String data = (String) object;
//                            PhotoVo photoVo = (PhotoVo) ToolUtils.json2Object(data, PhotoVo.class);
//                            imageUpLoadForResult.success(photoVo);
//                        } else {
//                            imageUpLoadForResult.failure("上传失败");
//                        }
//                    }
//                });
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            Toast.makeText(context, "没有图片数据", Toast.LENGTH_SHORT).show();
//        }
//    }

    //拍照
//    public static void getCamer(int camerType, int requstCode, CatchCamer catchCamer, Activity context) {
//        String SAVED_IMAGE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            //设置图片保存路径
//            String photoPath = SAVED_IMAGE_PATH + "/" + System.currentTimeMillis() + ".png";
//            File imageDir = new File(photoPath);
//            if (!imageDir.getParentFile().exists()) {
//                imageDir.getParentFile().mkdirs();
//            }
//            if (!imageDir.exists()) {
//                //根据一个 文件地址生成一个新的文件用来存照片
//                try {
//                    imageDir.createNewFile();
//                    int currentapiVersion = android.os.Build.VERSION.SDK_INT;
//                    //根据路径实例化图片文件
//                    File photoFile = new File(photoPath);
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
////                    JUtils.Toast(context, camerType + "");
//                    if (camerType == 1) {
//                        intent.putExtra("android.intent.extras.CAMERA_FACING", camerType); // 调用前置摄像头
//                    } else {
//                        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
//                    }
//
////                    intent.putExtra("camerasensortype", 2);
//                    if (currentapiVersion < 24) {
//                        //设置拍照后图片保存到文件中
//                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
//                        //启动拍照activity并获取返回数据
//                        context.startActivityForResult(intent, requstCode);
//                    } else {
//                        ContentValues contentValues = new ContentValues(1);
//                        contentValues.put(MediaStore.Images.Media.DATA, photoFile.getAbsolutePath());
//                        Uri uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
//                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//                        context.startActivityForResult(intent, requstCode);
//                    }
//                    catchCamer.success(photoPath);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            catchCamer.failure("SD卡未插入");
//        }
//    }
}
