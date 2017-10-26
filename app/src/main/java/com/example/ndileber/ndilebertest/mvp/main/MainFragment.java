package com.example.ndileber.ndilebertest.mvp.main;

import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.drcosu.ndileber.mvp.ubase.UBaseFragment;
import com.example.ndileber.ndilebertest.R;
import com.example.ndileber.ndilebertest.mvp.home.HomeContract;
import com.example.ndileber.ndilebertest.mvp.home.HomePresenter;
import com.example.ndileber.ndilebertest.mvp.main.recycle.DividerGridItemDecoration;
import com.example.ndileber.ndilebertest.mvp.main.recycle.DividerItemDecoration;
import com.example.ndileber.ndilebertest.mvp.main.recycle.MyAdapter;
import com.example.ndileber.ndilebertest.mvp.main.recycle.OnRecyclerItemClickListener;
import com.example.ndileber.ndilebertest.mvp.main.recycle.Subject;
import com.example.ndileber.ndilebertest.mvp.main.recycle.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainFragment extends UBaseFragment< MainPresenter> implements  MainContract.View< MainPresenter> {

    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"};
    private List<Subject> datas = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;
    private MyAdapter myAdapter;

    public MainFragment() {
    }

    SwipeRecyclerView recycler;

    @Override
    protected void initView(Bundle bundle) {
        initData();

        recycler = findView(R.id.recycler);
        recycler.setHasFixedSize(true);


        //recycler.setLayoutManager(new LinearLayoutManager(getActivityContext()));
//        recycler.addItemDecoration(new DividerItemDecoration(getActivityContext(), DividerItemDecoration.VERTICAL_LIST));
        recycler.setLayoutManager(new GridLayoutManager(getActivityContext(), 4));
        recycler.addItemDecoration(new DividerGridItemDecoration(getActivityContext()));
        myAdapter = new MyAdapter(datas, getActivityContext());
        recycler.setAdapter(myAdapter);
        recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(recycler) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Toast.makeText(getActivityContext(), datas.get(vh.getLayoutPosition()).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh) {
                //判断被拖拽的是否是前两个，如果不是则执行拖拽
                if (vh.getLayoutPosition() != 0 && vh.getLayoutPosition() != 1) {
                    mItemTouchHelper.startDrag(vh);

                    //获取系统震动服务
                    Vibrator vib = (Vibrator) getActivityContext().getSystemService(Service.VIBRATOR_SERVICE);//震动70毫秒
                    vib.vibrate(70);

                }
            }
        });

        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            /**
             * 是否处理滑动事件 以及拖拽和滑动的方向 如果是列表类型的RecyclerView的只存在UP和DOWN，如果是网格类RecyclerView则还应该多有LEFT和RIGHT
             * @param recyclerView
             * @param viewHolder
             * @return
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                } else {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    final int swipeFlags = 0;
//                    final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //得到当拖拽的viewHolder的Position
                int fromPosition = viewHolder.getAdapterPosition();
                //拿到当前拖拽到的item的viewHolder
                int toPosition = target.getAdapterPosition();
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(datas, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(datas, i, i - 1);
                    }
                }
                myAdapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                myAdapter.notifyItemRemoved(position);
//                datas.remove(position);
            }

            /**
             * 重写拖拽可用
             * @return
             */
            @Override
            public boolean isLongPressDragEnabled() {
                return false;
            }

            /**
             * 长按选中Item的时候开始调用
             *
             * @param viewHolder
             * @param actionState
             */
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            /**
             * 手指松开的时候还原
             * @param recyclerView
             * @param viewHolder
             */
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }
        });

        mItemTouchHelper.attachToRecyclerView(recycler);

        recycler.setRightClickListener(new SwipeRecyclerView.OnRightClickListener() {
            @Override
            public void onRightClick(int position, String id) {
                datas.remove(position);
//                myAdapter.notifyItemRemoved(position);
                myAdapter.notifyDataSetChanged();
                Toast.makeText(getActivityContext(), " position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    protected boolean retain() {
        return false;
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected MainPresenter createPresenterInstance() {
        return new MainPresenter(this);
    }

    @Override
    public int layoutViewId() {
        return R.layout.fragment_main;
    }

    private void initData() {
        //初始化data
        for (int i = 0; i < titles.length; i++) {
            //动态获取资源ID，第一个参数是资源名，第二个参数是资源类型例如drawable，string等，第三个参数包名
            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", getActivityContext().getPackageName());
            datas.add(new Subject(titles[i], imageId));
        }

    }

}
