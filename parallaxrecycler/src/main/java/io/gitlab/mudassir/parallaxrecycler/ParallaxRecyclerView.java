package io.gitlab.mudassir.parallaxrecycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ParallaxRecyclerView extends RecyclerView {

	public static final class Adapter extends RecyclerView.Adapter<Holder> {

		public interface Binder {
			void onBind(Holder holder, int position);
		}

		private int count;
		private int layoutResId;
		private int imgResId;
		private Binder binder;

		public Adapter(int count, int layoutResId, int imgResId, Binder binder) {
			this.count = count;
			this.layoutResId = layoutResId;
			this.imgResId = imgResId;
			this.binder = binder;
		}

		@Override
		public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
			return new Holder(LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false), imgResId);
		}

		@Override
		public void onBindViewHolder(Holder holder, int position) {
			binder.onBind(holder, position);
		}

		@Override
		public int getItemCount() {
			return count;
		}
	}

	public static final class Holder extends RecyclerView.ViewHolder {

		private View root;
		private ImageView imageView;

		public Holder(View itemView, int id) {
			super(itemView);
			itemView.setTag(this);
			imageView = (ImageView) itemView.findViewById(id);
			root = itemView;
		}

		public ImageView getImageView() {
			return imageView;
		}

		public View getRootView() {
			return root;
		}
	}

	public ParallaxRecyclerView(Context context) {
		this(context, null);
	}

	public ParallaxRecyclerView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ParallaxRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void init(Context context) {
		setLayoutManager(new LinearLayoutManager(context));
		addOnScrollListener(new ParallaxScroller());
	}
}
