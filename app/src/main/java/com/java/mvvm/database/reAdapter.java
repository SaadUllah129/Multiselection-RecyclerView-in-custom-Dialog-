package com.java.mvvm.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.java.mvvm.R;
import com.java.mvvm.database.model.Company;

import java.util.ArrayList;
import java.util.List;

public class reAdapter extends RecyclerView.Adapter<reAdapter.ComidityViewHolder> {
    ArrayList<Company> companyList;
    Context context;

    public reAdapter(Context context){
        this.context = context;

    }

    @Override
    public reAdapter.ComidityViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comodity,parent,false);
        return  new ComidityViewHolder(view);
    }

    @Override
    public void onBindViewHolder( reAdapter.ComidityViewHolder holder, int position) {
        Company company = companyList.get(position);
        ((ComidityViewHolder)holder).tvName.setText(company.getCompanyName());
        holder.bind(company);
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }

    public class ComidityViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private CheckBox isClick;
        private LinearLayout ll_item;

        public ComidityViewHolder(View view) {
            super(view);
            this.isClick = view.findViewById(R.id.cbItem);
            this.tvName = view.findViewById(R.id.tvHeading);
            this.ll_item = view.findViewById(R.id.ll_item);

        }
        void bind(final Company company){
            isClick.setChecked(company.getSelected()?true:false);
            isClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    company.setSelected(!company.getSelected());
                    isClick.setChecked(company.getSelected()?true:false);

                }
            });
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    company.setSelected(!company.getSelected());
                    isClick.setChecked(company.getSelected()?true:false);
                }
            });
        }

    }
    public ArrayList<Company> getAll(){
        return companyList;
    }
    public ArrayList<Company> getSelected(){
        ArrayList<Company> itemSelected = new ArrayList<>();
        for (int i = 0; i<companyList.size();i++){
            if (companyList.get(i).getSelected()){
                itemSelected.add(companyList.get(i));
            }
        }
        return itemSelected;
    }

    public void setCompanyList(ArrayList<Company> companyList) {
        this.companyList = companyList;
        notifyDataSetChanged();
    }
}
