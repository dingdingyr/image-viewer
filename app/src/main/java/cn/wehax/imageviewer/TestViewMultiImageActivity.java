package cn.wehax.imageviewer;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * 浏览图片活动页
 * <p>说明：</p>
 * 仿微信设计
 */
public class TestViewMultiImageActivity extends RoboActivity {
    final String IMAGE_URL = "https://www.baidu.com/img/bdlogo.png";

    @InjectView(R.id.grid_view)
    GridView gridView;

    List<String> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_multi_image);

        initDummyData();

        gridView.setAdapter(new MyAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MoveToHelper.viewMultiImage(TestViewMultiImageActivity.this, data, position);
            }
        });
    }

    private void initDummyData() {
        for (int i = 0; i < 10; ++i) {
            data.add(IMAGE_URL);
        }
    }

    public class MyAdapter extends BaseAdapter {

        private DisplayImageOptions options;

        public MyAdapter() {
            options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView view;

            if(convertView == null){
                view = (ImageView) LayoutInflater.
                        from(TestViewMultiImageActivity.this).
                        inflate(R.layout.item_grid_view, null);
            }else{
                view = (ImageView) convertView;
            }

            ImageLoader.getInstance().displayImage(getItem(position), view, options);

            return view;
        }
    }


}
