package com.example.bannertest1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Banner banner;
    List<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = findViewById(R.id.banner);

        initData(); // 初始化數據
        initView(); // 初始化 View
    }

    private void initData() {
        // 設置圖片來源
        images = new ArrayList<>();
        images.add("http://img2.1sucai.com/181103/330877-1Q10301445711.jpg");
        images.add("https://uploadfile.huiyi8.com/up/08/4e/6a/084e6a29337e68ddcd0ccf613a2c915d.jpg");
        images.add("https://photo.16pic.com/00/89/75/16pic_8975619_b.jpg");
    }

    private void initView() {
        // 設定圖片下面有圓點點的樣式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        // 把想要呈現的圖片設定到 banner
        banner.setImages(images)
                // 圖片載入
                .setImageLoader(new GlideImageLoader())
                // 設定每張圖片要呈現的時間
                .setDelayTime(3000)
                // 設定 banner 的監聽事件
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(MainActivity.this,"你點擊了：" + position, Toast.LENGTH_SHORT).show();
                    }
                })
                .start();
    }
}
