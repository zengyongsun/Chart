package com.zy.chart.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zy.chart.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 * <p>
 * PopupWindow的扩展
 */

public class CustomPopupWindow extends PopupWindow {

    private Context mContext;
    private RecyclerView mRecyclerView;

    private List<BaseBean> data;
    private List<BaseBean> dataCopy = new ArrayList<>();
    private PopupWindowAdapter mAdapter;
    private OnItemClickListener itemClickListener;

    /**
     * 初始化
     *
     * @param context
     * @param width
     * @param height
     */
    public CustomPopupWindow(Context context, int width, int height) {
        this.mContext = context;
        setWidth(width);
        setHeight(height);
        initView();
    }

    private void initView() {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.popup_window_layout, null);
        setContentView(contentView);
        setBackgroundDrawable(new ColorDrawable(0x00000000));
        setOutsideTouchable(this.isOutsideTouchable());//设置点击外面是否消失，默认为false
        setFocusable(this.isFocusable());
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.popupRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        mRecyclerView.addItemDecoration(new PopItemDecoration(mContext.getResources(),
//            R.color.colorPrimary, R.dimen.pop_item, LinearLayoutManager.VERTICAL));
        mAdapter = new PopupWindowAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<BaseBean> getData() {
        return data;
    }

    public void setData(List<BaseBean> data) {
        this.data = data;
        this.dataCopy.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    class PopupWindowAdapter extends RecyclerView.Adapter<PopupWindowAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.popup_window_item_layout, parent, false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.name.setText(data.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.itemClick(data.get(position));
                    BaseBean bean = data.get(position);
                    data.clear();
                    data.addAll(dataCopy);
                    data.remove(bean);
                    dismiss();
                    mAdapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            BaseBean bean = null;
            for (BaseBean b : data) {
                if (b.getSelect()) {
                    bean = b;
                }
            }
            data.remove(bean);
            dataNoSelect(dataCopy);
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;

            public MyViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.tvName);
            }
        }

    }

    private void dataNoSelect(List<BaseBean> dataList) {
        for (BaseBean data : dataList) {
            data.setSelectValue(false);
        }
    }

    interface OnItemClickListener {
        void itemClick(BaseBean popBean);
    }

}
