package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import io.gitlab.mudassir.parallaxrecycler.ParallaxRecyclerView;
import io.gitlab.mudassir.parallaxrecycler.ParallaxRecyclerView.Adapter;

public class MainActivity extends AppCompatActivity {

	private int[] ids = {
			R.drawable.img0,
			R.drawable.img1,
			R.drawable.img2,
			R.drawable.img3,
			R.drawable.img4,
			R.drawable.img5,
			R.drawable.img6,
			R.drawable.img7,
			R.drawable.img8,
			R.drawable.img9,
			R.drawable.img10,
			R.drawable.img11,
			R.drawable.img12
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Adapter.Binder binder = new Adapter.Binder() {
			@Override
			public void onBind(ParallaxRecyclerView.Holder holder, int position) {
				Glide.with(MainActivity.this)
						.load(ids[position])
						.into(holder.getImageView());
			}
		};

		ParallaxRecyclerView recyclerView = (ParallaxRecyclerView) findViewById(R.id.recycler_view);
		recyclerView.init(this);
		recyclerView.setAdapter(new Adapter(13, R.layout.recycler_layout, R.id.image_view, binder));
	}
}
