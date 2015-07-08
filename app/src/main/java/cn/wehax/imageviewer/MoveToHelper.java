package cn.wehax.imageviewer;

import android.app.Activity;
import android.content.Intent;

import java.util.List;

/**
 * 本助手提供所有页面之间的跳转方法
 * <p/>
 * <p/>
 * 注释：为什么使用本助手？
 * 通过查看本助手即可知道如何跳转到具体某个页面。
 */
public class MoveToHelper {
    /**
     * 浏览单个图片
     * @param act
     * @param imgUrl
     */
    public static void viewSingleImage(Activity act, String imgUrl) {
        String[] array = new String[]{imgUrl};
        viewMultiImage(act, array, 0);
    }

    /**
     * 浏览多个图片
     * @param act
     * @param imgUrls
     * @param position
     */
    public static void viewMultiImage(Activity act, List<String> imgUrls, int position) {
        String[] array = new String[imgUrls.size()];
        imgUrls.toArray(array);
        viewMultiImage(act, array, position);
    }

    public static void viewMultiImage(Activity act,
                                      String[] imgUrls, int position) {
        Intent intent = new Intent(act, ImageViewerActivity.class);
        intent.putExtra(ImageViewerActivity.KEY_IMG_URLS, imgUrls);
        intent.putExtra(ImageViewerActivity.KEY_POSITON, position);
        act.startActivity(intent);
    }


}
