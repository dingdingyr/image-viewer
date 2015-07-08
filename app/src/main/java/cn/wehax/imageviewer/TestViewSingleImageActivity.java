package cn.wehax.imageviewer;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class TestViewSingleImageActivity extends RoboActivity {

    @InjectView(R.id.imageView)
    ImageView imageView;

    final String imgUrl = "https://www.baidu.com/img/bdlogo.png";

    private DisplayImageOptions options;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_single_image);

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToHelper.viewSingleImage(TestViewSingleImageActivity.this, imgUrl);
            }
        });

        ImageLoader.getInstance().displayImage(imgUrl, imageView, options);
    }
}
