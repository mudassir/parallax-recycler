# Parallax Recycler
An Android library that provides a parallax effect on images while scrolling.

Adapted from https://github.com/bopbi/RecyclerParallax

## Sample Usage

### Import
```gradle
compile 'io.gitlab.mudassir:parallaxrecycler:0.1'
```

### Activity
```java
protected void onCreate(Bundle savedInstanceState) {
  ...
	Adapter.Binder binder = new Adapter.Binder() {
		@Override
		public void onBind(ParallaxRecyclerView.Holder holder, int position) {
			// TODO
		}
	};

	ParallaxRecyclerView recyclerView = (ParallaxRecyclerView) findViewById(R.id.recycler_view);
	recyclerView.init(this);
	recyclerView.setAdapter(new Adapter(count, R.layout.recycler_layout, R.id.image_view, binder));
	...
}
```

### Layout File
```xml
...
<!-- recycler_layout.xml -->
<ImageView
	android:id="@+id/image_view"
	android:layout_width="match_parent"
	android:layout_height="wrap_content" />
...
```

