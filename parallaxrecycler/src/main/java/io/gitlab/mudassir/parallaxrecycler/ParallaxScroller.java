package io.gitlab.mudassir.parallaxrecycler;

import android.graphics.Matrix;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

/**
 * Adapted from https://github.com/bopbi/RecyclerParallax/blob/master/app/src/main/java/com/arjunalabs/android/recyclerparallax/ParallaxScrollListener.java
 */
public class ParallaxScroller extends RecyclerView.OnScrollListener {

	private static final float SCROLL_SPEED = 0.9f;

	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

		int firstVisible = layoutManager.findFirstVisibleItemPosition();
		int visibleCount = Math.abs(firstVisible - layoutManager.findLastVisibleItemPosition());

		Matrix imageMatrix;
		float tempSpeed = 0;

		if (dy > 0) {
			tempSpeed = SCROLL_SPEED;
		} else if (dy < 0) {
			tempSpeed = -SCROLL_SPEED;
		}

		for (int i = firstVisible; i < (firstVisible + visibleCount); i++) {
			ImageView imageView = ((ParallaxRecyclerView.Holder) recyclerView.getLayoutManager().findViewByPosition(i).getTag()).getImageView();
			imageMatrix = imageView.getImageMatrix();
			imageMatrix.postTranslate(0, tempSpeed);
			imageView.setImageMatrix(imageMatrix);
			imageView.invalidate();
		}
	}
}
